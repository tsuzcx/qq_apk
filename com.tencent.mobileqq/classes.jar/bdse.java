import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public class bdse
{
  public static ConcurrentHashMap<String, bdsf> a = new ConcurrentHashMap();
  
  public static int a(String paramString)
  {
    return a(paramString).a;
  }
  
  public static bdsf a(String paramString)
  {
    if (a.containsKey(paramString)) {
      return (bdsf)a.get(paramString);
    }
    bdsf localbdsf = new bdsf();
    a.put(paramString, localbdsf);
    return localbdsf;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = a(paramString);
    if (i == 0) {
      return "baselib_not_download";
    }
    if (i == 1) {
      return "baselib_download";
    }
    return "unknown";
  }
  
  public static void a(String paramString)
  {
    paramString = a(paramString);
    paramString.a = -1;
    paramString.b = -1;
    paramString.c = -1;
    paramString.d = -1;
    paramString.e = -1;
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramBoolean)
    {
      paramString.a = 1;
      paramString.b = 1;
      paramString.c = 1;
    }
    for (paramString.e = 1;; paramString.e = 0)
    {
      if (paramString.d == -1) {
        paramString.d = 0;
      }
      return;
      paramString.a = 0;
      paramString.b = 0;
      paramString.c = 0;
    }
  }
  
  public static int b(String paramString)
  {
    return a(paramString).b;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = b(paramString);
    if (i == 0) {
      return "service_not_preload";
    }
    if (i == 1) {
      return "service_preload";
    }
    return "unknown";
  }
  
  public static void b(String paramString)
  {
    a.remove(paramString);
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramString).a = 1;
      return;
    }
    a(paramString).a = 0;
  }
  
  public static int c(String paramString)
  {
    return a(paramString).c;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = c(paramString);
    if (i == 0) {
      return "apkg_not_download";
    }
    if (i == 1) {
      return "apkg_download";
    }
    return "unknown";
  }
  
  public static void c(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramString).b = 1;
      return;
    }
    a(paramString).b = 0;
  }
  
  public static int d(String paramString)
  {
    return a(paramString).d;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = d(paramString);
    if (i == 0) {
      return "hot_start";
    }
    if (i == 1) {
      return "page_switch";
    }
    return "unknown";
  }
  
  public static void d(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramBoolean))
    {
      if (paramString.c == -1) {
        paramString.c = 1;
      }
      if (paramString.a == -1) {
        paramString.a = 1;
      }
      if (paramString.b == -1) {
        paramString.b = 1;
      }
    }
  }
  
  public static int e(String paramString)
  {
    return a(paramString).e;
  }
  
  public static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "unknown";
    }
    int i = e(paramString);
    if (i == 0) {
      return "service_not_preload";
    }
    if (i == 1) {
      return "service_preload";
    }
    return "unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdse
 * JD-Core Version:    0.7.0.1
 */