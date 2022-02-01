public class arvu
{
  private long a;
  private long b;
  
  public arvu(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public arvu a()
  {
    return new arvu(this.b);
  }
  
  public void a(float paramFloat)
  {
    this.b = (((float)this.b * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvu
 * JD-Core Version:    0.7.0.1
 */