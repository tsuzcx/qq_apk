public class bhow
{
  private static bhow a;
  
  public static bhow a()
  {
    try
    {
      if (a == null) {
        a = new bhow();
      }
      bhow localbhow = a;
      return localbhow;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    bibo.a(paramString);
  }
  
  public void b(String paramString)
  {
    bibo.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhow
 * JD-Core Version:    0.7.0.1
 */