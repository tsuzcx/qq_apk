import java.lang.reflect.Array;

public class avhn
{
  static avhn[][] a;
  public int a;
  public int b;
  
  static
  {
    jdField_a_of_type_Array2dOfAvhn = (avhn[][])Array.newInstance(avhn.class, new int[] { 3, 3 });
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        jdField_a_of_type_Array2dOfAvhn[i][j] = new avhn(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private avhn(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static avhn a(int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt1, paramInt2);
      avhn localavhn = jdField_a_of_type_Array2dOfAvhn[paramInt1][paramInt2];
      return localavhn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhn
 * JD-Core Version:    0.7.0.1
 */