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
    int i = 0;
    int k = paramString.length();
    int j = 0;
    while (i < k)
    {
      j = j * this.b + paramString.charAt(i);
      i += 1;
    }
    return this.a - 1 & j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.dc.a
 * JD-Core Version:    0.7.0.1
 */