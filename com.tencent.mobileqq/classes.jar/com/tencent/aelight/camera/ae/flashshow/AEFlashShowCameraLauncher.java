package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.flashshow.util.PostEditLaunchUtil;
import com.tencent.aelight.camera.aebase.QIMFlashShowCaptureActivity;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkLaucher;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class AEFlashShowCameraLauncher
{
  public static AEFlashShowCameraLauncher a()
  {
    return new AEFlashShowCameraLauncher();
  }
  
  private void a(@NonNull Activity paramActivity, @NonNull Bundle paramBundle)
  {
    AEQLog.a("AEFlashShowCameraLauncher", "[AE Profiler] launchMultiCameraFromFlash");
    int i = paramBundle.getInt("EDITOR_ENTRANCE", 0);
    if ((i != 2) && (i != 3))
    {
      paramBundle = b(paramBundle);
      paramBundle.putBoolean("flag_clear_top", true);
      QIMFlashShowCaptureActivity.a(paramActivity, paramBundle, 20000);
    }
    else
    {
      paramBundle.putInt("EDITOR_ENTRANCE", i);
      PostEditLaunchUtil.a(paramActivity, paramBundle);
    }
    paramActivity.overridePendingTransition(2130772373, 2130772092);
  }
  
  private void a(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("VIDEO_STORY_FROM_TYPE")) {
      paramBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.L.a());
    }
    if (!paramBundle.containsKey("edit_video_type")) {
      paramBundle.putInt("edit_video_type", 10028);
    }
    if (!paramBundle.containsKey("ability_flag")) {
      paramBundle.putInt("ability_flag", 1);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
    int j = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    if ((i != 0) || (j != 0)) {
      ThreadManager.excute(new AEFlashShowCameraLauncher.1(this, paramBoolean), 128, null, false);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool2 = b();
    boolean bool1 = false;
    if (bool2)
    {
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
      ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, null, false);
      ShortVideoResDownload.a(paramQQAppInterface);
      bool1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraResExist();
    }
    return bool1;
  }
  
  private static Bundle b(@Nullable Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("AECAMERA_MODE", 200);
    if (!localBundle.containsKey("VIDEO_STORY_FROM_TYPE")) {
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.L.a());
    }
    localBundle.putInt("entrance_type", 120);
    localBundle.putInt("edit_video_type", 10028);
    localBundle.putInt("capture_intent_mode", 8);
    if (!localBundle.getBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true))
    {
      AEQLog.b("AEFlashShowCameraLauncher", "[AdditionalPick] setDataForCircleAECamera---canNotPickVideo set only photo flag for camera");
      localBundle.putInt("ability_flag", 2);
    }
    return localBundle;
  }
  
  private static boolean b()
  {
    int i;
    if ((!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(CameraCompatibleConstants.w)) && (!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isNotSupportFilterBasedSdk())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    boolean bool = VcSystemInfo.isBeautySupported();
    try
    {
      localClass = Class.forName("android.opengl.EGL14");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass;
      label64:
      break label64;
    }
    localClass = null;
    return (bool) && (localClass != null) && (Build.VERSION.SDK_INT >= 17);
  }
  
  private boolean c()
  {
    IModule localIModule = AVBizModuleFactory.getModuleByName("默认");
    return (localIModule != null) && (!"true".equals(localIModule.checkAVFocus()));
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    boolean bool1 = c();
    int i = 0;
    if (bool1)
    {
      AEQLog.c("AEFlashShowCameraLauncher", "【2131916633】");
      QQToast.makeText(paramActivity, 0, 2131916633, 0).show();
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    a(localBundle);
    boolean bool3 = ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).isCameraResReady();
    boolean bool2 = QzoneConfig.getQFSJumpPhotoList();
    paramBundle = (HashMap)localBundle.get("key_attrs");
    bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (!paramBundle.isEmpty())
      {
        bool1 = bool2;
        if (paramBundle.containsKey("target")) {
          if ("1".equals(paramBundle.get("target")))
          {
            bool1 = true;
          }
          else
          {
            bool1 = bool2;
            if ("0".equals(paramBundle.get("target"))) {
              bool1 = false;
            }
          }
        }
      }
    }
    if (localBundle.getBoolean("IS_BACK_EDIT")) {
      if (localBundle.getBoolean("IS_FROM_CAPTURE")) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("cameraResReady: ");
    paramBundle.append(bool3);
    AEQLog.b("AEFlashShowCameraLauncher", paramBundle.toString());
    if (bool3)
    {
      AEQLog.b("AEFlashShowCameraLauncher", "【Choose】 QIMCameraCaptureActivity");
      paramInt = i;
      if (bool1) {
        paramInt = 1;
      }
      localBundle.putInt("AECAMERA_TAB_SELECTED", paramInt);
      a(paramActivity, localBundle);
    }
    else
    {
      AEQLog.b("AEFlashShowCameraLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      if (bool1)
      {
        paramBundle = new Intent();
        paramBundle.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
        QQWinkLaucher.a(paramActivity, paramBundle, null);
      }
      else
      {
        ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launchForResult(paramActivity, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getAEPituCameraUnitClass().getName(), localBundle, paramInt, localBundle.getBoolean("resource_need_all_wait", false));
      }
    }
    a(bool3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraLauncher
 * JD-Core Version:    0.7.0.1
 */