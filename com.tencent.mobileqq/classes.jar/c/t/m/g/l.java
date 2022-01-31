package c.t.m.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;

public final class l
{
  public static String a;
  public static String b;
  public static int c;
  public static String d;
  public static String e;
  public static int f;
  public static boolean g = true;
  private static Context h = null;
  private static String i;
  private static long j;
  private static int k = 0;
  private static boolean l = false;
  private static String m = "";
  private static String n;
  private static String o;
  private static boolean p;
  private static String q;
  private static Handler r;
  private static volatile boolean s;
  
  static
  {
    a = "null";
    b = "";
    c = 0;
    d = "";
    e = "";
    n = "3.4.1.4";
    o = "";
    f = -1;
    p = false;
    q = "";
    s = false;
  }
  
  public static Context a()
  {
    return h;
  }
  
  public static void a(int paramInt, b paramb, String paramString)
  {
    j = SystemClock.elapsedRealtime();
    f = Process.myPid();
    Context localContext = paramb.a;
    h = localContext.getApplicationContext();
    m = localContext.getPackageName();
    k = paramInt;
    l = paramb.c;
    String str2 = paramb.d;
    String str1 = str2;
    if (ch.a(str2)) {
      str1 = "";
    }
    d = str1;
    str1 = paramb.e;
    paramb = str1;
    if (ch.a(str1)) {
      paramb = "";
    }
    e = paramb;
    n = "3.4.1.4";
    new Handler(h.getMainLooper());
    try
    {
      paramb = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      a = paramb.versionName;
      c = paramb.versionCode;
      b = paramb.applicationInfo.loadLabel(localContext.getPackageManager()).toString();
      label158:
      o = paramString;
      p = m.equals(o);
      i = ch.d();
      paramb = new HandlerThread("HalleyTempTaskThread");
      paramb.start();
      r = new Handler(paramb.getLooper());
      o.a();
      paramb = new ad("after initSDKBaseInfo");
      if (r != null) {}
      try
      {
        r.post(paramb);
        return;
      }
      catch (Throwable paramb)
      {
        return;
      }
      paramb.run();
      return;
    }
    catch (Throwable paramb)
    {
      break label158;
    }
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public static int c()
  {
    return k;
  }
  
  public static String d()
  {
    return i;
  }
  
  public static int e()
  {
    return (int)(SystemClock.elapsedRealtime() - j);
  }
  
  public static String f()
  {
    return m;
  }
  
  public static boolean g()
  {
    return l;
  }
  
  public static String h()
  {
    return n;
  }
  
  public static String i()
  {
    if (!ch.a(q)) {
      return q;
    }
    if ((!ch.a(o)) && (o.contains(":")))
    {
      int i1 = o.indexOf(":");
      return o.substring(i1 + 1);
    }
    return "";
  }
  
  public static Handler j()
  {
    return r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.l
 * JD-Core Version:    0.7.0.1
 */