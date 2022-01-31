import android.text.TextUtils;

public class bfgg
{
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!b(paramString)) && (!c(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("https://m.q.qq.com/a/")) && (!paramString.startsWith("http://m.q.qq.com/a/"))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    return (e(paramString)) || (d(paramString)) || (f(paramString));
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://miniapp/open?");
  }
  
  private static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://microapp/open?");
  }
  
  private static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("mqqapi://miniapp/adopen");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfgg
 * JD-Core Version:    0.7.0.1
 */