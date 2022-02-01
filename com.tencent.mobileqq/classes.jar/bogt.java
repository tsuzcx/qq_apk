public class bogt
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  
  public static bogt a()
  {
    return bogv.a;
  }
  
  public long a(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
    if (this.e >= this.b) {
      return this.c + this.a;
    }
    if (paramBoolean) {
      return this.c + this.a % this.e;
    }
    return this.c + this.a;
  }
  
  public long a(boolean paramBoolean)
  {
    return a(this.a, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = (paramLong2 - paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogt
 * JD-Core Version:    0.7.0.1
 */