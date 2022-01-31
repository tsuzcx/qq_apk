public class bdib
  extends bdic
{
  private String n;
  
  public static bdib a()
  {
    return new bdib();
  }
  
  public bdib a(String paramString)
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
 * Qualified Name:     bdib
 * JD-Core Version:    0.7.0.1
 */