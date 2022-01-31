public class bdhm
  extends bdhn
{
  private String n;
  
  public static bdhm a()
  {
    return new bdhm();
  }
  
  public bdhm a(String paramString)
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
 * Qualified Name:     bdhm
 * JD-Core Version:    0.7.0.1
 */