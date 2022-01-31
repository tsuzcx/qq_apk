import android.util.Log;

public class betc
{
  private static betb a;
  
  public static int a()
  {
    if (a != null) {
      return a.getLogLevel();
    }
    return 3;
  }
  
  private static String a(String paramString)
  {
    return "[MiniSDK]" + paramString;
  }
  
  public static void a(betb parambetb)
  {
    if (parambetb != null) {
      a = parambetb;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.d(a(paramString1), paramString2, paramThrowable);
      return;
    }
    Log.d(a(paramString1), paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.i(a(paramString1), paramString2, paramThrowable);
      return;
    }
    Log.i(a(paramString1), paramString2, paramThrowable);
  }
  
  public static boolean b()
  {
    return 2 >= a();
  }
  
  public static void c(String paramString1, String paramString2)
  {
    c(paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.w(a(paramString1), paramString2, paramThrowable);
      return;
    }
    Log.w(a(paramString1), paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a != null)
    {
      a.e(a(paramString1), paramString2, paramThrowable);
      return;
    }
    Log.e(a(paramString1), paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betc
 * JD-Core Version:    0.7.0.1
 */