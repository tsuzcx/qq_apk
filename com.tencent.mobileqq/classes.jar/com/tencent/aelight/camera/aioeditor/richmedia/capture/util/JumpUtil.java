package com.tencent.aelight.camera.aioeditor.richmedia.capture.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.NewFlowCameraReporter;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditVideoActivity;
import com.tencent.aelight.camera.aioeditor.setting.CaptureEntranceParams;
import com.tencent.aelight.camera.aioeditor.setting.CapturePicParams;
import com.tencent.aelight.camera.aioeditor.setting.CaptureVideoParams;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoActivity;
import com.tencent.aelight.camera.api.IAECaptureMode;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.current.SessionWrap;
import org.jetbrains.annotations.NotNull;

public class JumpUtil
{
  public static Bundle a(Bundle paramBundle, String paramString)
  {
    String str1 = paramBundle.getString("KEY_CURRENT_SELECT_ID");
    boolean bool = TextUtils.isEmpty(paramString);
    String str4 = "";
    String str3;
    String str2;
    if (!bool)
    {
      String[] arrayOfString = paramString.split("\\^");
      if (arrayOfString.length > 0) {
        paramString = arrayOfString[0];
      } else {
        paramString = "";
      }
      if (arrayOfString.length == 1)
      {
        str1 = arrayOfString[0];
        paramString = ((IAECaptureMode)QRoute.api(IAECaptureMode.class)).getNormalModeName();
      }
      if (arrayOfString.length > 1) {
        str1 = arrayOfString[1];
      }
      str3 = str1;
      str2 = paramString;
      if (arrayOfString.length > 2)
      {
        str4 = arrayOfString[2];
        str3 = str1;
        str2 = paramString;
      }
    }
    else
    {
      str2 = "";
      str3 = str1;
    }
    if (!TextUtils.isEmpty(str3))
    {
      if (!TextUtils.isEmpty(str4)) {
        paramBundle.putString("KEY_CURRENT_TYPE", str4);
      } else {
        paramBundle.putString("KEY_CURRENT_TYPE", " ");
      }
      paramBundle.putString("KEY_CURRENT_TAB", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).switchTabToName(str2));
    }
    if (!TextUtils.isEmpty(str3)) {
      paramBundle.putString("KEY_CURRENT_SELECT_ID", str3);
    }
    return paramBundle;
  }
  
  @NotNull
  private static EditVideoParams a(Activity paramActivity, LocalMediaInfo paramLocalMediaInfo, CaptureVideoParams paramCaptureVideoParams, int paramInt1, Bundle paramBundle, EditVideoParams.EditSource paramEditSource, int paramInt2)
  {
    paramLocalMediaInfo = new EditVideoParams(paramInt2, paramInt1, paramEditSource, paramBundle);
    if (paramCaptureVideoParams != null) {
      paramLocalMediaInfo.b = paramCaptureVideoParams.c;
    }
    paramLocalMediaInfo.h = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    paramLocalMediaInfo.d.putBoolean("enable_hw_encode", true);
    if (QLog.isColorLevel())
    {
      paramCaptureVideoParams = new StringBuilder();
      paramCaptureVideoParams.append("EditVideoParams params:");
      paramCaptureVideoParams.append(paramLocalMediaInfo.toString());
      QLog.d("JumpUtil", 2, paramCaptureVideoParams.toString());
    }
    long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
    if (l != 0L) {
      paramLocalMediaInfo.d.putLong("troop_uin", l);
    }
    return paramLocalMediaInfo;
  }
  
  public static String a(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("mqqapi://"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://videostory/takevideo?from=qzoneTail&widgetinfo=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&cmode=all");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    paramString2 = "mqqapi://qcircle/opencamera?activity_id=circle_takesame";
    if (!bool)
    {
      paramString2 = new StringBuilder();
      paramString2.append("mqqapi://qcircle/opencamera?activity_id=circle_takesame");
      paramString2.append("&tab=camera&widgetinfo=");
      paramString2.append(paramString1);
      paramString2 = paramString2.toString();
    }
    return paramString2;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return;
      }
      paramBundle.putInt("qq_sub_business_id", 3);
      paramBundle.putInt("entrance_type", 10001);
      paramBundle.putLong("qzone_slide_enable_mask", 50043L);
      paramBundle.putBoolean("from_qzone_slideshow", true);
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle);
      localIntent.addFlags(268435456);
      QLog.e("QzoneSlideShowPreparingFragment", 2, "jumpToSlideShowEditVideoActivityForQzone start!");
      PublicFragmentActivityForPeak.b(paramActivity.getApplicationContext(), localIntent, QzoneSlideShowPreparingFragment.class);
      paramActivity.overridePendingTransition(2130772014, 2130772018);
    }
  }
  
  public static void a(Activity paramActivity, AEPhotoCaptureResult paramAEPhotoCaptureResult, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramCaptureEntranceParams == null) {
        return;
      }
      CapturePicParams localCapturePicParams = paramCaptureEntranceParams.c();
      if (localCapturePicParams == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
        }
        return;
      }
      boolean bool = localCapturePicParams.f();
      int i = paramCaptureEntranceParams.c;
      int j = localCapturePicParams.e();
      int k = paramCaptureEntranceParams.b();
      localCapturePicParams.c();
      localCapturePicParams.g();
      Object localObject = EditPicActivity.startEditPic(paramActivity, paramAEPhotoCaptureResult.filePath, true, localCapturePicParams.a, true, bool, true, false, false, false, i, k, j, false, null);
      ((Intent)localObject).putExtra("qcamera_photo_filepath", paramAEPhotoCaptureResult.filePath);
      ((Intent)localObject).putExtra("qcamera_rotate", paramAEPhotoCaptureResult.orientation);
      ((Intent)localObject).putExtra("camera_type", 103);
      ((Intent)localObject).putExtra("state", paramBundle);
      paramBundle = localCapturePicParams.a();
      paramCaptureEntranceParams = (CaptureEntranceParams)localObject;
      if (paramBundle != null)
      {
        ((Intent)localObject).putExtra("uin", paramBundle.a);
        ((Intent)localObject).putExtra("uintype", paramBundle.c);
        ((Intent)localObject).putExtra("troop_uin", paramBundle.d);
        ((Intent)localObject).putExtra("uinname", paramBundle.b);
        paramCaptureEntranceParams = AIOUtils.a((Intent)localObject, null);
      }
      paramCaptureEntranceParams.putExtra("edit_video_way", paramInt);
      paramCaptureEntranceParams.putExtra("qq_sub_business_id", localCapturePicParams.h());
      paramBundle = SplashActivity.class.getName();
      localObject = localCapturePicParams.b();
      if ((ChatActivity.class.getName().equals(localObject)) || (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getQQGuildLiveRoomActivityClassName().equals(localObject))) {
        paramBundle = (Bundle)localObject;
      }
      NewFlowCameraReporter.a("finish");
      NewFlowCameraReporter.a(paramCaptureEntranceParams);
      paramCaptureEntranceParams.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle);
      if (paramAEPhotoCaptureResult.type == 1) {
        paramCaptureEntranceParams.putExtra("editpic_cameratype", 1);
      } else if (paramAEPhotoCaptureResult.type == 0) {
        paramCaptureEntranceParams.putExtra("editpic_cameratype", 2);
      }
      paramActivity.startActivityForResult(paramCaptureEntranceParams, 1012);
      FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
    }
  }
  
  public static void a(Activity paramActivity, BaseVideoCaptureResult paramBaseVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (paramCaptureEntranceParams == null) {
        return;
      }
      CaptureVideoParams localCaptureVideoParams = paramCaptureEntranceParams.d();
      if (localCaptureVideoParams == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
        }
        return;
      }
      long l = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
      if ((paramActivity.getIntent() != null) && (l != -1L)) {
        i = (int)l;
      } else {
        i = 1099;
      }
      if ((localCaptureVideoParams.a) && (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isTransitionSwtichOpen())) {
        j = i | 0x10;
      } else {
        j = i | 0x20;
      }
      int i = j;
      if (localCaptureVideoParams.a()) {
        i = j | 0x200;
      }
      int j = i;
      if (localCaptureVideoParams.b()) {
        j = i | 0x100;
      }
      i = j;
      if (paramCaptureEntranceParams.a != 10013)
      {
        i = j;
        if (paramCaptureEntranceParams.a != 10012)
        {
          i = j;
          if (paramCaptureEntranceParams.a != 10007) {
            i = j | 0x1000;
          }
        }
      }
      j = i;
      if (!localCaptureVideoParams.b) {
        j = i & 0xFFFFFFFE;
      }
      Bundle localBundle;
      if (paramBundle2 == null) {
        localBundle = new Bundle();
      } else {
        localBundle = paramBundle2;
      }
      if (paramCaptureEntranceParams.a == 10012)
      {
        if ((paramLocalMediaInfo.mDuration > 20000L) || (paramLocalMediaInfo.mTotalDuration > 20000L))
        {
          localBundle.putBoolean("extra_enable_revert", false);
          localBundle.putBoolean("extra_enable_slow", false);
        }
        boolean bool1 = localBundle.getBoolean("needVideoDoodle", false);
        boolean bool2 = localBundle.getBoolean("needVideoWording", false);
        k = j;
        if (!bool1) {
          k = j & 0xFFFFFBFF;
        }
        i = k;
        if (!bool2) {
          i = k & 0xFFFFFFFE;
        }
      }
      else if (paramCaptureEntranceParams.a == 10013)
      {
        if (paramLocalMediaInfo.mDuration <= 20000L)
        {
          i = j;
          if (paramLocalMediaInfo.mTotalDuration <= 20000L) {}
        }
        else
        {
          localBundle.putBoolean("extra_enable_revert", false);
          localBundle.putBoolean("extra_enable_slow", false);
          i = j;
        }
      }
      else if (paramCaptureEntranceParams.a != 10000)
      {
        i = j;
        if (paramCaptureEntranceParams.a != 10007) {}
      }
      else
      {
        i = j & 0xFFFFFFDF;
      }
      if (paramLocalMediaInfo.mDuration > 80000L) {
        localBundle.putBoolean("extra_enable_slow", false);
      }
      Object localObject = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
      if (localObject != null)
      {
        localBundle.putString("uin", ((SessionWrap)localObject).a);
        localBundle.putInt("uintype", ((SessionWrap)localObject).c);
        localBundle.putString("troop_uin", ((SessionWrap)localObject).d);
        localBundle.putString("uinname", ((SessionWrap)localObject).b);
      }
      localObject = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localObject != null) {
        localBundle.putParcelable("edit_send_session_info", (Parcelable)localObject);
      }
      localBundle.putInt("qq_sub_business_id", localCaptureVideoParams.c());
      localBundle.putInt("entrance_type", paramCaptureEntranceParams.b);
      paramBaseVideoCaptureResult = new EditTakeVideoSource(paramBaseVideoCaptureResult.videoMp4FilePath, paramBaseVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      j = paramCaptureEntranceParams.c;
      int k = localCaptureVideoParams.d();
      VideoEditReport.c(k);
      paramLocalMediaInfo = a(paramActivity, paramLocalMediaInfo, localCaptureVideoParams, i, localBundle, paramBaseVideoCaptureResult, j);
      if ((paramBundle2 != null) && (paramBundle2.getBoolean("from_qzone_slideshow")))
      {
        paramBaseVideoCaptureResult = new Intent(paramActivity, QzoneEditVideoActivity.class);
        paramBaseVideoCaptureResult.putExtra("qqstory_slide_show_scene", SlideShowPhotoListManager.a().e());
        paramBaseVideoCaptureResult.putExtra("qqstory_slide_show_entrance", SlideShowPhotoListManager.a().d());
      }
      else
      {
        paramBaseVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
      }
      StoryIntentUtils.a(paramBaseVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
      paramBaseVideoCaptureResult.putExtra("short_video_entrance_type", k);
      paramBaseVideoCaptureResult.putExtra(EditVideoParams.class.getName(), paramLocalMediaInfo);
      if (paramCaptureEntranceParams.a == 10012) {
        paramBaseVideoCaptureResult.putExtra("op_department", "grp_tribe");
      } else if (paramCaptureEntranceParams.a == 10013) {
        paramBaseVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
      } else {
        paramBaseVideoCaptureResult.putExtra("op_department", "grp_qq");
      }
      paramBaseVideoCaptureResult.putExtra("op_type", "video_edit");
      paramBaseVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
      paramBaseVideoCaptureResult.putExtra("state", paramBundle1);
      paramBaseVideoCaptureResult.putExtra("edit_video_way", paramInt);
      paramBaseVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getStoryShareType(paramActivity.getIntent()));
      paramBaseVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", ((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).getAEFromType(paramActivity.getIntent()));
      if ((paramActivity instanceof QzoneEditVideoActivity))
      {
        ((QzoneEditVideoActivity)paramActivity).a(paramBaseVideoCaptureResult);
        return;
      }
      paramActivity.startActivityForResult(paramBaseVideoCaptureResult, paramCaptureEntranceParams.a);
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    int i = ParamsManager.a().i();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mqqapi://videostory/takevideo?from=aioChats&widgetinfo=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&cmode=all");
    localObject = ((StringBuilder)localObject).toString();
    if (i == 1)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&activity_id=aio_n_takesame");
      paramString = paramString.toString();
    }
    else
    {
      paramString = (String)localObject;
      if (i == 0)
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject);
        paramString.append("&activity_id=aio_1_takesame");
        paramString = paramString.toString();
      }
    }
    localIntent.setData(Uri.parse(paramString));
    JumpActivity.processIntent(localIntent);
    JumpActivity.handleIntentForQQBrowser(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, ICameraEntrance paramICameraEntrance)
  {
    paramICameraEntrance = new Intent(paramActivity, SplashActivity.class);
    paramICameraEntrance.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      paramICameraEntrance.putExtra("main_tab_id", 6);
      paramICameraEntrance.putExtra("open_now_tab_fragment", true);
      paramICameraEntrance.putExtra("extra_from_share", true);
      paramICameraEntrance.setFlags(335544320);
      paramActivity.startActivity(paramICameraEntrance);
      paramActivity.overridePendingTransition(2130771998, 2130772000);
      return;
    }
    paramICameraEntrance.putExtra("main_tab_id", 1);
    paramICameraEntrance.setFlags(335544320);
    paramActivity.startActivity(paramICameraEntrance);
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqqapi://videostory/takevideo?from=aioGifCameraTail&widgetinfo=");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&cmode=singlegif");
    localIntent.setData(Uri.parse(localStringBuilder.toString()));
    JumpActivity.processIntent(localIntent);
    JumpActivity.handleIntentForQQBrowser(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil
 * JD-Core Version:    0.7.0.1
 */