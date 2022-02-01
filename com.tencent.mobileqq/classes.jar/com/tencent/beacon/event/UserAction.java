package com.tencent.beacon.event;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.beacon.core.b.f;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.info.BeaconPubParams;
import com.tencent.beacon.core.info.a;
import com.tencent.beacon.core.info.e;
import com.tencent.beacon.core.info.g;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import com.tencent.beacon.upload.UploadStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserAction
{
  private static boolean a;
  public static List<com.tencent.beacon.core.c> beaconModules = new ArrayList();
  public static Context mContext;
  
  @Deprecated
  public static void closeUseInfoEvent() {}
  
  public static void doUploadRecords()
  {
    com.tencent.beacon.core.a.d.a().a(new c());
  }
  
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
  
  public static String getAppKey()
  {
    return com.tencent.beacon.core.info.b.b;
  }
  
  public static String getCloudParas(String paramString)
  {
    if (mContext == null) {}
    Map localMap;
    do
    {
      return null;
      localMap = com.tencent.beacon.core.strategy.c.g().e();
    } while (localMap == null);
    return (String)localMap.get(paramString);
  }
  
  public static BeaconPubParams getCommonParams()
  {
    return BeaconPubParams.getPubParams(getAppKey());
  }
  
  public static String getEventDomain()
  {
    return com.tencent.beacon.core.c.a.b.c;
  }
  
  public static String getQIMEI()
  {
    return QimeiSDK.getInstance().getQimeiInternal(null);
  }
  
  public static void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    QimeiSDK.getInstance().getQimei(paramIAsyncQimeiListener);
  }
  
  public static String getQimeiByKey(String paramString)
  {
    return QimeiSDK.getInstance().getQimeiByKey(null, paramString);
  }
  
  public static String getQimeiNew()
  {
    return QimeiSDK.getInstance().getQimeiNew(null);
  }
  
  @Deprecated
  public static String getRtQIMEI(Context paramContext)
  {
    try
    {
      paramContext = com.tencent.beacon.qimei.i.c(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.beacon.core.e.d.a("[userAction] load qimeiJson: " + paramContext, new Object[0]);
      paramContext = com.tencent.beacon.qimei.i.a(paramContext);
      if (paramContext != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder = localStringBuilder.append("[userAction] get A3: ");
        com.tencent.beacon.core.e.d.a((String)paramContext.get("A3"), new Object[0]);
        paramContext = (String)paramContext.get("A3");
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.beacon.core.e.d.b("load qimei error ", new Object[] { paramContext.getMessage() });
    }
    return "";
  }
  
  public static String getSDKVersion()
  {
    return com.tencent.beacon.core.info.b.i();
  }
  
  public static String getStrategyDomain()
  {
    return com.tencent.beacon.core.c.a.b.d;
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
  
  @TargetApi(14)
  public static void initUserAction(Context paramContext, boolean paramBoolean, long paramLong, InitHandleListener paramInitHandleListener, UploadHandleListener paramUploadHandleListener)
  {
    if (mContext != null)
    {
      com.tencent.beacon.core.e.d.b("[core] SDK is already initialized.", new Object[0]);
      return;
    }
    if (paramContext == null)
    {
      com.tencent.beacon.core.e.d.i("[core] context is null! init failed!", new Object[0]);
      return;
    }
    Object localObject = paramContext.getApplicationContext();
    if (localObject != null) {
      mContext = (Context)localObject;
    }
    for (;;)
    {
      try
      {
        if (!a)
        {
          a = true;
          com.tencent.beacon.core.e.b.b(mContext);
          a.f(mContext);
          if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 14)
          {
            localObject = new com.tencent.beacon.core.a.j();
            ((Application)mContext).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject);
            ((Application)mContext).registerActivityLifecycleCallbacks(new com.tencent.beacon.core.a.k());
          }
          for (;;)
          {
            com.tencent.beacon.core.d.k.a(mContext).b(paramBoolean);
            if (paramUploadHandleListener != null) {
              com.tencent.beacon.core.d.k.a(mContext).a(paramUploadHandleListener);
            }
            f.a().a(paramContext);
            com.tencent.beacon.core.d.i.a(paramContext).a(UploadStrategy.defaultErrorRandomBound);
            com.tencent.beacon.core.a.d.a().a(new b(paramContext, paramInitHandleListener, paramLong));
            return;
            mContext = paramContext;
            break;
            localObject = new com.tencent.beacon.core.a.b(mContext);
            com.tencent.beacon.core.a.d.a().a((Runnable)localObject);
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    Context localContext = mContext;
    if (localContext != null) {
      paramMap.put("A33", e.d(localContext).k(mContext));
    }
    return onUserAction("rqd_wgLogin", paramBoolean, paramLong, 0L, paramMap, true);
  }
  
  public static boolean onDTUserAction(Context paramContext, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramMap != null)
    {
      paramContext = com.tencent.beacon.core.info.c.a(paramContext);
      paramMap = new HashMap(paramMap);
      paramMap.put("dt_imei2", "" + paramContext.d());
      paramMap.put("dt_meid", "" + paramContext.h());
      paramMap.put("dt_mf", "" + paramContext.g());
      return onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
    }
    return onUserAction(paramString, paramBoolean1, paramLong1, paramLong2, null, paramBoolean2, paramBoolean3);
  }
  
  public static boolean onDTUserActionToTunnel(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramMap != null)
    {
      paramContext = com.tencent.beacon.core.info.c.a(paramContext);
      paramMap = new HashMap(paramMap);
      paramMap.put("dt_imei2", "" + paramContext.d());
      paramMap.put("dt_meid", "" + paramContext.h());
      paramMap.put("dt_mf", "" + paramContext.g());
      return onUserActionToTunnel(paramString1, paramString2, paramMap, paramBoolean1, paramBoolean2);
    }
    return onUserActionToTunnel(paramString1, paramString2, null, paramBoolean1, paramBoolean2);
  }
  
  public static void onPageIn(String paramString)
  {
    com.tencent.beacon.core.event.k.a(com.tencent.beacon.core.e.c.c(paramString));
  }
  
  public static void onPageOut(String paramString)
  {
    com.tencent.beacon.core.event.k.b(com.tencent.beacon.core.e.c.c(paramString));
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
    com.tencent.beacon.core.e.i.a(paramMap);
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
    if (!com.tencent.beacon.core.e.j.b(paramString))
    {
      com.tencent.beacon.core.info.b.b = paramString;
      TunnelModule localTunnelModule = TunnelModule.getInstance();
      if (localTunnelModule != null) {
        localTunnelModule.setAppKey(paramString);
      }
    }
  }
  
  public static void setAppVersion(String paramString)
  {
    if (!com.tencent.beacon.core.e.j.b(paramString)) {
      com.tencent.beacon.core.info.b.c = paramString;
    }
  }
  
  @Deprecated
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    if (!com.tencent.beacon.core.e.j.b(paramString)) {
      com.tencent.beacon.core.info.b.d = com.tencent.beacon.core.e.c.a(paramString);
    }
  }
  
  public static void setCollectImei(boolean paramBoolean)
  {
    UploadStrategy.IS_COLLECT_IMEI = paramBoolean;
  }
  
  public static void setCollectMAC(boolean paramBoolean)
  {
    UploadStrategy.IS_COLLECT_MAC = paramBoolean;
  }
  
  public static void setJsClientId(String paramString)
  {
    g.b(mContext).d(paramString);
  }
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.beacon.core.e.d.b(paramBoolean1);
    com.tencent.beacon.core.e.d.a(paramBoolean2);
    com.tencent.beacon.core.e.d.c(paramBoolean1 & paramBoolean2);
  }
  
  public static void setOAID(String paramString)
  {
    if (!com.tencent.beacon.core.e.j.b(paramString)) {
      com.tencent.beacon.core.info.c.b = paramString;
    }
  }
  
  public static void setOmgId(String paramString)
  {
    if (!com.tencent.beacon.core.e.j.b(paramString)) {
      com.tencent.beacon.core.info.c.c = paramString;
    }
  }
  
  public static void setQQ(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Long.parseLong(paramString) > 10000L) {
          com.tencent.beacon.core.info.c.d = paramString;
        }
        return;
      }
      catch (Exception paramString)
      {
        com.tencent.beacon.core.e.d.i("[core] set qq is not available !", new Object[0]);
        return;
      }
    }
    com.tencent.beacon.core.e.d.i("[core] set qq is null !", new Object[0]);
  }
  
  public static void setReportDomain(String paramString1, String paramString2)
  {
    com.tencent.beacon.core.strategy.c.g().a(paramString1, paramString2);
  }
  
  public static void setReportIP(String paramString1, String paramString2)
  {
    com.tencent.beacon.core.c.a.b.a(paramString1, paramString2);
  }
  
  public static void setScheduledService(ScheduledExecutorService paramScheduledExecutorService)
  {
    if (paramScheduledExecutorService != null)
    {
      com.tencent.beacon.core.a.d.a(com.tencent.beacon.core.a.d.a(paramScheduledExecutorService));
      return;
    }
    com.tencent.beacon.core.e.d.b("service param error!", new Object[0]);
  }
  
  public static void setStopBackgroundTask(boolean paramBoolean)
  {
    UploadStrategy.IS_STOP_BACKGROUND_TASK = paramBoolean;
  }
  
  public static void setStrictMode(boolean paramBoolean)
  {
    com.tencent.beacon.core.e.i.a.set(paramBoolean);
    Context localContext = mContext;
    if (localContext != null) {
      com.tencent.beacon.core.e.i.a(localContext);
    }
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
      com.tencent.beacon.core.e.d.i("[core] UserEventModule is null, init sdk first!", new Object[0]);
    }
  }
  
  public static void setUserID(String paramString)
  {
    setUserID(null, paramString);
  }
  
  public static void setUserID(String paramString1, String paramString2)
  {
    com.tencent.beacon.core.e.d.d("[core] setUserID:" + paramString2, new Object[0]);
    TunnelModule.setUserId(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */