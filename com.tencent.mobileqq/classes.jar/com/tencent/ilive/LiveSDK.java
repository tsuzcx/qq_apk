package com.tencent.ilive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginRequest;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.login.NoLoginObserver;
import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
import com.tencent.ilive.audiencepages.room.MultiAudienceRoomActivity;
import com.tencent.ilive.base.ReportInfo.Builder;
import com.tencent.ilive.base.page.PageFactory;
import com.tencent.ilive.base.page.PageFactory.FragmentActionCallback;
import com.tencent.ilive.base.page.config.ActivityConfig;
import com.tencent.ilive.base.page.config.FragmentConfig;
import com.tencent.ilive.base.page.fragment.LiveFragment;
import com.tencent.ilive.commonpages.devoption.DevOptionActivity;
import com.tencent.ilive.config.UIConfig;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.pages.liveprepare.LivePrepareActivity;
import com.tencent.ilive.pages.liveprepare.activity.AuthWebActivity;
import com.tencent.ilive.sorely.SoRelyCoreEntry;
import com.tencent.ilive.util.ConfigUtil;
import com.tencent.ilivesdk.domain.factory.LiveCaseFactory;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.AudQualityServiceInterface;
import com.tencent.ilivesdk.qualityreportservice_interface.QualityReportServiceInterface;
import com.tencent.ilivesdk.webcomponent.StartWebViewHelper;
import com.tencent.livesdk.accountengine.SdkLoginCallback;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.accountengine.UserEngineLogic;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.ServiceFactory;
import com.tencent.livesdk.soentry.ICheckResult;
import java.io.File;
import java.util.Map;

public class LiveSDK
{
  private static final String LIVE_AUTH_URL = "https://ilive.qq.com/base/h5/phone_collect.html";
  private static final String TAG = "livesdk";
  private static LiveConfig liveConfig;
  public static LiveEngine liveEngine;
  private static File soCacheDir;
  public static UserEngine userEngine;
  
  public static AudienceRoomViewPager createAudienceRoomPager(Context paramContext, EnterRoomConfig paramEnterRoomConfig)
  {
    reportStartEnter(paramEnterRoomConfig);
    return LiveAudience.createAudienceRoomPager(paramContext, paramEnterRoomConfig);
  }
  
  public static LiveFragment createLiveFragment(int paramInt, PageFactory.FragmentActionCallback paramFragmentActionCallback)
  {
    return PageFactory.createFragment(paramInt, paramFragmentActionCallback);
  }
  
  public static void enterLive(Context paramContext, EnterRoomConfig paramEnterRoomConfig)
  {
    ((AppGeneralInfoService)liveEngine.getService(AppGeneralInfoService.class)).setSource(paramEnterRoomConfig.source);
    if ((userEngine.getCurrentRoomEngine() != null) && (!userEngine.getCurrentRoomEngine().isUnInit())) {
      ((LogInterface)liveEngine.getService(LogInterface.class)).i("livesdk", "enterLive--has currentRoom", new Object[0]);
    } else {
      reportStartEnter(paramEnterRoomConfig);
    }
    if (paramEnterRoomConfig.mutilRoom)
    {
      MultiAudienceRoomActivity.a(paramEnterRoomConfig, paramContext);
      return;
    }
    AudienceRoomActivity.startAudienceRoom(paramEnterRoomConfig, paramContext);
  }
  
  public static String getILiveBeaconKey()
  {
    return "000005YECQ3C2LO8";
  }
  
  public static String getILiveDeviceId()
  {
    LiveEngine localLiveEngine = liveEngine;
    if (localLiveEngine != null) {
      return ((AppGeneralInfoService)localLiveEngine.getService(AppGeneralInfoService.class)).getDeviceID();
    }
    return "";
  }
  
  public static File getLibCacheDir(Context paramContext)
  {
    if (soCacheDir == null)
    {
      soCacheDir = new File(paramContext.getFilesDir().getParentFile(), "/livesdk_lib");
      if (!soCacheDir.exists()) {
        soCacheDir.mkdirs();
      }
    }
    return soCacheDir;
  }
  
  public static void init(Context paramContext, LiveConfig paramLiveConfig)
  {
    LiveEngine localLiveEngine = liveEngine;
    if ((localLiveEngine != null) && (userEngine != null))
    {
      ((LogInterface)localLiveEngine.getService(LogInterface.class)).e("livesdk", "iLiveSdk re init", new Object[0]);
      return;
    }
    liveConfig = paramLiveConfig;
    Log.i("livesdk", "preInit live sdk...");
    ServiceFactory.init();
    ServiceFactory.config(liveConfig.serviceConfig);
    LiveCaseFactory.config(liveConfig.liveCaseConfig);
    sdkInit(paramContext);
  }
  
  public static void initLoginData(LoginRequest paramLoginRequest)
  {
    userEngine.initLoginRequestData(paramLoginRequest);
    if (userEngine.loginSuccess()) {
      updateAuthTicket(paramLoginRequest);
    }
  }
  
  public static void initSync(Context paramContext, LiveConfig paramLiveConfig, ICheckResult paramICheckResult)
  {
    LiveEngine localLiveEngine = liveEngine;
    if ((localLiveEngine != null) && (userEngine != null))
    {
      ((LogInterface)localLiveEngine.getService(LogInterface.class)).e("livesdk", "iLiveSdk re init", new Object[0]);
      return;
    }
    liveConfig = paramLiveConfig;
    Log.i("livesdk", "preInit live sdk...");
    ServiceFactory.init();
    ServiceFactory.config(liveConfig.serviceConfig);
    LiveCaseFactory.config(liveConfig.liveCaseConfig);
    SoRelyCoreEntry.checkRely(paramContext.getApplicationContext(), new LiveSDK.1(paramContext, paramICheckResult));
  }
  
