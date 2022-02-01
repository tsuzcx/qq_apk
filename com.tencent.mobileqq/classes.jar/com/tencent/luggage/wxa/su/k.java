package com.tencent.luggage.wxa.su;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.xweb.t.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class k
  implements t.a
{
  private String a = "";
  private j b = null;
  private l c = null;
  
  public static void a(long paramLong)
  {
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "set time sp is null");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("nLastFetchPluginConfigTime", paramLong);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static long b()
  {
    SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localSharedPreferences == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "get time sp is null");
      return 0L;
    }
    return localSharedPreferences.getLong("nLastFetchPluginConfigTime", 0L);
  }
  
  public static boolean c()
  {
    if (a.a("XFilesPDFReader").j()) {
      XWalkEnvironment.addXWalkInitializeLog("in plugin free fetch config timezone");
    }
    boolean bool2 = d();
    boolean bool1 = true;
    if (bool2)
    {
      XWalkEnvironment.addXWalkInitializeLog("has plugin need update, fetch pluginconfig first");
      return true;
    }
    long l1 = System.currentTimeMillis();
    long l2 = b();
    if (l1 - l2 < XWalkEnvironment.getPluginUpdatePeriod())
    {
      if (l1 < l2) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  static boolean d()
  {
    Iterator localIterator = h.b().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if ((localg != null) && (a.a(localg.a()).c(false))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean e()
  {
    Object localObject1 = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject1 == null) {
      return false;
    }
    int i = ((SharedPreferences)localObject1).getInt("nUpdatingProcessId", -1);
    if (i < 0) {
      return false;
    }
    int j = Process.myPid();
    int k = Process.myUid();
    if (i == j)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "current process is updating plugin");
      return true;
    }
    Object localObject2 = (ActivityManager)XWalkEnvironment.getApplicationContext().getSystemService("activity");
    localObject1 = null;
    try
    {
      localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Log.e("XWalkPluginUp", localException.getMessage());
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
        if (localRunningAppProcessInfo.pid == i) {
          if (localRunningAppProcessInfo.uid == k)
          {
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "other process is in updating plugin progress");
            return true;
          }
        }
      }
    }
    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update process pid invalid, clear");
    g();
    return false;
  }
  
  public static void f()
  {
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null) {
      return;
    }
    int i = Process.myPid();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("nUpdatingProcessId", i);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("plugin update progress start pid ");
    ((StringBuilder)localObject).append(i);
    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject).toString());
  }
  
  public static void g()
  {
    Object localObject = XWalkEnvironment.getSharedPreferencesForPluginUpdateInfo();
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove("nUpdatingProcessId");
    ((SharedPreferences.Editor)localObject).commit();
    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "plugin update progress finish");
  }
  
  public void a()
  {
    l locall = this.c;
    if (locall != null) {
      locall.a();
    }
  }
  
  public void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    try
    {
      this.c = new l();
      this.c.a(paramHashMap, this.a, this.b);
      this.c.execute(new String[0]);
      this.a = "";
      this.b = null;
      return;
    }
    finally {}
  }
  
  public void a(String paramString, j paramj)
  {
    this.a = paramString;
    this.b = paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.k
 * JD-Core Version:    0.7.0.1
 */