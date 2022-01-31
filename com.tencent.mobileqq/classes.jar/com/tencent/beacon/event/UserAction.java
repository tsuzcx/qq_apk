package com.tencent.beacon.event;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.beacon.a.b;
import com.tencent.beacon.a.j;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAction
{
  protected static Map<String, String> a = null;
  private static Context b = null;
  private static String c = "";
  private static String d = "10000";
  private static String e = "";
  private static Runnable f = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.d.a.b(" db events to up on app call", new Object[0]);
      try
      {
        o.d(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.a(localThrowable);
      }
    }
  };
  
  @TargetApi(14)
  private static void a(Context paramContext, UploadHandleListener paramUploadHandleListener, boolean paramBoolean, long paramLong, InitHandleListener paramInitHandleListener)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.c(" the context is null! init beacon sdk failed!", new Object[0]);
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {}
    for (b = localContext;; b = paramContext)
    {
      if (paramLong > 0L)
      {
        long l = paramLong;
        if (paramLong > 10000L) {
          l = 10000L;
        }
        com.tencent.beacon.a.b.c.a(l);
      }
      paramLong = new Date().getTime();
      if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 14)
      {
        paramContext = new com.tencent.beacon.a.g();
        ((Application)b).registerActivityLifecycleCallbacks(paramContext);
      }
      paramContext = new com.tencent.beacon.a.a(b);
      com.tencent.beacon.a.c.a().a(paramContext);
      com.tencent.beacon.d.a.a("API Level: %s", new Object[] { Build.VERSION.SDK });
      com.tencent.beacon.d.a.a("initUserAction t1:" + (new Date().getTime() - paramLong), new Object[0]);
      paramContext = o.a(b, paramBoolean);
      paramUploadHandleListener = o.a(b, paramContext, paramUploadHandleListener, paramInitHandleListener);
      if (paramUploadHandleListener != null) {
        paramUploadHandleListener.a(true);
      }
      com.tencent.beacon.a.c.a().a(new Runnable()
      {
        public final void run()
        {
          Context localContext = UserAction.a();
          com.tencent.beacon.upload.h localh = this.a;
          com.tencent.beacon.a.f.a("com.tencent.beacon.net.SpeedMonitorModule", "getInstance", new Class[] { Context.class, Object.class }, new Object[] { localContext, localh });
        }
      });
      com.tencent.beacon.d.a.a("initUserAction t1:" + (new Date().getTime() - paramLong), new Object[0]);
      return;
    }
  }
  
  public static void clearAppTotalConsume(Context paramContext)
  {
    com.tencent.beacon.a.h.e(paramContext.getApplicationContext());
  }
  
  public static void clearSDKTotalConsume(Context paramContext)
  {
    com.tencent.beacon.a.h.d(paramContext.getApplicationContext());
  }
  
  public static void closeUseInfoEvent()
  {
    o localo = o.d();
    if (localo != null) {
      localo.f();
    }
  }
  
  public static void doUploadRecords()
  {
    com.tencent.beacon.a.c.a().a(f);
  }
  
  public static void flushObjectsToDB(boolean paramBoolean)
  {
    o.c(paramBoolean);
  }
  
  public static String getAPN()
  {
    if (b == null)
    {
      com.tencent.beacon.d.a.d("please initUserAction first!", new Object[0]);
      return "unknown";
    }
    return com.tencent.beacon.a.f.u(b);
  }
  
  public static String getAppkey()
  {
    return e;
  }
  
  public static String getCloudParas(String paramString)
  {
    String str = null;
    Map localMap = com.tencent.beacon.a.b.d.a().d();
    if (localMap != null) {
      str = (String)localMap.get(paramString);
    }
    return str;
  }
  
  public static String getGatewayIP()
  {
    com.tencent.beacon.a.d locald = com.tencent.beacon.a.d.m();
    if (locald != null) {
      return locald.g();
    }
    return "unknown";
  }
  
  public static String getNetWorkType()
  {
    if (b == null)
    {
      com.tencent.beacon.d.a.d("please initUserAction first!", new Object[0]);
      return "unknown";
    }
    com.tencent.beacon.a.f.a(b);
    return com.tencent.beacon.a.f.l(b);
  }
  
  public static String getQIMEI()
  {
    String str3;
    String str1;
    String str2;
    if ((b == null) || (o.d() == null))
    {
      com.tencent.beacon.d.a.d("please initUserAction first!", new Object[0]);
      str3 = "";
      str1 = str3;
      if (b != null) {
        str2 = str3;
      }
    }
    try
    {
      com.tencent.beacon.a.f.a(b);
      str2 = str3;
      str3 = com.tencent.beacon.a.f.b(b);
      str1 = str3;
      str2 = str3;
      if ("".equals(str3))
      {
        str2 = str3;
        com.tencent.beacon.a.f.a(b);
        str2 = str3;
        str1 = com.tencent.beacon.a.f.d(b);
      }
      return str1;
    }
    catch (Exception localException) {}
    return j.a(b).a();
    return str2;
  }
  
  public static String getQQ()
  {
    return c;
  }
  
  public static long getSDKTotalConsume(Context paramContext, boolean paramBoolean)
  {
    paramContext = com.tencent.beacon.a.h.b(paramContext.getApplicationContext());
    if (paramContext != null)
    {
      if (paramBoolean) {
        return paramContext.e;
      }
      long l = paramContext.d;
      return paramContext.e + l;
    }
    return -1L;
  }
  
  public static String getSDKVersion()
  {
    return "2.4.2";
  }
  
  public static g getUserActionRuntimeStrategy()
  {
    try
    {
      g localg = o.d().i();
      return localg;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return null;
  }
  
  public static String getUserID()
  {
    return d;
  }
  
  @Deprecated
  public static boolean heartbeatEvent()
  {
    com.tencent.beacon.d.a.c(" heartbeatEvent is Deprecated !", new Object[0]);
    return true;
  }
  
  public static void initUserAction(Context paramContext)
  {
    a(paramContext, null, true, 0L, null);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, null, paramBoolean, 0L, null);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong)
  {
    a(paramContext, null, paramBoolean, paramLong, null);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong, InitHandleListener paramInitHandleListener)
  {
    a(paramContext, null, paramBoolean, paramLong, paramInitHandleListener);
  }
  
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong, UploadHandleListener paramUploadHandleListener)
  {
    a(paramContext, paramUploadHandleListener, paramBoolean, paramLong, null);
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (b != null)
    {
      com.tencent.beacon.a.f.a(b);
      paramMap.put("A33", com.tencent.beacon.a.f.l(b));
    }
    return o.a("rqd_wgLogin", paramBoolean, paramLong, paramMap);
  }
  
  public static void onAppExited() {}
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    return onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      com.tencent.beacon.d.a.c("param eventName is null or \"\", please check it, return false! ", new Object[0]);
      return false;
    }
    String str2 = paramString.replace('|', '_').trim();
    String str1;
    if (str2.length() == 0)
    {
      com.tencent.beacon.d.a.c("eventName is invalid!! eventName length == 0!", new Object[0]);
      str1 = null;
    }
    while (str1 == null)
    {
      return false;
      if (com.tencent.beacon.a.f.d(str2))
      {
        str1 = str2;
        if (str2.length() > 128)
        {
          com.tencent.beacon.d.a.c("eventName is invalid!! eventName length should be less than 128! eventName:" + paramString, new Object[0]);
          str1 = str2.substring(0, 128);
        }
      }
      else
      {
        com.tencent.beacon.d.a.c("eventName is invalid!! eventName should be ASCII code in 32-126! eventName:" + paramString, new Object[0]);
        str1 = null;
      }
    }
    return o.a(str1, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static void setAPPVersion(String paramString)
  {
    if ((paramString != null) && (!paramString.trim().equals(""))) {
      b.a(paramString);
    }
  }
  
  public static void setAdditionalInfo(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() <= 20))
    {
      HashMap localHashMap = new HashMap();
      a = localHashMap;
      localHashMap.putAll(paramMap);
    }
  }
  
  public static void setAppKey(Context paramContext, String paramString)
    throws Exception
  {
    com.tencent.beacon.d.a.a(" setAppKey:" + paramString, new Object[0]);
    if (paramContext == null) {
      com.tencent.beacon.d.a.c(" the context is null! setAppKey failed!", new Object[0]);
    }
    label113:
    label119:
    for (;;)
    {
      return;
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null)
      {
        b = localContext;
        if ((paramString == null) || (paramString.trim().length() <= 0) || (paramString.trim().length() >= 20)) {
          break;
        }
        paramContext = com.tencent.beacon.a.d.m();
        if (paramContext != null) {
          break label113;
        }
        com.tencent.beacon.a.d.a(b);
        paramContext = com.tencent.beacon.a.d.m();
      }
      for (;;)
      {
        if (paramContext == null) {
          break label119;
        }
        paramContext.d(paramString);
        return;
        b = paramContext;
        break;
        paramContext.d(paramString);
      }
    }
    com.tencent.beacon.d.a.c(" setAppKey: appkey is null or not available!", new Object[0]);
    throw new RuntimeException("appkey is null or not available! please check it!");
  }
  
  public static void setAppkey(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {
      e = paramString;
    }
  }
  
  @Deprecated
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    com.tencent.beacon.a.d locald2 = com.tencent.beacon.a.d.m();
    com.tencent.beacon.a.d locald1 = locald2;
    if (locald2 == null)
    {
      com.tencent.beacon.a.d.a(b);
      locald1 = com.tencent.beacon.a.d.m();
    }
    if (locald1 == null)
    {
      com.tencent.beacon.d.a.d("please set the channelID after call initUserAction!", new Object[0]);
      return;
    }
    locald1.c(com.tencent.beacon.a.f.c(paramString));
  }
  
  public static void setInitChannelPath(Context paramContext, String paramString)
    throws Exception
  {
    if (b == null)
    {
      b.c(paramContext.getApplicationContext(), paramString);
      return;
    }
    com.tencent.beacon.d.a.d("please set the channel path before call initUserAction!", new Object[0]);
    throw new RuntimeException("please set the channel path before call initUserAction!");
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.beacon.d.a.a = paramBoolean1;
    com.tencent.beacon.d.a.b = paramBoolean2;
  }
  
  @Deprecated
  public static void setNetSpeedMonitorUsable(boolean paramBoolean)
  {
    com.tencent.beacon.d.a.c(" SpeedMonitorModule is Deprecated !", new Object[0]);
  }
  
  public static void setQQ(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Long.parseLong(paramString) > 10000L) {
          c = paramString;
        }
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.beacon.d.a.c(" setQQ: set qq is not available !", new Object[0]);
        return;
      }
    }
    com.tencent.beacon.d.a.c(" setQQ: set qq is null !", new Object[0]);
  }
  
  public static void setUploadMode(boolean paramBoolean)
  {
    o localo = o.d();
    if (localo != null)
    {
      localo.b(paramBoolean);
      return;
    }
    com.tencent.beacon.d.a.c(" UserActionRecord.getInstance is null, please initUserAction first!", new Object[0]);
  }
  
  public static void setUserActionUsable(boolean paramBoolean)
  {
    o localo = o.d();
    if (localo != null)
    {
      localo.a(paramBoolean);
      return;
    }
    com.tencent.beacon.d.a.c(" UserActionRecord.getInstance is null, please initUserAction first!", new Object[0]);
  }
  
  public static void setUserID(String paramString)
  {
    com.tencent.beacon.d.a.a(" setUserID:" + paramString, new Object[0]);
    if ((paramString != null) && (paramString.trim().length() > 0) && (!"10000".equals(paramString)) && (!"10000".equals(com.tencent.beacon.a.f.b(paramString)))) {
      d = paramString;
    }
  }
  
  public static boolean testSpeedDomain(List<String> paramList)
  {
    boolean bool = false;
    Object localObject = com.tencent.beacon.a.f.a("com.tencent.beacon.net.SpeedMonitorModule", "getInstance", new Class[0], new Object[0]);
    if (localObject != null) {
      bool = ((Boolean)com.tencent.beacon.a.f.a("com.tencent.beacon.net.SpeedMonitorModule", "testSpeedDomain", localObject, new Class[] { List.class }, new Object[] { paramList })).booleanValue();
    }
    return bool;
  }
  
  public static boolean testSpeedIp(List<String> paramList)
  {
    boolean bool = false;
    Object localObject = com.tencent.beacon.a.f.a("com.tencent.beacon.net.SpeedMonitorModule", "getInstance", new Class[0], new Object[0]);
    if (localObject != null) {
      bool = ((Boolean)com.tencent.beacon.a.f.a("com.tencent.beacon.net.SpeedMonitorModule", "testSpeedIp", localObject, new Class[] { List.class }, new Object[] { paramList })).booleanValue();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */