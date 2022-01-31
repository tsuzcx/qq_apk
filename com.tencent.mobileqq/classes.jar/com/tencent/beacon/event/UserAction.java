package com.tencent.beacon.event;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.beacon.a.b.j;
import com.tencent.beacon.a.c.d;
import com.tencent.beacon.a.e.c;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserAction
{
  private static String a = "";
  private static String b = "10000";
  private static Map<String, String> c = null;
  public static Context mContext = null;
  
  public static void addAdditionalInfo(String paramString1, String paramString2)
  {
    if (c == null) {
      c = new HashMap();
    }
    c.put(paramString1, paramString2);
  }
  
  @Deprecated
  public static void closeUseInfoEvent() {}
  
  public static void doUploadRecords()
  {
    com.tencent.beacon.a.a.b.a().a(new Runnable()
    {
      public final void run()
      {
        try
        {
          j.c(false);
          return;
        }
        catch (Throwable localThrowable)
        {
          com.tencent.beacon.a.g.a.a(localThrowable);
        }
      }
    });
  }
  
  public static void flushObjectsToDB(boolean paramBoolean)
  {
    j.b(paramBoolean);
  }
  
  public static Map<String, String> getAdditionalInfo()
  {
    return c;
  }
  
  public static String getAppKey()
  {
    return com.tencent.beacon.a.c.b.a;
  }
  
  @Deprecated
  public static String getAppkey()
  {
    return getAppKey();
  }
  
  public static String getCloudParas(String paramString)
  {
    if (mContext == null) {}
    Map localMap;
    do
    {
      return null;
      localMap = com.tencent.beacon.a.e.a.a().d();
    } while (localMap == null);
    return (String)localMap.get(paramString);
  }
  
  public static String getQIMEI()
  {
    if (mContext == null)
    {
      com.tencent.beacon.a.g.a.d("[core] init sdk first!", new Object[0]);
      return "";
    }
    return d.a(mContext).f();
  }
  
  public static String getQQ()
  {
    return a;
  }
  
  public static String getUserID()
  {
    return b;
  }
  
  public static void initUserAction(Context paramContext)
  {
    initUserAction(paramContext, true);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean)
  {
    initUserAction(paramContext, paramBoolean, 0L);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong)
  {
    initUserAction(paramContext, paramBoolean, paramLong, null, null);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong, InitHandleListener paramInitHandleListener, UploadHandleListener paramUploadHandleListener)
  {
    if (mContext != null)
    {
      com.tencent.beacon.a.g.a.d("[core] SDK is already initialized.", new Object[0]);
      return;
    }
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.c("[core] context is null! init failed!", new Object[0]);
      return;
    }
    Object localObject = paramContext.getApplicationContext();
    if (localObject != null)
    {
      mContext = (Context)localObject;
      label46:
      if (paramLong > 0L)
      {
        long l = paramLong;
        if (paramLong > 10000L) {
          l = 10000L;
        }
        c.a(l);
      }
      if (Integer.valueOf(Build.VERSION.SDK).intValue() < 14) {
        break label189;
      }
      localObject = new com.tencent.beacon.a.a.e();
      ((Application)mContext).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject);
    }
    for (;;)
    {
      h.a(mContext).a(paramBoolean);
      if (paramUploadHandleListener != null) {
        h.a(mContext).a(paramUploadHandleListener);
      }
      j.j(mContext).a(paramInitHandleListener);
      paramContext = com.tencent.beacon.a.a.a(paramContext).iterator();
      while (paramContext.hasNext()) {
        ((com.tencent.beacon.a.a)paramContext.next()).b(mContext);
      }
      break;
      mContext = paramContext;
      break label46;
      label189:
      localObject = new com.tencent.beacon.a.a.a(mContext);
      com.tencent.beacon.a.a.b.a().a((Runnable)localObject);
    }
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (mContext != null)
    {
      com.tencent.beacon.a.c.e.a(mContext);
      paramMap.put("A33", com.tencent.beacon.a.c.e.i(mContext));
    }
    return onUserAction("rqd_wgLogin", paramBoolean, paramLong, 0L, paramMap, true);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    return onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return j.a(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  @Deprecated
  public static void setAPPVersion(String paramString)
  {
    setAppVersion(paramString);
  }
  
  public static void setAdditionalInfo(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() <= 20))
    {
      if (c == null) {
        c = new HashMap();
      }
      c.putAll(paramMap);
    }
  }
  
  public static void setAppKey(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.beacon.a.c.b.a = paramString;
      }
      return;
    }
  }
  
  public static void setAppVersion(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.beacon.a.c.b.b = paramString;
      }
      return;
    }
  }
  
  @Deprecated
  public static void setAppkey(String paramString)
  {
    setAppKey(paramString);
  }
  
  @Deprecated
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.beacon.a.c.b.c = com.tencent.beacon.a.a.c(paramString);
      }
      return;
    }
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.beacon.a.g.a.a = paramBoolean1;
    com.tencent.beacon.a.g.a.b = paramBoolean2;
    com.tencent.beacon.a.g.a.c = paramBoolean1 & paramBoolean2;
  }
  
  public static void setQQ(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Long.parseLong(paramString) > 10000L) {
          a = paramString;
        }
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.beacon.a.g.a.c("[core] set qq is not available !", new Object[0]);
        return;
      }
    }
    com.tencent.beacon.a.g.a.c("[core] set qq is null !", new Object[0]);
  }
  
  public static void setReportDomain(String paramString1, String paramString2)
  {
    com.tencent.beacon.a.e.a.a().a(paramString1, paramString2);
  }
  
  @Deprecated
  public static void setSDKVersion(String paramString)
  {
    setAppVersion(paramString);
  }
  
  public static void setUploadMode(boolean paramBoolean)
  {
    j localj = j.g();
    if (localj != null)
    {
      localj.a(paramBoolean);
      return;
    }
    com.tencent.beacon.a.g.a.c("[core] UserEventModule is null, init sdk first!", new Object[0]);
  }
  
  public static void setUserID(String paramString)
  {
    com.tencent.beacon.a.g.a.a("[core] setUserID:" + paramString, new Object[0]);
    if ((paramString != null) && (paramString.trim().length() > 0) && (!"10000".equals(paramString)) && (!"10000".equals(com.tencent.beacon.a.a.b(paramString))))
    {
      b = paramString;
      if (c == null) {
        c = new HashMap();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */