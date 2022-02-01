package com.tencent.livesdk.liveengine;

import android.app.Application;
import android.content.Context;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.apm.APMInterface;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.crash.CrashInterface;
import com.tencent.falco.base.libapi.database.DatabaseInterface;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.generalinfo.InfoConfiguration;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.location.LocationInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.lottie.LottieServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.notification.NotificationInterface;
import com.tencent.falco.base.libapi.qqsdk.QQSdkInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.falco.base.libapi.web.WebInterface;
import com.tencent.falco.base.libapi.weibosdk.WeiboSdkInterface;
import com.tencent.falco.base.libapi.wns.WnsInterface;
import com.tencent.falco.base.libapi.wxsdk.WxSdkInterface;
import com.tencent.ilive.phoneloginsdk.PhoneLoginInterface;
import com.tencent.ilivesdk.beautyfilterservice_interface.BeautyFilterServiceInterface;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.ilivesdk.uicustomservice_interface.UICustomServiceInterface;
import com.tencent.ilivesdk.webcommonserviceinterface.WebCommonServiceInterface;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.servicefactory.BaseEnginLogic;
import com.tencent.livesdk.servicefactory.BaseEngine;
import com.tencent.livesdk.servicefactory.EnginServiceConfig;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;
import com.tencent.livesdk.servicefactory.ServiceEnginScope;
import com.tencent.livesdk.servicefactory.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LiveEngine
  extends BaseEngine
  implements EnginServiceConfig
{
  private final String TAG = "LiveEngine";
  private Context context;
  private LiveEngineConfig liveEngineConfig;
  private UserEngine mCurrentUserEngine;
  private FloatRoomManager mFloatRoomManager = new FloatRoomManager();
  
  public LiveEngine(Context paramContext, LiveEngineConfig paramLiveEngineConfig)
  {
    this.context = paramContext;
    this.liveEngineConfig = paramLiveEngineConfig;
    initServiceConfig();
    this.serviceManager = new ServiceManager(paramContext, null, this);
    ServiceAccessorMgr.getInstance().setLiveAccessor(this.serviceManager);
    configureAppGeneralInfo();
    initCrashService();
    preloadCoreComponents();
    startAPMService();
    initLogService();
  }
  
  private void configureAppGeneralInfo()
  {
    InfoConfiguration localInfoConfiguration = (InfoConfiguration)getService(AppGeneralInfoService.class);
    if (localInfoConfiguration != null)
    {
      Object localObject = (LogInterface)getService(LogInterface.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("configure app general info, Config = ");
      localStringBuilder.append(this.liveEngineConfig);
      ((LogInterface)localObject).i("LiveEngine", localStringBuilder.toString(), new Object[0]);
      localInfoConfiguration.setApplication((Application)this.context);
      localInfoConfiguration.setVersionCode(10800);
      localInfoConfiguration.setVersionName("1.8.0.158-release_qq_8.6.5");
      localInfoConfiguration.setClientType(this.liveEngineConfig.clientType);
      localInfoConfiguration.setChannelID(this.liveEngineConfig.channelID);
      localInfoConfiguration.setDebug(this.liveEngineConfig.isDebug);
      localInfoConfiguration.setRelease(this.liveEngineConfig.isRelease);
      localInfoConfiguration.setAppId(this.liveEngineConfig.appid);
      localInfoConfiguration.setTcloudConfig(this.liveEngineConfig.tCloudId, this.liveEngineConfig.tCloudLice);
      localInfoConfiguration.setWnsAppid(this.liveEngineConfig.wns_appid);
      localInfoConfiguration.setHostGuId(this.liveEngineConfig.guid);
      localInfoConfiguration.setOpenSdkAppId(this.liveEngineConfig.opensdk_appid);
      localInfoConfiguration.setNeedInitTPPlatform(this.liveEngineConfig.isNeedInitTPPlatform);
      localInfoConfiguration.setTPPlatform(this.liveEngineConfig.tpplayer_platform);
      localInfoConfiguration.setHostVersionCode(this.liveEngineConfig.versionCode);
      localInfoConfiguration.setHostVersionName(this.liveEngineConfig.versionName);
      localInfoConfiguration.setLiteSdk(this.liveEngineConfig.liteSdk);
      localInfoConfiguration.setIsHoldPlayerLog(this.liveEngineConfig.isHoldPlayerLog);
      localObject = (HostProxyInterface)getService(HostProxyInterface.class);
      if (((HostProxyInterface)localObject).getSdkInfoInterface() != null) {
        ((AppGeneralInfoService)localInfoConfiguration).setSvrTestEnv(((HostProxyInterface)localObject).getSdkInfoInterface().isTestEnv());
      }
    }
  }
  
  private void initCrashService()
  {
    ((CrashInterface)getService(CrashInterface.class)).start();
  }
  
  private void initLogService()
  {
    ((LogSdkServiceInterface)this.serviceManager.getService(LogSdkServiceInterface.class)).setUUID(((AppGeneralInfoService)this.serviceManager.getService(AppGeneralInfoService.class)).getDeviceID());
    ((LogSdkServiceInterface)getService(LogSdkServiceInterface.class)).init(this.context);
  }
  
  private void initServiceConfig()
  {
    if (this.scopeServices.size() > 0) {
      this.scopeServices.clear();
    }
    this.scopeServices.add(PhoneLoginInterface.class);
    this.scopeServices.add(CrashInterface.class);
    this.scopeServices.add(ChannelInterface.class);
    this.scopeServices.add(ActivityLifeService.class);
    this.scopeServices.add(NetworkStateInterface.class);
    this.scopeServices.add(APMInterface.class);
    this.scopeServices.add(DatabaseInterface.class);
    this.scopeServices.add(DataReportInterface.class);
    this.scopeServices.add(DownLoaderInterface.class);
    this.scopeServices.add(AppGeneralInfoService.class);
    this.scopeServices.add(FloatWindowPermissionInterface.class);
    this.scopeServices.add(HttpInterface.class);
    this.scopeServices.add(ImageLoaderInterface.class);
    this.scopeServices.add(LocationInterface.class);
    this.scopeServices.add(LogSdkServiceInterface.class);
    this.scopeServices.add(LogInterface.class);
    this.scopeServices.add(QQSdkInterface.class);
    this.scopeServices.add(ToastInterface.class);
    this.scopeServices.add(WebInterface.class);
    this.scopeServices.add(WnsInterface.class);
    this.scopeServices.add(WxSdkInterface.class);
    this.scopeServices.add(WeiboSdkInterface.class);
    this.scopeServices.add(FloatWindowConfigServiceInterface.class);
    this.scopeServices.add(LiveConfigServiceInterface.class);
    this.scopeServices.add(BeautyFilterServiceInterface.class);
    this.scopeServices.add(HostProxyInterface.class);
    this.scopeServices.add(QualityReportServiceInterface.class);
    this.scopeServices.add(UICustomServiceInterface.class);
    this.scopeServices.add(NotificationInterface.class);
    this.scopeServices.add(ActivityLifeCycleService.class);
    this.scopeServices.add(WebCommonServiceInterface.class);
    this.scopeServices.add(LottieServiceInterface.class);
    initNewServiceScope(ServiceEnginScope.Live);
  }
  
  private void preloadCoreComponents()
  {
    getService(ChannelInterface.class);
    getService(ActivityLifeService.class);
    getService(NetworkStateInterface.class);
    getService(DataReportInterface.class);
  }
  
  private void startAPMService() {}
  
  public UserEngine createUserEngine()
  {
    this.mCurrentUserEngine = new UserEngine(this.context, this.serviceManager);
    return this.mCurrentUserEngine;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public BaseEnginLogic getEnginLogic()
  {
    return null;
  }
  
  public FloatRoomManager getFloatRoomManager()
  {
    return this.mFloatRoomManager;
  }
  
  public String getOwnerEngine()
  {
    return "LiveEngine";
  }
  
  public Set<Class> getScopeServices()
  {
    return this.scopeServices;
  }
  
  public <T extends ServiceBaseInterface> T getService(Class<? extends T> paramClass)
  {
    return this.serviceManager.getService(paramClass);
  }
  
  public void unInit()
  {
    Object localObject = this.mCurrentUserEngine;
    if (localObject != null) {
      ((UserEngine)localObject).uninit();
    }
    if (this.serviceManager.getAllAvailableService().size() > 0)
    {
      localObject = this.serviceManager.getAllAvailableService().values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ServiceBaseInterface)((Iterator)localObject).next()).onDestroy();
      }
    }
    this.serviceManager.getAllAvailableService().clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.liveengine.LiveEngine
 * JD-Core Version:    0.7.0.1
 */