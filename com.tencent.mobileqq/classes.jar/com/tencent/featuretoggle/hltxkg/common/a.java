package com.tencent.featuretoggle.hltxkg.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.featuretoggle.hltxkg.HalleyInitParam;
import com.tencent.featuretoggle.hltxkg.common.e.c;

public final class a
{
  public static String a = "null";
  public static String b = "";
  public static int c = 0;
  public static String d = "";
  public static String e;
  public static volatile boolean f = false;
  public static boolean g = true;
  public static boolean h = false;
  private static Context i;
  private static int j = 0;
  private static boolean k = false;
  private static String l = "";
  private static String m = "3.5.9.1";
  private static String n = "";
  private static boolean o = false;
  private static String p = "";
  private static Handler q;
  private static boolean r = false;
  
  public static Context a()
  {
    return i;
  }
  
  public static void a(boolean paramBoolean, int paramInt1, HalleyInitParam paramHalleyInitParam, String paramString, int paramInt2)
  {
    h = paramHalleyInitParam.maskDeviceInfo;
    r = paramBoolean;
    Process.myPid();
    Context localContext = paramHalleyInitParam.getContext();
    i = localContext.getApplicationContext();
    l = localContext.getPackageName();
    j = paramInt1;
    k = paramHalleyInitParam.isSDKMode();
    String str2 = paramHalleyInitParam.getUuid();
    String str1 = str2;
    if (c.a(str2)) {
      str1 = "";
    }
    d = str1;
    c.a(paramHalleyInitParam.getChannelid());
    m = "3.5.9.1";
    new Handler(i.getMainLooper());
    try
    {
      paramHalleyInitParam = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0);
      a = paramHalleyInitParam.versionName;
      paramInt1 = paramHalleyInitParam.versionCode;
      label129:
      n = paramString;
      o = l.equals(n);
      paramHalleyInitParam = new StringBuilder("halley_");
      paramHalleyInitParam.append(j);
      paramHalleyInitParam.append("_");
      paramHalleyInitParam.append("TempTask");
      paramHalleyInitParam = new HandlerThread(paramHalleyInitParam.toString(), 10);
      paramHalleyInitParam.start();
      paramHalleyInitParam = new Handler(paramHalleyInitParam.getLooper());
      q = paramHalleyInitParam;
      paramHalleyInitParam.post(new b());
      return;
    }
    catch (Throwable paramHalleyInitParam)
    {
      break label129;
    }
  }
  
  public static boolean b()
  {
    return r;
  }
  
  public static int c()
  {
    return j;
  }
  
  public static String d()
  {
    return l;
  }
  
  public static boolean e()
  {
    return k;
  }
  
  public static String f()
  {
    return m;
  }
  
  public static boolean g()
  {
    return o;
  }
  
  public static String h()
  {
    if (!c.a(p)) {
      return p;
    }
    if ((!c.a(n)) && (n.contains(":")))
    {
      int i1 = n.indexOf(":");
      return n.substring(i1 + 1);
    }
    return "";
  }
  
  public static Handler i()
  {
    return q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a
 * JD-Core Version:    0.7.0.1
 */