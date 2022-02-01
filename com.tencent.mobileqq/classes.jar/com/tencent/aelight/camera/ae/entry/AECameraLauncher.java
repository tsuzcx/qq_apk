package com.tencent.aelight.camera.ae.entry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraLauncher;
import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.ae.util.PicChooseJumpUtil;
import com.tencent.aelight.camera.aebase.AECameraPlugin.TakePhotoParam;
import com.tencent.aelight.camera.aebase.AECaptureContext;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

public class AECameraLauncher
{
  private static long a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, AECameraPlugin.TakePhotoParam paramTakePhotoParam)
  {
    if (b()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    if (paramTakePhotoParam != null)
    {
      localBundle.putBoolean("key_camera_prefer_id", paramTakePhotoParam.d);
      localBundle.putBoolean("key_has_countdown", paramTakePhotoParam.f);
      localBundle.putBoolean("key_disable_face_detect", paramTakePhotoParam.h);
      localBundle.putBoolean("key_need_check_sensitive", paramTakePhotoParam.g);
      localBundle.putString("key_guide_image", paramTakePhotoParam.e);
    }
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772373, 2130772092);
  }
  
  public static void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    AELaunchRecorder.d().a("AECameraLauncher---launchAECameraUnit-begin");
    StoryPublishLauncher localStoryPublishLauncher = StoryPublishLauncher.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (d(localBundle))
    {
      AEQLog.b("AECameraLauncher", "isOpenFrontFirst: true");
      CameraHelper.a(1);
    }
    if (e(localBundle))
    {
      AEQLog.b("AECameraLauncher", "isOpenBackFirst: true");
      CameraHelper.a(2);
    }
    CameraHelper.d();
    localStoryPublishLauncher.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772373, 2130772092);
    StoryReportor.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    AELaunchRecorder.d().a("AECameraLauncher---launchAECameraUnit-end");
    AELaunchRecorder.d().a(false);
    AELaunchRecorder.d().f();
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle, int paramInt)
  {
    AEQLog.a("AECameraLauncher", "[AE Profiler] launchAECircleAlbumAndCamera");
    paramBundle = c(paramBundle);
    StoryPublishLauncher.a().a(paramBundle);
    QIMCameraCaptureActivity.a(paramActivity, paramBundle, paramInt);
    paramActivity.overridePendingTransition(2130772373, 2130772092);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    StoryPublishLauncher localStoryPublishLauncher = StoryPublishLauncher.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (d(localBundle))
    {
      AEQLog.b("AECameraLauncher", "isOpenFrontFirst: true");
      CameraHelper.a(1);
    }
    if (e(localBundle))
    {
      AEQLog.b("AECameraLauncher", "isOpenBackFirst: true");
      CameraHelper.a(2);
    }
    localStoryPublishLauncher.a(paramContext, localBundle);
    StoryReportor.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
  }
  
  private static void a(@NonNull Bundle paramBundle, String paramString, @NonNull Uri paramUri)
  {
    paramUri = paramUri.getQueryParameter(paramString);
    if (!TextUtils.isEmpty(paramUri)) {
      paramBundle.putString(paramString, paramUri);
    }
  }
  
  public static boolean a()
  {
    return a(true);
  }
  
  private static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    boolean bool = PermissionUtils.isStorePermissionEnable(paramActivity);
    LinkedList localLinkedList = new LinkedList();
    if ((bool ^ true))
    {
      localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
      localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
    }
    if (localLinkedList.size() > 0)
    {
      paramActivity.requestPermissions((String[])localLinkedList.toArray(new String[0]), 1);
      return true;
    }
    return false;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("flag_clear_top"));
  }
  
  private static boolean a(boolean paramBoolean)
  {
    boolean bool1 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE);
    boolean bool2 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    if ((bool1) && (bool2))
    {
      int i = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
      Object localObject = (IAEResUtil)QRoute.api(IAEResUtil.class);
      if (i != 2)
      {
        i = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
        localObject = (IAEResUtil)QRoute.api(IAEResUtil.class);
        if (i != 2)
        {
          bool1 = true;
          break label116;
        }
      }
      bool1 = false;
      label116:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isResReady] aeBaseRes + lightBaseRes soIsExist:");
      ((StringBuilder)localObject).append(bool1);
      AEQLog.b("AECameraLauncher", ((StringBuilder)localObject).toString());
      bool2 = bool1;
      if (paramBoolean)
      {
        if ((bool1) && (ShortVideoGuideUtil.a(AECaptureContext.a()))) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[isResReady] isCheckAVCodec soIsExist:");
        ((StringBuilder)localObject).append(paramBoolean);
        AEQLog.d("AECameraLauncher", ((StringBuilder)localObject).toString());
        bool2 = paramBoolean;
      }
      if (!bool2)
      {
        AEQLog.d("AECameraLauncher", "[isResReady] error soIsExist:false");
        return false;
      }
      return true;
    }
    AEQLog.d("AECameraLauncher", "[isResReady] error versionIsOK:false");
    return false;
  }
  
  public static void b(Context paramContext, @Nullable Bundle paramBundle)
  {
    AEQLog.a("AECameraLauncher", "[AE Profiler] launchAECameraFromCircle");
    paramBundle = c(paramBundle);
    StoryPublishLauncher localStoryPublishLauncher = StoryPublishLauncher.a();
    b(paramBundle);
    paramContext = (Activity)paramContext;
    localStoryPublishLauncher.a(paramContext, paramBundle, 20000);
    paramContext.overridePendingTransition(2130772373, 2130772092);
  }
  
  private static void b(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("flag_clear_top", true);
  }
  
  private static boolean b()
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre: ");
    localStringBuilder.append(a);
    localStringBuilder.append(" cur: ");
    localStringBuilder.append(l);
    QLog.d("AECameraLauncher", 2, localStringBuilder.toString());
    if (Math.abs(l - a) < 500L)
    {
      QLog.d("AECameraLauncher", 2, "isFastClick.");
      a = l;
      return true;
    }
    a = l;
    return false;
  }
  
  private static Bundle c(@Nullable Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("AECAMERA_MODE", 200);
    if (!localBundle.containsKey("VIDEO_STORY_FROM_TYPE")) {
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.x.a());
    }
    localBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    Object localObject = localBundle.getString("qq_camera_from_qcircle_scheme");
    paramBundle = (Bundle)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramBundle = localBundle.getString("key_polymerization_scheme");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[setDataForCircleAECamera] scheme:");
    ((StringBuilder)localObject).append(paramBundle);
    AEQLog.d("AECameraLauncher", ((StringBuilder)localObject).toString());
    localObject = localBundle;
    if (!TextUtils.isEmpty(paramBundle))
    {
      paramBundle = Uri.parse(paramBundle);
      localObject = localBundle;
      if (paramBundle != null)
      {
        localBundle.putString("tab", paramBundle.getQueryParameter("tab"));
        localObject = JumpUtil.a(localBundle, paramBundle.getQueryParameter("widgetinfo"));
        ((Bundle)localObject).putString("VIDEO_STORY_ACTIVITY_ID", paramBundle.getQueryParameter("activity_id"));
        a((Bundle)localObject, "editor_filter_id", paramBundle);
        a((Bundle)localObject, "editor_text_sticker_id", paramBundle);
        a((Bundle)localObject, "editor_image_template_id", paramBundle);
        a((Bundle)localObject, "editor_video_template_id", paramBundle);
        a((Bundle)localObject, "editor_text_id", paramBundle);
        a((Bundle)localObject, "editor_frame_id", paramBundle);
      }
    }
    ((Bundle)localObject).putInt("entrance_type", 120);
    ((Bundle)localObject).putInt("edit_video_type", 10026);
    ((Bundle)localObject).putInt("capture_intent_mode", 8);
    if (!((Bundle)localObject).getBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true))
    {
      AEQLog.b("AECameraLauncher", "[AdditionalPick] setDataForCircleAECamera---canNotPickVideo set only photo flag for camera");
      ((Bundle)localObject).putInt("ability_flag", 2);
    }
    return localObject;
  }
  
  public static void c(Context paramContext, @Nullable Bundle paramBundle)
  {
    if (!a((Activity)paramContext))
    {
      if ((a()) && (Build.VERSION.SDK_INT >= 21))
      {
        b(paramContext, paramBundle);
        return;
      }
      PicChooseJumpUtil.a(paramContext, new Intent().putExtras(paramBundle));
    }
  }
  
  public static void d(Context paramContext, @Nullable Bundle paramBundle)
  {
    if ((paramContext instanceof Activity)) {
      AEFlashShowCameraLauncher.a().a((Activity)paramContext, paramBundle, 0);
    }
  }
  
  private static boolean d(Bundle paramBundle)
  {
    boolean bool1 = CameraHelper.c();
    boolean bool2 = false;
    if (((bool1) || (paramBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) && ((paramBundle.getInt("AECAMERA_MODE") != 202) || (!CameraUtils.d())))
    {
      bool1 = bool2;
      if (paramBundle.getInt("AECAMERA_MODE") == 203)
      {
        bool1 = bool2;
        if (!CameraUtils.d()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean e(Bundle paramBundle)
  {
    return paramBundle.getInt("AECAMERA_MODE") == 208;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.entry.AECameraLauncher
 * JD-Core Version:    0.7.0.1
 */