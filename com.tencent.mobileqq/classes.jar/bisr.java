public class bisr
  extends biss
{
  private String n;
  
  public static bisr a()
  {
    return new bisr();
  }
  
  public bisr a(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public String a()
  {
    return b() + "|" + c() + "|" + this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bisr
 * JD-Core Version:    0.7.0.1
 */