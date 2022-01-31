public class bfli
  extends bflj
{
  private String n;
  
  public static bfli a()
  {
    return new bfli();
  }
  
  public bfli a(String paramString)
  {
    this.n = paramString;
    return this;
  }
  
  public String a()
  {
    return b() + "|" + c() + "|" + this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfli
 * JD-Core Version:    0.7.0.1
 */