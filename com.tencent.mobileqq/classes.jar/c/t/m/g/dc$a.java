package c.t.m.g;

final class dc$a
{
  private int a = 65536;
  private int b;
  
  public dc$a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int a(String paramString)
  {
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = this.b;
      j = paramString.charAt(i) + m * j;
      i += 1;
    }
    return this.a - 1 & j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dc.a
 * JD-Core Version:    0.7.0.1
 */