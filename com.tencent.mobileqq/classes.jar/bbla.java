public final class bbla
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  
  public static bbla a(int paramInt1, long paramLong, int paramInt2)
  {
    bbla localbbla = new bbla();
    localbbla.jdField_a_of_type_Int = bbkz.jdField_a_of_type_Int;
    if ((paramInt1 == 1) || (paramInt1 == 22) || (paramInt1 == 17) || (paramInt1 == 100) || (paramInt1 == 11) || (paramInt1 == 10)) {
      localbbla.jdField_a_of_type_Long = paramLong;
    }
    for (;;)
    {
      localbbla.c = paramInt1;
      localbbla.d = paramInt2;
      return localbbla;
      localbbla.b = paramLong;
    }
  }
  
  public long a()
  {
    if ((this.c == 1) || (this.c == 22) || (this.c == 17) || (this.c == 100) || (this.c == 11)) {
      return this.jdField_a_of_type_Long;
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbla
 * JD-Core Version:    0.7.0.1
 */