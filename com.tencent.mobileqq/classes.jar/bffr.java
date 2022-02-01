public final class bffr
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public int d;
  
  public static long a(int paramInt, long paramLong1, long paramLong2)
  {
    if (a(paramInt)) {
      return paramLong1;
    }
    return paramLong2;
  }
  
  public static bffr a(int paramInt1, long paramLong, int paramInt2)
  {
    bffr localbffr = new bffr();
    localbffr.jdField_a_of_type_Int = bffq.jdField_a_of_type_Int;
    a(paramInt1, paramLong, localbffr);
    localbffr.c = paramInt1;
    localbffr.d = paramInt2;
    return localbffr;
  }
  
  public static void a(int paramInt, long paramLong, bffr parambffr)
  {
    if (a(paramInt))
    {
      parambffr.jdField_a_of_type_Long = paramLong;
      return;
    }
    parambffr.b = paramLong;
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 22) || (paramInt == 17) || (paramInt == 100) || (paramInt == 11) || (paramInt == 10);
  }
  
  public long a()
  {
    return a(this.c, this.jdField_a_of_type_Long, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffr
 * JD-Core Version:    0.7.0.1
 */