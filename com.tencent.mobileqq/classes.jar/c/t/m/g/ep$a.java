package c.t.m.g;

final class ep$a
{
  public static final a e = new a();
  final Object a;
  public String b;
  public long c;
  public int d = -1;
  private int f;
  private final byte[] g;
  private String h;
  private int i = 1;
  
  private ep$a()
  {
    this.f = 0;
    this.g = null;
    this.h = null;
    this.a = null;
  }
  
  ep$a(int paramInt, byte[] paramArrayOfByte, String paramString, Object paramObject)
  {
    this.f = paramInt;
    this.g = paramArrayOfByte;
    this.h = paramString;
    this.a = paramObject;
    if (3 == paramInt) {
      this.i = 3;
    }
  }
  
  public final String toString()
  {
    return "type=" + this.f + ",url=" + this.h + ",coorType=" + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ep.a
 * JD-Core Version:    0.7.0.1
 */