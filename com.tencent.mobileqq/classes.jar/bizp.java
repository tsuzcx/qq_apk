public class bizp
{
  private static bizp a;
  
  public static bizp a()
  {
    try
    {
      if (a == null) {
        a = new bizp();
      }
      bizp localbizp = a;
      return localbizp;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    bjmq.a(paramString);
  }
  
  public void b(String paramString)
  {
    bjmq.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizp
 * JD-Core Version:    0.7.0.1
 */