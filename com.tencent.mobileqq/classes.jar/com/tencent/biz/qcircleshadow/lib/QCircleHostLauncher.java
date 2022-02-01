package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.ae.light.camera.api.IAEEditorManagerForQzone;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ad.api.IVasAdApi;
import com.tencent.mobileqq.vas.ad.api.IVasAdApi.InnerVasRewardAdCallback;
import com.tencent.mobileqq.vas.ad.api.QCircleVasRewardAdParams;
import java.util.Map;

public class QCircleHostLauncher
{
  private static final String TAG = "QCircleHostLauncher";
  
  public static void VasAdvInitDeviceInfo()
  {
    ((IVasAdApi)QRoute.api(IVasAdApi.class)).VasAdvInitDeviceInfo();
  }
  
  public static void doJumpAction(Context paramContext, String paramString)
  {
    ((IJumpApi)QRoute.api(IJumpApi.class)).doJumpAction(paramContext, paramString);
  }
  
  public static void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).forwardToMoodSelectLocation(paramContext, paramString, paramInt, paramBundle);
  }
  
  public static Intent handleQCircleHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt)
  {
    return QCircleServiceImpl.getQQService().handleQCircleHybirdActivityIntent(paramContext, paramString, paramIntent, paramInt);
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
  
  public static void openFlutterPageForQCircle(Context paramContext, String paramString1, String paramString2, Map<String, Object> paramMap, Bundle paramBundle)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).openFlutterPageForQCircle(paramContext, paramString1, paramString2, paramMap, paramBundle);
  }
  
  public static void reportDC02880(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).reportDC02880(paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static void requestAd(Context paramContext, QCircleVasRewardAdParams paramQCircleVasRewardAdParams, IVasAdApi.InnerVasRewardAdCallback paramInnerVasRewardAdCallback)
  {
    ((IVasAdApi)QRoute.api(IVasAdApi.class)).requestAd(paramContext, paramQCircleVasRewardAdParams, paramInnerVasRewardAdCallback);
  }
  
  public static void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).startAddFriend(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public static void startAddFriend(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).startAddFriend(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2, paramArrayOfByte);
  }
  
  public static void startNewFriendList(Context paramContext)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).startNewFriendList(paramContext);
  }
  
  public static void startProfileCardActivity(Context paramContext, String paramString)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).startProfileCardActivity(paramContext, paramString);
  }
  
  public static void startQCircleHippyActivity(Context paramContext, Intent paramIntent)
  {
    ((IQZoneHelper)QRoute.api(IQZoneHelper.class)).startQCircleHippyActivity(paramContext, paramIntent);
  }
  
  public static void startWithPublicFragmentActivity(Context paramContext, Intent paramIntent, Class paramClass)
  {
    QPublicFragmentActivity.a(paramContext, paramIntent, paramClass);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostLauncher
 * JD-Core Version:    0.7.0.1
 */