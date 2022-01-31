public class bhnt
{
  public static void a(Object paramObject)
  {
    a((String)null, paramObject);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      throw new AssertionError();
    }
    throw new AssertionError(paramString);
  }
  
  public static void a(String paramString, Object paramObject)
  {
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramString, bool);
      return;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a((String)null, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhnt
 * JD-Core Version:    0.7.0.1
 */