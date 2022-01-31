public class bbti
{
  private static bfiz a;
  
  private static bfiz a()
  {
    try
    {
      if (a == null)
      {
        a = new bfiz();
        a.a("OpenLog");
        a.a(4);
      }
      bfiz localbfiz = a;
      return localbfiz;
    }
    finally {}
  }
  
  public static bfiz a(String paramString1, int paramInt, String paramString2)
  {
    return a().c(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbti
 * JD-Core Version:    0.7.0.1
 */