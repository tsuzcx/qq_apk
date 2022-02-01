public class artd
{
  private long a;
  private long b;
  
  public artd(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public artd a()
  {
    return new artd(this.b);
  }
  
  public void a(float paramFloat)
  {
    this.b = (((float)this.b * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artd
 * JD-Core Version:    0.7.0.1
 */