import java.lang.reflect.Array;

public class asle
{
  static asle[][] a;
  public int a;
  public int b;
  
  static
  {
    jdField_a_of_type_Array2dOfAsle = (asle[][])Array.newInstance(asle.class, new int[] { 3, 3 });
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        jdField_a_of_type_Array2dOfAsle[i][j] = new asle(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private asle(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static asle a(int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt1, paramInt2);
      asle localasle = jdField_a_of_type_Array2dOfAsle[paramInt1][paramInt2];
      return localasle;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2)) {
      throw new IllegalArgumentException("row must be in range 0-2");
    }
    if ((paramInt2 < 0) || (paramInt2 > 2)) {
      throw new IllegalArgumentException("column must be in range 0-2");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return "(row=" + this.jdField_a_of_type_Int + ",clmn=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asle
 * JD-Core Version:    0.7.0.1
 */