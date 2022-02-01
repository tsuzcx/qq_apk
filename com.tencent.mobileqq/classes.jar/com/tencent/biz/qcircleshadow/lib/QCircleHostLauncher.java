package com.tencent.biz.qcircleshadow.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qcircleshadow.remotechecker.QCircleFlutterPluginInfo;
import com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginManager;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.flutter.api.IQFlutterRouterService;
import com.tencent.mobileqq.flutter.router.PageRouterBuilder;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QCircleHostLauncher
{
  private static final String TAG = "QCircleHostLauncher";
  private static final Map<String, String> darkColorMap;
  private static final Map<String, String> lightColorMap = new ConcurrentHashMap();
  
  static
  {
    darkColorMap = new ConcurrentHashMap();
    lightColorMap.put("color-bg-default", "#FFFAFAFB");
    lightColorMap.put("color-bg-detailspage", "#FF252525");
    lightColorMap.put("color-bg-backplate", "#FFF2F2F5");
    lightColorMap.put("color-bg-divider", "#FFE0E0E6");
    lightColorMap.put("color-bg-tag", "#FFEBEBF0");
    lightColorMap.put("color-bg-tag-unselected", "#FFF3F4F6");
    lightColorMap.put("color-icon-primary", "#FF000000");
    lightColorMap.put("color-icon-secondary", "#FF7A7A8D");
    lightColorMap.put("color-icon-light", "#FFB8B9C7");
    lightColorMap.put("color-icon-ghost", "#FFFFFFFF");
    lightColorMap.put("color-icon-warning", "#FFF44E4E");
    lightColorMap.put("color-icon-link", "#FF3067FF");
    lightColorMap.put("color-text-primary", "##FF000000");
    lightColorMap.put("color-text-secondary", "#FF7A7A8D");
    lightColorMap.put("color-text-light", "#FFB8B9C7");
    lightColorMap.put("color-text-ghost", "#FFFFFFFF");
    lightColorMap.put("color-text-warning", "#FFF44E4E");
    lightColorMap.put("color-text-link", "#FF3067FF");
    darkColorMap.put("color-bg-default", "#FF1A1A1A");
    darkColorMap.put("color-bg-detailspage", "#FF121212");
    darkColorMap.put("color-bg-backplate", "#FF121212");
    darkColorMap.put("color-bg-divider", "#FF333333");
    darkColorMap.put("color-bg-tag", "#33FFFFFF");
    darkColorMap.put("color-bg-tag-unselected", "#1AFFFFFF");
    darkColorMap.put("color-icon-primary", "#B3FFFFFF");
    darkColorMap.put("color-icon-secondary", "#8CFFFFFF");
    darkColorMap.put("color-icon-light", "#66FFFFFF");
    darkColorMap.put("color-icon-ghost", "#FFFFFFFF");
    darkColorMap.put("color-icon-warning", "#FFF44E4E");
    darkColorMap.put("color-icon-link", "#FF3067FF");
    darkColorMap.put("color-text-primary", "#E6FFFFFF");
    darkColorMap.put("color-text-secondary", "#99FFFFFF");
    darkColorMap.put("color-text-light", "#66FFFFFF");
    darkColorMap.put("color-text-ghost", "#FFFFFFFF");
    darkColorMap.put("color-text-warning", "#FFF44E4E");
    darkColorMap.put("color-text-link", "#FF3067FF");
  }
  
  public static void VasAdvInitDeviceInfo()
  {
    ((IVasRewardAdApi)QRoute.api(IVasRewardAdApi.class)).initDeviceInfo();
  }
  
  public static void doJumpAction(Context paramContext, String paramString)
  {
    ((IJumpApi)QRoute.api(IJumpApi.class)).doJumpAction(paramContext, paramString);
  }
  
  public static void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    QZoneHelper.forwardToMoodSelectLocation(paramContext, paramString, paramInt, paramBundle);
  }
  
  public static Intent handleQCircleHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    return QCircleServiceImpl.getQQService().handleQCircleHybirdActivityIntent(paramContext, paramString, paramIntent, paramInt);
  }
  
  private static void initDNFlutterParam(Map<String, Object> paramMap)
  {
    QCircleFlutterPluginInfo localQCircleFlutterPluginInfo = QCirclePluginManager.a().b(true);
    if (localQCircleFlutterPluginInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start load dynamic flutter");
      localStringBuilder.append(localQCircleFlutterPluginInfo.zipFileUrl);
      QLog.d("QCircleHostLauncher", 1, localStringBuilder.toString());
      paramMap.put("dynamicConfig", Boolean.valueOf(true));
      paramMap.put("dynamicPath", localQCircleFlutterPluginInfo.pluginZipPath);
      paramMap.put("dynamicUrl", localQCircleFlutterPluginInfo.zipFileUrl);
      paramMap.put("dynamicMd5", localQCircleFlutterPluginInfo.zipFileMD5);
      paramMap.put("dynamicSalt", localQCircleFlutterPluginInfo.salt);
      paramMap.put("dynamicVersion", localQCircleFlutterPluginInfo.version);
    }
  }
  
  public static void isCameraResReady()
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).isCameraResReady();
  }
  
  public static void jumpForAECircle(Context paramContext, Intent paramIntent)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).jumpForAECircle(paramContext, paramIntent);
  }
  
  public static void launchAECameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).launchAECameraFromCircle(paramContext, paramBundle);
  }
  
  public static void launchAEMutiCameraFromCircle(Context paramContext, Bundle paramBundle)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).launchAEMutiCameraFromCircle(paramContext, paramBundle);
  }
  
  public static void launchQQPhotoSelect(Context paramContext, Intent paramIntent)
  {
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).launchQQPhotoSelect(paramContext, paramIntent);
  }
  
  private static void necessaryFlutterParams(Map<String, Object> paramMap)
  {
    paramMap.put("currentUin", HostDataTransUtils.getAccount());
    paramMap.put("host_uin", HostDataTransUtils.getAccount());
    paramMap.put("qua", QUA.getQUA3());
    if (QCircleCommonUtil.isInNightMode())
    {
      paramMap.put("themeStyle", "1");
      paramMap.put("themeResource", darkColorMap);
    }
    else
    {
      paramMap.put("themeStyle", "0");
      paramMap.put("themeResource", lightColorMap);
    }
    initDNFlutterParam(paramMap);
  }
  
  public static void openFlutterPageForQCircle(Context paramContext, String paramString1, String paramString2, Map<String, Object> paramMap, Bundle paramBundle)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    necessaryFlutterParams((Map)localObject);
    paramString1 = new PageRouterBuilder().a((Map)localObject).a(paramString1).b(paramString2).a(true).b(true).c(true).a();
    ((IQFlutterRouterService)QCircleServiceImpl.getAppRunTime().getRuntimeService(IQFlutterRouterService.class, "all")).openPageForQCircle(paramContext, paramString1, paramBundle);
  }
  
  public static void reportDC02880(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new LpReportInfo_dc02880(2, 2, null, paramString2);
    paramString1.reserves6 = paramString3;
    LpReportManager.getInstance().reportToDC02880(paramString1, false, true);
  }
  
  public static void requestAd(Context paramContext, VasRewardAdParams paramVasRewardAdParams, VasRewardAdCallback paramVasRewardAdCallback)
  {
    ((IVasRewardAdApi)QRoute.api(IVasRewardAdApi.class)).requestAd((Activity)paramContext, paramVasRewardAdParams, paramVasRewardAdCallback);
  }
  
  public static void setNewSsoAndRestartApp(String paramString)
  {
    QCircleServiceImpl.getQQService().setNewSsoAndRestartApp(paramString);
  }
  
  public static void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    IAddFriendApi localIAddFriendApi = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
    paramString1 = localIAddFriendApi.startAddFriend(paramContext, 1, String.valueOf(paramString1), "", 3050, 3, paramString2, null, null, null, null);
    paramString1.putExtra("qcircle_isfollow", paramBoolean1);
    paramString1.putExtra("key_qcircle_stick", paramBoolean2);
    localIAddFriendApi.launchAddFriend(paramContext, paramString1);
  }
  
  public static void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte)
  {
    IAddFriendApi localIAddFriendApi = (IAddFriendApi)QRoute.api(IAddFriendApi.class);
    paramString1 = localIAddFriendApi.startAddFriend(paramContext, 1, String.valueOf(paramString1), "", 3050, 3, paramString2, paramArrayOfByte);
    paramString1.putExtra("qcircle_isfollow", paramBoolean1);
    paramString1.putExtra("key_qcircle_stick", paramBoolean2);
    localIAddFriendApi.launchAddFriend(paramContext, paramString1);
  }
  
  public static void startNewFriendList(Context paramContext)
  {
    paramContext.startActivity(((INewFriendApi)QRoute.api(INewFriendApi.class)).getStartNewFriendMoreSysMsgActivityIntent(paramContext, 0));
  }
  
  public static void startProfileCardActivity(Context paramContext, String paramString)
  {
    int i;
    if (paramString.equals(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())) {
      i = 0;
    } else if (((IFriendDataService)QCircleServiceImpl.getAppRunTime().getRuntimeService(IFriendDataService.class, "all")).isFriend(paramString)) {
      i = 1;
    } else {
      i = 115;
    }
    IProfileCardApi localIProfileCardApi = (IProfileCardApi)QRoute.api(IProfileCardApi.class);
    paramString = new AllInOne(paramString, i);
    paramString.profileEntryType = 128;
    paramString.sourceID = 3050;
    paramString.subSourceId = 1;
    localIProfileCardApi.openProfileCard(paramContext, paramString);
  }
  
  public static void startQCircleHippyActivity(Context paramContext, Intent paramIntent)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).startQCircleHippyActivity(paramContext, paramIntent);
  }
  
  public static void startWithPublicFragmentActivity(Context paramContext, Intent paramIntent, Class paramClass)
  {
    QPublicFragmentActivity.start(paramContext, paramIntent, paramClass);
  }
  
  public static void startWithPublicFragmentActivityForPeak(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2)
  {
    ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).startWithPublicFragmentActivityForPeak(paramContext, paramIntent, paramClass1, paramClass2);
  }
  
  public static void startWithPublicFragmentActivityForPeakForResult(Context paramContext, Intent paramIntent, Class paramClass1, Class paramClass2, int paramInt)
  {
    ((IPeakHelperApi)QRoute.api(IPeakHelperApi.class)).startWithPublicFragmentActivityForPeakForResult(paramContext, paramIntent, paramClass1, paramClass2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher
 * JD-Core Version:    0.7.0.1
 */