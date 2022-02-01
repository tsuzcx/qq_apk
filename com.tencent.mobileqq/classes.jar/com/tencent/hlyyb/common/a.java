package com.tencent.hlyyb.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.common.b.b;

public final class a
{
  public static String a = "";
  private static Context b = null;
  private static String c;
  private static long d;
  private static int e = 0;
  private static String f = "3.4.0.16";
  private static Handler g;
  private static String h = "";
  private static String i = "";
  private static Handler j;
  
  public static Context a()
  {
    return b;
  }
  
  public static void a(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    d = SystemClock.elapsedRealtime();
    b = paramContext.getApplicationContext();
    paramContext.getPackageName();
    e = paramInt;
    b.a(paramString1);
    b.a(paramString2);
    f = "3.4.0.16";
    g = new Handler(b.getMainLooper());
    try
    {
      paramString1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      paramString2 = paramString1.versionName;
      paramInt = paramString1.versionCode;
      a = paramString1.applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
      label95:
      h = paramString3;
      c = b.g();
      paramContext = new HandlerThread("HalleyTempTaskThread");
      paramContext.start();
      j = new Handler(paramContext.getLooper());
      com.tencent.hlyyb.common.a.a.a();
      return;
    }
    catch (Throwable paramContext)
    {
      break label95;
    }
  }
  
  public static int b()
  {
    return e;
  }
  
  public static String c()
  {
    return c;
  }
  
  public static int d()
  {
    return (int)(SystemClock.elapsedRealtime() - d);
  }
  
  public static String e()
  {
    return f;
  }
  
  public static Handler f()
  {
    return g;
  }
  
  public static String g()
  {
    if (!TextUtils.isEmpty(i)) {
      return i;
    }
    if ((!TextUtils.isEmpty(h)) && (h.contains(":")))
    {
      int k = h.indexOf(":");
      return h.substring(k + 1);
    }
    return "";
  }
  
  public static Handler h()
  {
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.common.a
 * JD-Core Version:    0.7.0.1
 */