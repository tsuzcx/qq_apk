public class bjtq
  extends bjtr
{
  private String n;
  
  public static bjtq a()
  {
    return new bjtq();
  }
  
  public bjtq a(String paramString)
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
 * Qualified Name:     bjtq
 * JD-Core Version:    0.7.0.1
 */