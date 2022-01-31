package com.tencent.beacon.event;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class UserAction
{
  private static String a = "";
  public static List<com.tencent.beacon.core.b> beaconModules = new ArrayList();
  public static Context mContext = null;
  
  public static void closeUseInfoEvent() {}
  
  public static void doUploadRecords()
  {
    com.tencent.beacon.core.a.b.b().a(new UserAction.2());
  }
  
  public static void enablePagePath(boolean paramBoolean) {}
  
  public static void flushObjectsToDB(boolean paramBoolean)
  {
    TunnelModule.flushObjectsToDB(paramBoolean);
  }
  
  public static Map<String, String> getAdditionalInfo()
  {
    return TunnelModule.getAdditionalInfo(null);
  }
  
  public static Map<String, String> getAdditionalInfo(String paramString)
  {
    return TunnelModule.getAdditionalInfo(paramString);
  }
  
  public static String getAppkey()
  {
    return com.tencent.beacon.core.b.b.a;
  }
  
  public static String getCloudParas(String paramString)
  {
    if (mContext == null) {}
    Map localMap;
    do
    {
      return null;
      localMap = com.tencent.beacon.core.strategy.a.a().d();
    } while (localMap == null);
    return (String)localMap.get(paramString);
  }
  
  public static String getQIMEI()
  {
    if (mContext == null)
    {
      com.tencent.beacon.core.d.b.d("[core] init sdk first!", new Object[0]);
      return "";
    }
    return QimeiSDK.getInstance().getQimeiInternal();
  }
  
  public static String getQQ()
  {
    return a;
  }
  
  public static void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    QimeiSDK.getInstance().getQimei(paramIAsyncQimeiListener);
  }
  
  public static String getSDKVersion()
  {
    return com.tencent.beacon.core.b.b.a(mContext).d();
  }
  
  public static String getUserID(String paramString)
  {
    return TunnelModule.getUserId(paramString);
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
      com.tencent.beacon.core.d.b.d("[core] SDK is already initialized.", new Object[0]);
      return;
    }
    if (paramContext == null)
    {
      com.tencent.beacon.core.d.b.c("[core] context is null! init failed!", new Object[0]);
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null)
    {
      mContext = localContext;
      if (Integer.valueOf(Build.VERSION.SDK).intValue() < 14) {
        break label139;
      }
      paramContext = new com.tencent.beacon.core.a.e();
      ((Application)mContext).registerActivityLifecycleCallbacks(paramContext);
    }
    for (;;)
    {
      i.a(mContext).a(paramBoolean);
      if (paramUploadHandleListener != null) {
        i.a(mContext).a(paramUploadHandleListener);
      }
      QimeiSDK.getInstance().init(mContext);
      com.tencent.beacon.core.a.b.b().a(new UserAction.1(paramInitHandleListener, paramLong));
      return;
      mContext = paramContext;
      break;
      label139:
      paramContext = new com.tencent.beacon.core.a.a(mContext);
      com.tencent.beacon.core.a.b.b().a(paramContext);
    }
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (mContext != null)
    {
      d.a(mContext);
      paramMap.put("A33", d.j(mContext));
    }
    return onUserAction("rqd_wgLogin", paramBoolean, paramLong, 0L, paramMap, true);
  }
  
  public static void onPageIn(String paramString)
  {
    com.tencent.beacon.core.event.e.a(com.tencent.beacon.core.d.a.c(paramString));
  }
  
  public static void onPageOut(String paramString)
  {
    com.tencent.beacon.core.event.e.b(com.tencent.beacon.core.d.a.c(paramString));
  }
  
  public static boolean onUserAction(String paramString, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    return onUserAction(paramString, true, -1L, -1L, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    return onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false);
  }
  
  public static boolean onUserAction(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return TunnelModule.onUserAction(null, paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static boolean onUserActionToTunnel(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    return onUserActionToTunnel(paramString1, paramString2, true, -1L, -1L, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public static boolean onUserActionToTunnel(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    return TunnelModule.onUserAction(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
  }
  
  public static void registerTunnel(TunnelInfo paramTunnelInfo)
  {
    TunnelModule.registerTunnel(paramTunnelInfo);
  }
  
  @Deprecated
  public static void setAPPVersion(String paramString)
  {
    setAppVersion(paramString);
  }
  
  public static void setAdditionalInfo(String paramString, Map<String, String> paramMap)
  {
    TunnelModule.setAdditionalInfo(paramString, paramMap);
  }
  
  public static void setAdditionalInfo(Map<String, String> paramMap)
  {
    TunnelModule.setAdditionalInfo(null, paramMap);
  }
  
  public static void setAppKey(String paramString)
  {
    if (!h.a(paramString))
    {
      com.tencent.beacon.core.b.b.a = paramString;
      TunnelModule localTunnelModule = TunnelModule.getInstance();
      if (localTunnelModule != null) {
        localTunnelModule.setAppKey(paramString);
      }
    }
  }
  
  public static void setAppVersion(String paramString)
  {
    if (!h.a(paramString)) {
      com.tencent.beacon.core.b.b.b = paramString;
    }
  }
  
  @Deprecated
  public static void setAppkey(String paramString)
  {
    setAppKey(paramString);
  }
  
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    if (!h.a(paramString)) {
      com.tencent.beacon.core.b.b.c = com.tencent.beacon.core.d.a.a(paramString);
    }
  }
  
  public static void setJsClientId(String paramString)
  {
    com.tencent.beacon.core.b.b.a(mContext).d(paramString);
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.beacon.core.d.b.a = paramBoolean1;
    com.tencent.beacon.core.d.b.b = paramBoolean2;
    com.tencent.beacon.core.d.b.c = paramBoolean1 & paramBoolean2;
  }
  
  public static void setOmgId(String paramString)
  {
    if (!h.a(paramString)) {
      com.tencent.beacon.core.b.c.a = paramString;
    }
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
        com.tencent.beacon.core.d.b.c("[core] set qq is not available !", new Object[0]);
        return;
      }
    }
    com.tencent.beacon.core.d.b.c("[core] set qq is null !", new Object[0]);
  }
  
  public static void setReportDomain(String paramString1, String paramString2)
  {
    com.tencent.beacon.core.strategy.a.a().a(paramString1, paramString2);
  }
  
  @Deprecated
  public static void setSDKVersion(String paramString) {}
  
  public static void setScheduledService(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (paramScheduledExecutorService != null)
    {
      com.tencent.beacon.core.a.b.a(com.tencent.beacon.core.a.b.a(paramScheduledExecutorService));
      return;
    }
    com.tencent.beacon.core.d.b.d("service param error!", new Object[0]);
  }
  
  public static void setUploadMode(boolean paramBoolean)
  {
    Object localObject = UserEventModule.getInstance();
    if (localObject != null) {
      ((UserEventModule)localObject).setUploadMode(paramBoolean);
    }
    for (;;)
    {
      localObject = TunnelModule.getInstance();
      if (localObject != null) {
        ((TunnelModule)localObject).setUploadMode(paramBoolean);
      }
      return;
      com.tencent.beacon.core.d.b.c("[core] UserEventModule is null, init sdk first!", new Object[0]);
    }
  }
  
  public static void setUserID(String paramString)
  {
    setUserID(null, paramString);
  }
  
  public static void setUserID(String paramString1, String paramString2)
  {
    com.tencent.beacon.core.d.b.a("[core] setUserID:" + paramString2, new Object[0]);
    TunnelModule.setUserId(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */