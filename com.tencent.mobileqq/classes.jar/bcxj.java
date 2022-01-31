public class bcxj
{
  private static bcxj a;
  
  public static bcxj a()
  {
    try
    {
      if (a == null) {
        a = new bcxj();
      }
      bcxj localbcxj = a;
      return localbcxj;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    bdke.a(paramString);
  }
  
  public void b(String paramString)
  {
    bdke.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcxj
 * JD-Core Version:    0.7.0.1
 */