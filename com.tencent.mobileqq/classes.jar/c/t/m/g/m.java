package c.t.m.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;

public final class m
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static boolean e = true;
  private static Context f = null;
  private static String g = "DefaultSessionId";
  private static long h;
  private static int i = 0;
  private static boolean j = false;
  private static String k = "";
  private static String l;
  private static String m;
  private static String n;
  private static Handler o;
  private static volatile boolean p;
  
  static
  {
    a = "null";
    b = "";
    c = "";
    d = "";
    l = "3.5.1.16";
    m = "";
    n = "";
    p = false;
  }
  
  public static Context a()
  {
    return f;
  }
  
  public static void a(int paramInt, b paramb, String paramString)
  {
    h = SystemClock.elapsedRealtime();
    Process.myPid();
    Context localContext = paramb.a;
    f = localContext.getApplicationContext();
    k = localContext.getPackageName();
    i = paramInt;
    j = paramb.c;
    String str2 = paramb.d;
    String str1 = str2;
    if (cn.a(str2)) {
      str1 = "";
    }
    c = str1;
    str1 = paramb.e;
    paramb = str1;
    if (cn.a(str1)) {
      paramb = "";
    }
    d = paramb;
    l = "3.5.1.16";
    new Handler(f.getMainLooper());
    try
    {
      paramb = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      a = paramb.versionName;
      paramInt = paramb.versionCode;
      b = paramb.applicationInfo.loadLabel(localContext.getPackageManager()).toString();
      label154:
      m = paramString;
      k.equals(m);
      paramb = new HandlerThread("halley_" + i + "_" + "TempTask", 10);
      paramb.start();
      paramb = new Handler(paramb.getLooper());
      o = paramb;
      paramb.post(new ah());
      return;
    }
    catch (Throwable paramb)
    {
      break label154;
    }
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public static int c()
  {
    return i;
  }
  
  public static String d()
  {
    return g;
  }
  
  public static int e()
  {
    return (int)(SystemClock.elapsedRealtime() - h);
  }
  
  public static String f()
  {
    return k;
  }
  
  public static boolean g()
  {
    return j;
  }
  
  public static String h()
  {
    return l;
  }
  
  public static String i()
  {
    if (!cn.a(n)) {
      return n;
    }
    if ((!cn.a(m)) && (m.contains(":")))
    {
      int i1 = m.indexOf(":");
      return m.substring(i1 + 1);
    }
    return "";
  }
  
  public static Handler j()
  {
    return o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.m
 * JD-Core Version:    0.7.0.1
 */