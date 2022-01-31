public class amrg
{
  private long a;
  private long b;
  
  public amrg(long paramLong)
  {
    this.b = paramLong;
    this.a = this.b;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public amrg a()
  {
    return new amrg(this.b);
  }
  
  public void a(float paramFloat)
  {
    this.b = (((float)this.b * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amrg
 * JD-Core Version:    0.7.0.1
 */