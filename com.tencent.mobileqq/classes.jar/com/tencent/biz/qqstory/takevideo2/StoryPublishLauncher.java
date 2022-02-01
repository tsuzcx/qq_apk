package com.tencent.biz.qqstory.takevideo2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.AndroidRuntimeException;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.api.ICaptureQmcfSoDownloadLaunch;
import com.tencent.aelight.camera.api.IQIMCameraCapture;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.current.SessionWrap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class StoryPublishLauncher
{
  private Bundle a(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramBundle.putInt("capture_intent_mode", paramInt2);
    if ((paramInt2 == 0) || (paramInt2 == 1))
    {
      paramBundle.putInt("cameraDirection", paramInt1);
      paramBundle.putInt("firsttab", paramInt3);
      paramBundle.putInt("secondtab", paramInt4);
      paramBundle.putString("itemid", paramString1);
      paramBundle.putBoolean("qim_camera_open_specific", paramBoolean);
    }
    SLog.c("Q.qqstory.publish.StoryPublishLauncher", "initLaunchArgs captureMode=%s, tabType=%d, category=%d, itemId=%s, openSpecific=%b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, Boolean.valueOf(paramBoolean) });
    return paramBundle;
  }
  
  public static Bundle a(SessionWrap paramSessionWrap, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putInt("edit_video_type", paramInt1);
    localBundle.putInt("entrance_type", paramInt2);
    localBundle.putString("ARG_AIO_CLASS", paramString);
    if (paramInt1 == 10000) {
      localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    }
    localBundle.putBoolean("enable_local_video", false);
    return localBundle;
  }
  
  public static StoryPublishLauncher a()
  {
    return new StoryPublishLauncher();
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  private void a(boolean paramBoolean)
  {
    int j = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
    int k = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    if ((j != 0) || (k != 0))
    {
      ThreadManager.excute(new StoryPublishLauncher.1(this, paramBoolean), 128, null, false);
      int i = 1;
      if ((!paramBoolean) || (j != 1) || (k != 1)) {
        i = 0;
      }
      HashMap localHashMap = new HashMap();
      String str2 = "1";
      String str1;
      if (paramBoolean) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      localHashMap.put("videoSoUsable", str1);
      if (i != 0) {
        str1 = str2;
      } else {
        str1 = "0";
      }
      localHashMap.put("videoAndFilterReady", str1);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actShortVideoSoDownload", true, 0L, 0L, localHashMap, "");
    }
    QQStoryContext.a().b();
  }
  
  private boolean a(Context paramContext)
  {
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      SLog.b("Q.qqstory.publish.StoryPublishLauncher", "checkApiVersionDialog false");
      DialogUtil.a(paramContext, 230).setMessage(HardCodeUtil.a(2131714353)).setPositiveButton(2131694583, new StoryPublishLauncher.2(this)).show();
      return true;
    }
    return false;
  }
  
  public static boolean b()
  {
    return PtvFilterSoLoad.a(a(), BaseApplicationImpl.getContext());
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (a().isVideoChatting())
    {
      AEQLog.c("Q.qqstory.publish.StoryPublishLauncher", "【2131719097】");
      QQToast.a(paramActivity, 0, 2131719097, 0).a();
      return;
    }
    if (a(paramActivity)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    boolean bool;
    if (localBundle.getInt("entrance_type") == 104) {
      bool = ((IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class)).isAllResourceReady(a());
    } else {
      bool = ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).isCameraResReady();
    }
    a(localBundle);
    if (bool)
    {
      AEQLog.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launchForResult(paramActivity, localBundle, paramInt);
    }
    else
    {
      AEQLog.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launchForResult(paramActivity, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getAEPituCameraUnitClass().getName(), localBundle, paramInt, localBundle.getBoolean("resource_need_all_wait", false));
    }
    a(bool);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt5)
  {
    a(paramActivity, a(paramBundle, paramInt1, paramInt2, paramInt3, paramInt4, paramString1, paramString2, paramString3, paramBoolean), paramInt5);
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (a().isVideoChatting())
    {
      AEQLog.c("Q.qqstory.publish.StoryPublishLauncher", "【2131719097】");
      QQToast.a(paramContext, 0, 2131719097, 0).a();
      return;
    }
    if (a(paramContext)) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    boolean bool;
    if (localBundle.getInt("entrance_type") == 104) {
      bool = ((IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class)).isAllResourceReady(a());
    } else {
      bool = ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).isCameraResReady();
    }
    a(localBundle);
    if (bool)
    {
      AEQLog.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 QIMCameraCaptureActivity");
      ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launch(paramContext, localBundle);
    }
    else
    {
      AEQLog.b("Q.qqstory.publish.StoryPublishLauncher", "【Choose】 CaptureQmcfSoDownloadActivity");
      ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launch(paramContext, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getAEPituCameraUnitClass().getName(), localBundle, localBundle.getBoolean("resource_need_all_wait", false));
    }
    a(bool);
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("entrance_type")) {
      SLog.b("Q.qqstory.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
    }
    if (!paramBundle.containsKey("edit_video_type")) {
      paramBundle.putInt("edit_video_type", 10002);
    }
    if (!paramBundle.containsKey("ability_flag")) {
      paramBundle.putInt("ability_flag", 1);
    }
  }
  
  @Deprecated
  public boolean a()
  {
    return true;
  }
  
  public boolean a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (a().isVideoChatting())
    {
      QQToast.a(paramActivity, 0, 2131719097, 0).a();
      return false;
    }
    if (a(paramActivity)) {
      return false;
    }
    boolean bool;
    if ((paramBundle != null) && (paramBundle.getInt("entrance_type") == 104)) {
      bool = ((IShortVideoGuideUtil)QRoute.api(IShortVideoGuideUtil.class)).isAllResourceReady(a());
    } else {
      bool = ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).isCameraResReady();
    }
    SLog.a("Q.qqstory.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, filterOk=%s", Boolean.valueOf(bool), Boolean.valueOf(b()));
    QQStoryContext.a().b();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    a(localBundle);
    if (bool) {
      return true;
    }
    ((ICaptureQmcfSoDownloadLaunch)QRoute.api(ICaptureQmcfSoDownloadLaunch.class)).launchForResult(paramActivity, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getAEPituCameraUnitClass().getName(), localBundle, paramInt, true, true);
    return false;
  }
  
  public void b(Context paramContext, Bundle paramBundle)
  {
    if (a().isVideoChatting())
    {
      AEQLog.c("Q.qqstory.publish.StoryPublishLauncher", "【2131719097】");
      QQToast.a(paramContext, 0, 2131719097, 0).a();
      QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: isVideoChatting");
      return;
    }
    if (a(paramContext))
    {
      QLog.e("Q.qqstory.publish.StoryPublishLauncher", 1, "launchForPreview failed: not support short video");
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    a(localBundle);
    ((IQIMCameraCapture)QRoute.api(IQIMCameraCapture.class)).launch(paramContext, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher
 * JD-Core Version:    0.7.0.1
 */