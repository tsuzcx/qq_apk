public class bfbi
{
  private static biwo a;
  
  private static biwo a()
  {
    try
    {
      if (a == null)
      {
        a = new biwo();
        a.a("OpenLog");
        a.a(4);
      }
      biwo localbiwo = a;
      return localbiwo;
    }
    finally {}
  }
  
  public static biwo a(String paramString1, int paramInt, String paramString2)
  {
    return a().c(paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbi
 * JD-Core Version:    0.7.0.1
 */