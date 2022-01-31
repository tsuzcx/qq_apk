public class bfbj
{
  private static bfbj a;
  
  public static bfbj a()
  {
    try
    {
      if (a == null) {
        a = new bfbj();
      }
      bfbj localbfbj = a;
      return localbfbj;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    bfnz.a(paramString);
  }
  
  public void b(String paramString)
  {
    bfnz.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbj
 * JD-Core Version:    0.7.0.1
 */