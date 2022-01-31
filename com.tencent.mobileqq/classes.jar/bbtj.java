public class bbtj
{
  private static bbtj a;
  
  public static bbtj a()
  {
    try
    {
      if (a == null) {
        a = new bbtj();
      }
      bbtj localbbtj = a;
      return localbbtj;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    bcgd.a(paramString);
  }
  
  public void b(String paramString)
  {
    bcgd.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbtj
 * JD-Core Version:    0.7.0.1
 */