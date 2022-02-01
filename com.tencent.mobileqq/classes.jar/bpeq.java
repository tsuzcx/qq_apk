import android.graphics.Bitmap;

public class bpeq
{
  private static boolean[] a;
  public int a;
  public Bitmap a;
  public String a;
  public boolean a;
  public Bitmap b;
  public String b;
  public boolean b;
  public boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfBoolean = new boolean[5];
  }
  
  public bpeq(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void a(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 5) {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 5))
      {
        jdField_a_of_type_ArrayOfBoolean[i] = false;
        i += 1;
      }
      else
      {
        boolean[] arrayOfBoolean = jdField_a_of_type_ArrayOfBoolean;
        int k = arrayOfBoolean[i];
        if (paramArrayOfInt[i] > 0) {}
        for (int j = 1;; j = 0)
        {
          arrayOfBoolean[i] = (j | k);
          break;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 4)) {
      return true;
    }
    return jdField_a_of_type_ArrayOfBoolean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpeq
 * JD-Core Version:    0.7.0.1
 */