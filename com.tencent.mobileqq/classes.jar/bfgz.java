public class bfgz
  extends bfha
{
  private String n;
  
  public static bfgz a()
  {
    return new bfgz();
  }
  
  public bfgz a(String paramString)
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
 * Qualified Name:     bfgz
 * JD-Core Version:    0.7.0.1
 */