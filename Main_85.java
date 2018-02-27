import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

     //   int [][] matrix= {{0,0},{1,0}};
    ///    System.out.println(matrix[0][0]);
      //  System.out.println(matrix[0][1]);System.out.println(matrix[1][0]);System.out.println(matrix[1][1]);
        System.out.println(detectArea(matrix));
       /*    for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " \t");
                if(j==2-1)
                    System.out.println();
            }
        }*/

    }


    public static int detectArea(int[][] matrix) {

        int length= matrix.length;
        if(length == 0){
            return 0;
        }
        int[][] n = new int[length][length];
        int max = 0;
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(matrix[i][j] == 1){
                    if(j == 0){
                        n[i][j] = 1;
                    }else{
                       n [i][j] = n[i][j-1] + 1;
                    }
                }
            }
        }

        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++){
                if(n[i][j] != 0){
                    int min = i;
                    int width = n[i][j];
                    while(min >= 0){
                        width = Math.min(width, n[min][j]);
                        int area = width * (i-min+1);
                        max = Math.max(max, area);
                        min--;
                    }
                }
            }
        }

        return max;
    }

}
