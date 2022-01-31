public class bcdl
  extends bcdm
{
  private String n;
  
  public static bcdl a()
  {
    return new bcdl();
  }
  
  public bcdl a(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public String a()
  {
    return b() + "|" + c() + "|" + this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcdl
 * JD-Core Version:    0.7.0.1
 */