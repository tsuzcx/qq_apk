public class bcxy
{
  private static bcxy a;
  
  public static bcxy a()
  {
    try
    {
      if (a == null) {
        a = new bcxy();
      }
      bcxy localbcxy = a;
      return localbcxy;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    bdkt.a(paramString);
  }
  
  public void b(String paramString)
  {
    bdkt.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcxy
 * JD-Core Version:    0.7.0.1
 */