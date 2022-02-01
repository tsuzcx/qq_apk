package com.tencent.falco.base.datareport;

import android.content.Context;
import android.util.Log;
import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconConfig.Builder;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface.DataReportAdapter;
import com.tencent.falco.base.libapi.datareport.QualityReportTask;
import com.tencent.falco.base.libapi.datareport.ReportTask;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.HostReportInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.utils.LiveClientTypeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataReportService
  implements DataReportInterface
{
  private static ExecutorService mProductThreadPool;
  private static ExecutorService mQualityThreadPool;
  private final String TAG = "DataReportService";
  DataReportInterface.DataReportAdapter adapter;
  HostProxyInterface hostProxyInterface;
  private long mStartLiveTime = System.currentTimeMillis();
  
  private static String createLinkStringByGet(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.keySet());
    Collections.sort(localArrayList);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < localArrayList.size())
    {
      String str1 = (String)localArrayList.get(i);
      String str2 = (String)paramMap.get(str1);
      if (i == localArrayList.size() - 1)
      {
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
      }
      else
      {
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
        localStringBuilder.append("&");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private int getReportLoginType(LoginInfo paramLoginInfo)
  {
    if ((paramLoginInfo != null) && (paramLoginInfo.loginType != null))
    {
      int i = DataReportService.6.$SwitchMap$com$tencent$falco$base$libapi$login$LoginType[paramLoginInfo.loginType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return -1;
          }
          return 2;
        }
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  private void initBeacon(Context paramContext)
  {
    BeaconConfig localBeaconConfig = BeaconConfig.builder().build();
    BeaconReport localBeaconReport = BeaconReport.getInstance();
    localBeaconReport.setLogAble(false);
    localBeaconReport.setChannelID(this.adapter.getChannelId());
    localBeaconReport.setAppVersion(this.adapter.getAppVersion());
    localBeaconReport.start(paramContext, this.adapter.getAppKey(), localBeaconConfig);
    initBeaconImei();
  }
  
  private void initBeaconImei()
  {
    BeaconReport.getInstance().getQimei(new DataReportService.5(this));
  }
  
  private void initTunnelBeacon()
  {
    initBeaconImei();
  }
  
  private void sendBeaconEvent(BeaconEvent.Builder paramBuilder)
  {
    paramBuilder = paramBuilder.build();
    paramBuilder = BeaconReport.getInstance().report(paramBuilder);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventResult{ eventID:");
    localStringBuilder.append(paramBuilder.eventID);
    localStringBuilder.append(", errorCode: ");
    localStringBuilder.append(paramBuilder.errorCode);
    localStringBuilder.append(", errorMsg: ");
    localStringBuilder.append(paramBuilder.errMsg);
    localStringBuilder.append("}");
    Log.d("DataReportService", localStringBuilder.toString());
  }
  
  public void clearEventOutput() {}
  
  Map<String, String> commonReport(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (this.adapter.getLoginInfo().getLoginInfo() != null) {
        paramMap.put("uid", String.valueOf(this.adapter.getLoginInfo().getLoginInfo().uid));
      }
      paramMap.put("userid", this.adapter.getLoginInfo().getBusinessUid());
      paramMap.put("genid", this.adapter.getAppInfo().getDeviceID());
      paramMap.put("uid_type", String.valueOf(getReportLoginType(this.adapter.getLoginInfo().getLoginInfo())));
      paramMap.put("fromid", this.adapter.getAppInfo().getFromId());
      paramMap.put("source", this.adapter.getAppInfo().getSource());
      paramMap.put("appid", this.adapter.getAppInfo().getAppId());
      paramMap.put("appid_anchor", this.adapter.getAppInfo().getAppId());
      paramMap.put("client_type", String.valueOf(this.adapter.getAppInfo().getClientType()));
      if (this.adapter.isInRoom())
      {
        paramMap.put("appid_anchor", String.valueOf(LiveClientTypeUtil.getAppIdFromClientType(this.adapter.getAnchorClientType())));
        if (!paramMap.containsKey("anchor")) {
          paramMap.put("anchor", this.adapter.getAnchorId());
        }
        paramMap.put("nowid", this.adapter.getAnchorExplicitId());
        if (!paramMap.containsKey("roomid")) {
          paramMap.put("roomid", this.adapter.getRoomId());
        }
        if (!paramMap.containsKey("program_id")) {
          paramMap.put("program_id", this.adapter.getProgramId());
        }
        if (!paramMap.containsKey("room_type")) {
          paramMap.put("room_type", String.valueOf(this.adapter.getRoomType()));
        }
        if (!paramMap.containsKey("room_mode")) {
          paramMap.put("room_mode", this.adapter.getRoomMode());
        }
      }
      else if ((!this.adapter.getAppInfo().isLiteSdk()) && (this.adapter.isRoomAccessorNull()))
      {
        if (this.adapter.isOutRoomHasRoomInfo())
        {
          paramMap.put("roomid", this.adapter.getStartLiveRoomId());
          paramMap.put("program_id", this.adapter.getStartLiveProgramId());
        }
        if (this.adapter.getLoginInfo().getLoginInfo() != null) {
          paramMap.put("anchor", String.valueOf(this.adapter.getLoginInfo().getLoginInfo().uid));
        }
      }
      paramMap.put("sdk_version", "1.8.0.158-release_qq_8.6.5");
      paramMap.put("platform", "Android");
    }
    return paramMap;
  }
  
  public void init(DataReportInterface.DataReportAdapter paramDataReportAdapter)
  {
    this.adapter = paramDataReportAdapter;
    if (mProductThreadPool == null)
    {
      mProductThreadPool = Executors.newFixedThreadPool(3);
      paramDataReportAdapter.getLog().i("DataReportService", "DataReportService mProductThreadPool is null, create", new Object[0]);
    }
    if (mQualityThreadPool == null)
    {
      mQualityThreadPool = Executors.newFixedThreadPool(3);
      paramDataReportAdapter.getLog().i("DataReportService", "DataReportService mQualityThreadPool is null, create", new Object[0]);
    }
  }
  
  public QualityReportTask newAudQualityTask()
  {
    QualityReportTaskImpl localQualityReportTaskImpl = new QualityReportTaskImpl();
    localQualityReportTaskImpl.setDataReportService(this);
    localQualityReportTaskImpl.setQualityType(2);
    return localQualityReportTaskImpl;
  }
  
  public QualityReportTask newQualityTask()
  {
    QualityReportTaskImpl localQualityReportTaskImpl = new QualityReportTaskImpl();
    localQualityReportTaskImpl.setDataReportService(this);
    localQualityReportTaskImpl.setQualityType(1);
    return localQualityReportTaskImpl;
  }
  
  public QualityReportTask newQualityTaskCustom()
  {
    QualityReportTaskImpl localQualityReportTaskImpl = new QualityReportTaskImpl();
    localQualityReportTaskImpl.setDataReportService(this);
    localQualityReportTaskImpl.setQualityType(3);
    return localQualityReportTaskImpl;
  }
  
  public ReportTask newTask()
  {
    ReportTaskImpl localReportTaskImpl = new ReportTaskImpl();
    localReportTaskImpl.setDataReportService(this);
    return localReportTaskImpl;
  }
  
  public void onCreate(Context paramContext)
  {
    if (this.adapter.isUserHostBeacon())
    {
      initTunnelBeacon();
      return;
    }
    initBeacon(paramContext);
  }
  
  public void onDestroy() {}
  
  public void reportAnchorQualityEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    paramMap.put("page", "quality_page");
    paramMap.put("page_desc", "质量上报页");
    paramMap.put("page_module", "HostQuality");
    paramMap.put("page_module_desc", "中台主播质量");
    paramMap.put("act_type", paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append("quality_page");
    ((StringBuilder)localObject).append("#");
    ((StringBuilder)localObject).append("HostQuality");
    localObject = ((StringBuilder)localObject).toString();
    LogInterface localLogInterface;
    StringBuilder localStringBuilder;
    if (paramString.equals("startLive"))
    {
      this.mStartLiveTime = System.currentTimeMillis();
      localLogInterface = this.adapter.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportAnchorQualityEvent start act_type =");
      localStringBuilder.append(paramString);
      localLogInterface.i("DataReportService", localStringBuilder.toString(), new Object[0]);
    }
    else
    {
      long l = System.currentTimeMillis() - this.mStartLiveTime;
      paramMap.put("timelong", String.valueOf(l));
      localLogInterface = this.adapter.getLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportAnchorQualityEvent act_type =");
      localStringBuilder.append(paramString);
      localStringBuilder.append(";time = ");
      localStringBuilder.append(l);
      localLogInterface.i("DataReportService", localStringBuilder.toString(), new Object[0]);
    }
    paramString = commonReport(paramMap);
    mQualityThreadPool.submit(new DataReportService.3(this, (String)localObject, paramBoolean, paramString));
  }
  
  public void reportAudienceQualityEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    paramMap.put("page", "quality_page");
    paramMap.put("page_desc", "质量上报页");
    paramMap.put("page_module", "audience");
    paramMap.put("page_module_desc", "中台观看质量");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("#");
    localStringBuilder.append("quality_page");
    localStringBuilder.append("#");
    localStringBuilder.append("audience");
    paramString = localStringBuilder.toString();
    paramMap = commonReport(paramMap);
    mQualityThreadPool.submit(new DataReportService.4(this, paramString, paramBoolean, paramMap));
  }
  
  public void reportEvent(String paramString)
  {
    reportEvent(paramString, true);
  }
  
  public void reportEvent(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap.put("page", paramString1);
      paramMap.put("page_module", paramString2);
      paramMap.put("act_type", paramString3);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("#");
    localStringBuilder.append(paramString2);
    reportEvent(localStringBuilder.toString(), true, paramMap);
  }
  
  public void reportEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    reportEvent(paramString, true, -1L, -1L, paramMap, paramBoolean, paramBoolean);
  }
  
  public void reportEvent(String paramString, boolean paramBoolean)
  {
    reportEvent(paramString, paramBoolean, null);
  }
  
  public void reportEvent(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramMap = commonReport(paramMap);
    mProductThreadPool.submit(new DataReportService.1(this, paramMap, paramString, paramBoolean2, paramBoolean1));
  }
  
  public void reportEvent(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    reportEvent(paramString, paramBoolean, -1L, -1L, paramMap, false, false);
  }
  
  public void reportQualityEvent(Map<String, String> paramMap, boolean paramBoolean)
  {
    String str1 = (String)paramMap.get("act_type");
    String str2 = (String)paramMap.get("page");
    String str3 = (String)paramMap.get("page_module");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("#");
    localStringBuilder.append(str2);
    localStringBuilder.append("#");
    localStringBuilder.append(str3);
    str1 = localStringBuilder.toString();
    paramMap = commonReport(paramMap);
    mQualityThreadPool.submit(new DataReportService.2(this, str1, paramBoolean, paramMap));
  }
  
  void setBeaconLogAble()
  {
    boolean bool;
    if ((this.adapter.getHostProxy().getReportInterface() != null) && (this.adapter.getHostProxy().getReportInterface().isBeaconRealTimeDebug())) {
      bool = true;
    } else {
      bool = false;
    }
    BeaconReport.getInstance().setLogAble(bool);
  }
  
  public void setUserUid(String paramString)
  {
    BeaconReport.getInstance().setUserID(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.datareport.DataReportService
 * JD-Core Version:    0.7.0.1
 */