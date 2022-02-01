import android.os.SystemClock;

public class argb
{
  private long a;
  private long b;
  private long c;
  
  public long a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
  }
  
  public long b()
  {
    this.b = (SystemClock.uptimeMillis() - this.c);
    this.a += this.b;
    b();
    return this.b;
  }
  
  public void b()
  {
    this.c = SystemClock.uptimeMillis();
  }
  
  public long c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argb
 * JD-Core Version:    0.7.0.1
 */