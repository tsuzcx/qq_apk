public class bfkp
{
  public static String a(String paramString)
  {
    String str = paramString;
    int i;
    if (a(paramString)) {
      i = paramString.length() - 1;
    }
    for (;;)
    {
      if ((i < 0) || (paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/'))
      {
        str = paramString.substring(i + 1);
        return str;
      }
      i -= 1;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if ((paramString.charAt(i) == '\\') || (paramString.charAt(i) == '/')) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfkp
 * JD-Core Version:    0.7.0.1
 */