  public static void login(LoginRequest paramLoginRequest, SdkLoginCallback paramSdkLoginCallback)
  {
    userEngine.initLoginRequestData(paramLoginRequest);
    userEngine.getEnginLogic().login(paramLoginRequest, new LiveSDK.2(paramSdkLoginCallback, paramLoginRequest));
  }
  
  public static void logout()
  {
    UserEngine localUserEngine = userEngine;
    if (localUserEngine != null) {
      localUserEngine.uninit();
    }
  }
  
  public static void openAuthWeb(Context paramContext)
  {
    String str = ((LiveConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LiveConfigServiceInterface.class)).getString("live_auth_face_url", "https://ilive.qq.com/base/h5/phone_collect.html");
    Intent localIntent = new Intent(paramContext, AuthWebActivity.class);
    localIntent.putExtra("url", str);
    StartWebViewHelper.startInnerWebView(paramContext, localIntent);
  }
  
  public static void openLiveSetting(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, DevOptionActivity.class);
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  private static void reportStartEnter(EnterRoomConfig paramEnterRoomConfig)
  {
    QualityReportServiceInterface localQualityReportServiceInterface = (QualityReportServiceInterface)liveEngine.getService(QualityReportServiceInterface.class);
    if (paramEnterRoomConfig.extData != null)
    {
      String str = paramEnterRoomConfig.extData.getString("roomProcessState", "0");
      long l = paramEnterRoomConfig.extData.getLong("startEnterTime", System.currentTimeMillis());
      Bundle localBundle = new Bundle();
      localBundle.putString("roomProcessState", str);
      localBundle.putLong("startEnterTime", l);
      localQualityReportServiceInterface.getAudQualityReporter().reportStartEnter(paramEnterRoomConfig.roomId, TextUtils.isEmpty(paramEnterRoomConfig.videoUrl) ^ true, userEngine.loginSuccess(), paramEnterRoomConfig.preloadedVideo, localBundle);
      return;
    }
    localQualityReportServiceInterface.getAudQualityReporter().reportStartEnter(paramEnterRoomConfig.roomId, TextUtils.isEmpty(paramEnterRoomConfig.videoUrl) ^ true, userEngine.loginSuccess(), paramEnterRoomConfig.preloadedVideo, null);
  }
  
  private static void sdkInit(Context paramContext)
  {
    if (liveConfig.sdkType != null)
    {
      int i = LiveSDK.3.$SwitchMap$com$tencent$ilive$LiveConfig$SDKType[liveConfig.sdkType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            LiveAnchor.initPageConfig();
            LiveAudienceFull.initPageConfig();
          }
        }
        else if (liveConfig.liteSdk) {
          LiveAudienceLite.initPageConfig();
        } else {
          LiveAudienceFull.initPageConfig();
        }
      }
      else {
        LiveAnchor.initPageConfig();
      }
    }
    else
    {
      LiveAnchor.initPageConfig();
      LiveAudienceFull.initPageConfig();
    }
    liveEngine = new LiveEngine(paramContext, ConfigUtil.getEnginConfig(liveConfig));
    userEngine = liveEngine.createUserEngine();
    BizEngineMgr.getInstance().setLiveEngine(liveEngine);
    BizEngineMgr.getInstance().setUserEngine(userEngine);
    BizEngineMgr.getInstance().init();
  }
  
  public static void setNoLoginObserver(NoLoginObserver paramNoLoginObserver)
  {
    ((LoginServiceInterface)userEngine.getService(LoginServiceInterface.class)).setNoLoginObserver(paramNoLoginObserver);
  }
  
  public static void setReportInfo(ReportInfo.Builder paramBuilder)
  {
    AppGeneralInfoService localAppGeneralInfoService = (AppGeneralInfoService)liveEngine.getService(AppGeneralInfoService.class);
    if (paramBuilder.getFromId() != null) {
      localAppGeneralInfoService.setFromId(paramBuilder.getFromId());
    }
    if (paramBuilder.getSource() != null) {
      localAppGeneralInfoService.setSource(paramBuilder.getSource());
    }
  }
  
  public static void startLive(Context paramContext, int paramInt, StartLiveConfig paramStartLiveConfig)
  {
    paramStartLiveConfig = new Intent();
    paramStartLiveConfig.putExtra("screen_orientation_landscape", false);
    paramStartLiveConfig.setFlags(335544320);
    if (PageFactory.getActivityConfig().get().get(Integer.valueOf(paramInt)) == null)
    {
      LivePrepareActivity.startPrepareActivity(paramContext, paramStartLiveConfig);
      return;
    }
    PageFactory.startActivity(paramStartLiveConfig, paramContext, paramInt);
  }
  
  public static void unInit()
  {
    LiveEngine localLiveEngine = liveEngine;
    if (localLiveEngine != null) {
      localLiveEngine.unInit();
    }
    ServiceFactory.unInit();
    UIConfig.bizModulesConfigMap.clear();
    UIConfig.componentConfigMap.clear();
    PageFactory.getActivityConfig().clear();
    PageFactory.getFragmentConfig().clear();
    userEngine = null;
    liveEngine = null;
  }
  
  public static void updateAuthTicket(LoginRequest paramLoginRequest)
  {
    userEngine.getEnginLogic().updateAuthTicket(paramLoginRequest.id, paramLoginRequest.token);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.LiveSDK
 * JD-Core Version:    0.7.0.1
 */