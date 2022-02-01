package com.tencent.beacon.event;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.base.net.c.b;
import com.tencent.beacon.core.info.BeaconPubParams;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconConfig.Builder;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.qimei.IAsyncQimeiListener;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.beacon.upload.UploadHandleListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

@Deprecated
public class UserAction
{
  private static String a;
  private static BeaconConfig.Builder b = ;
  private static String c;
  private static boolean d = true;
  public static Context mContext;
  
  @Deprecated
  public static void closeUseInfoEvent() {}
  
  public static void doUploadRecords()
  {
    EventModule localEventModule = (EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
    if (localEventModule != null) {
      localEventModule.a(false);
    }
  }
  
  public static void flushObjectsToDB(boolean paramBoolean) {}
  
  public static Map<String, String> getAdditionalInfo()
  {
    return getAdditionalInfo(null);
  }
  
  public static Map<String, String> getAdditionalInfo(String paramString)
  {
    EventModule localEventModule = (EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
    if (localEventModule != null) {
      return localEventModule.a(paramString);
    }
    return null;
  }
  
  public static String getAppKey()
  {
    return a;
  }
  
  public static String getCloudParas(String paramString)
  {
    return "";
  }
  
  public static BeaconPubParams getCommonParams()
  {
    return BeaconReport.getInstance().getCommonParams(mContext);
  }
  
  public static String getEventDomain()
  {
    return b.c;
  }
  
  public static String getQIMEI()
  {
    return QimeiSDK.getInstance().getQimeiInternal();
  }
  
  public static void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    QimeiSDK.getInstance().getQimei(paramIAsyncQimeiListener);
  }
  
  public static String getQimeiByKey(String paramString)
  {
    Qimei localQimei = BeaconReport.getInstance().getQimei();
    if ((localQimei != null) && (!localQimei.isEmpty())) {
      return (String)localQimei.getQimeiMap().get(paramString);
    }
    return "";
  }
  
  public static String getQimeiNew()
  {
    Qimei localQimei = BeaconReport.getInstance().getQimei();
    if (localQimei != null) {
      return localQimei.getQimeiNew();
    }
    return "";
  }
  
  @Deprecated
  public static String getRtQIMEI(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    com.tencent.beacon.a.c.c.d().a(paramContext.getApplicationContext());
    return com.tencent.beacon.qimei.a.a().b().getQimeiOld();
  }
  
  public static String getSDKVersion()
  {
    return BeaconReport.getInstance().getSDKVersion();
  }
  
  public static String getStrategyDomain()
  {
    return b.d;
  }
  
  public static String getUserID(String paramString)
  {
    EventModule localEventModule = (EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
    if (localEventModule != null) {
      return localEventModule.b(paramString);
    }
    return "";
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
    if (d)
    {
      mContext = paramContext;
      BeaconReport.getInstance().start(paramContext, a, b.build());
      return;
    }
    Log.e("beacon", "UserAction.initUserAction is not available");
  }
  
  public static boolean loginEvent(boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    if (mContext != null) {
      paramMap.put("A19", f.p().w());
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
      com.tencent.beacon.a.c.c.d().a(paramContext);
      paramContext = f.p();
      paramMap = new HashMap(paramMap);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext.n());
      paramMap.put("dt_imei2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext.u());
      paramMap.put("dt_meid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext.t());
      paramMap.put("dt_mf", localStringBuilder.toString());
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
      com.tencent.beacon.a.c.c.d().a(paramContext);
      paramContext = f.p();
      paramMap = new HashMap(paramMap);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext.n());
      paramMap.put("dt_imei2", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext.u());
      paramMap.put("dt_meid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramContext.t());
      paramMap.put("dt_mf", localStringBuilder.toString());
      return onUserActionToTunnel(paramString1, paramString2, paramMap, paramBoolean1, paramBoolean2);
    }
    return onUserActionToTunnel(paramString1, paramString2, null, paramBoolean1, paramBoolean2);
  }
  
  public static void onPageIn(String paramString)
  {
    com.tencent.beacon.d.a.a(com.tencent.beacon.event.c.c.c(paramString));
  }
  
  public static void onPageOut(String paramString)
  {
    com.tencent.beacon.d.a.b(com.tencent.beacon.event.c.c.c(paramString));
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
    BeaconEvent.Builder localBuilder = BeaconEvent.builder().withCode(paramString);
    if (paramBoolean2) {
      paramString = EventType.REALTIME;
    } else {
      paramString = EventType.NORMAL;
    }
    paramString = localBuilder.withType(paramString).withParams(paramMap).withAppKey(a).withIsSucceed(paramBoolean1).build();
    return BeaconReport.getInstance().report(paramString).isSuccess();
  }
  
  public static boolean onUserActionToTunnel(String paramString1, String paramString2, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    return onUserActionToTunnel(paramString1, paramString2, true, -1L, -1L, paramMap, paramBoolean1, paramBoolean2);
  }
  
  public static boolean onUserActionToTunnel(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    BeaconEvent.Builder localBuilder = BeaconEvent.builder().withCode(paramString2);
    if (paramBoolean2) {
      paramString2 = EventType.REALTIME;
    } else {
      paramString2 = EventType.NORMAL;
    }
    paramString1 = localBuilder.withType(paramString2).withParams(paramMap).withAppKey(paramString1).withIsSucceed(paramBoolean1).build();
    return BeaconReport.getInstance().report(paramString1).isSuccess();
  }
  
  public static void registerTunnel(TunnelInfo paramTunnelInfo) {}
  
  public static void setAdditionalInfo(String paramString, Map<String, String> paramMap)
  {
    BeaconReport.getInstance().setAdditionalParams(paramString, paramMap);
  }
  
  public static void setAdditionalInfo(Map<String, String> paramMap)
  {
    setAdditionalInfo(null, paramMap);
  }
  
  public static void setAppKey(String paramString)
  {
    a = paramString;
  }
  
  public static void setAppVersion(String paramString)
  {
    c = paramString;
  }
  
  @Deprecated
  public static void setAutoLaunchEventUsable(boolean paramBoolean) {}
  
  public static void setChannelID(String paramString)
  {
    BeaconReport.getInstance().setChannelID(paramString);
  }
  
  public static void setCollectImei(boolean paramBoolean)
  {
    b.collectIMEIEnable(paramBoolean);
  }
  
  public static void setCollectMAC(boolean paramBoolean)
  {
    b.collectMACEnable(paramBoolean);
  }
  
  public static void setJsClientId(String paramString) {}
  
  public static void setLogAble(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.beacon.base.util.c.a(paramBoolean1);
    com.tencent.beacon.base.util.c.b(paramBoolean1);
  }
  
  public static void setOAID(String paramString)
  {
    BeaconReport.getInstance().setOAID(paramString);
  }
  
  @Deprecated
  public static void setOldInitMethodEnable(boolean paramBoolean)
  {
    d = paramBoolean;
  }
  
  public static void setOmgId(String paramString)
  {
    BeaconReport.getInstance().setOmgID(paramString);
  }
  
  public static void setQQ(String paramString)
  {
    BeaconReport.getInstance().setQQ(paramString);
  }
  
  public static void setReportDomain(String paramString1, String paramString2)
  {
    b.a(paramString1, paramString2);
  }
  
  public static void setReportIP(String paramString1, String paramString2)
  {
    b.b(paramString1, paramString2);
  }
  
  public static void setScheduledService(ScheduledExecutorService paramScheduledExecutorService)
  {
    b.setExecutorService(paramScheduledExecutorService);
  }
  
  public static void setStrictMode(boolean paramBoolean)
  {
    BeaconReport.getInstance().setStrictMode(paramBoolean);
  }
  
  public static void setUploadMode(boolean paramBoolean)
  {
    EventModule localEventModule = (EventModule)com.tencent.beacon.a.c.c.d().a(ModuleName.EVENT);
    if (localEventModule != null)
    {
      localEventModule.b(paramBoolean);
      return;
    }
    b.eventReportEnable(paramBoolean);
  }
  
  public static void setUserID(String paramString)
  {
    setUserID(null, paramString);
  }
  
  public static void setUserID(String paramString1, String paramString2)
  {
    BeaconReport.getInstance().setUserID(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.UserAction
 * JD-Core Version:    0.7.0.1
 */