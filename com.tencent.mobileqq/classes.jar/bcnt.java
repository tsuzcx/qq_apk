public class bcnt
{
  private static bcnu a = new bcnu();
  
  public static void a(bcnu parambcnu)
  {
    if (parambcnu != null)
    {
      a = parambcnu;
      return;
    }
    a = new bcnu();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a.a(paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a.a(paramString1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a.b(paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a.c(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcnt
 * JD-Core Version:    0.7.0.1
 */