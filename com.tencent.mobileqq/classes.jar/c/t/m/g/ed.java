package c.t.m.g;

public final class ed
{
  public final float a;
  public final float b;
  public final float c;
  private final long d;
  private final long e;
  
  public ed(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d = paramLong1;
    this.e = paramLong2;
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public final float a()
  {
    return (float)Math.sqrt(Math.pow(this.a, 2.0D) + Math.pow(this.b, 2.0D) + Math.pow(this.c, 2.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ed
 * JD-Core Version:    0.7.0.1
 */