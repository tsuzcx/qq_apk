import java.lang.reflect.Array;

public class avor
{
  static avor[][] a;
  public int a;
  public int b;
  
  static
  {
    jdField_a_of_type_Array2dOfAvor = (avor[][])Array.newInstance(avor.class, new int[] { 3, 3 });
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        jdField_a_of_type_Array2dOfAvor[i][j] = new avor(i, j);
        j += 1;
      }
      i += 1;
    }
  }
  
  private avor(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static avor a(int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt1, paramInt2);
      avor localavor = jdField_a_of_type_Array2dOfAvor[paramInt1][paramInt2];
      return localavor;
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
 * Qualified Name:     avor
 * JD-Core Version:    0.7.0.1
 */