public class bjji
{
  private static bjji a;
  
  public static bjji a()
  {
    try
    {
      if (a == null) {
        a = new bjji();
      }
      bjji localbjji = a;
      return localbjji;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    bjwg.a(paramString);
  }
  
  public void b(String paramString)
  {
    bjwg.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjji
 * JD-Core Version:    0.7.0.1
 */