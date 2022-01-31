package com.tencent.biz.qqstory.takevideo2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.AndroidRuntimeException;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.QIMStoryEffectCameraCaptureUnit;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import dov.com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import mqq.app.AppRuntime;
import olf;

public class StoryPublishLauncher
{
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
  
  private boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!CaptureUtil.a())
    {
      DialogUtil.a(paramContext, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131432999, new olf(this)).show();
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    return ShortVideoGuideUtil.e(a());
  }
  
  public static boolean c()
  {
    return PtvFilterSoLoad.a(a(), BaseApplicationImpl.getContext());
  }
  
  public Intent a(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = new Intent(paramActivity, PhotoListActivity.class);
    paramActivity.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    paramActivity.putExtra("from_qqstory", true);
    paramActivity.putExtra("ALBUM_NAME", "最近照片");
    paramActivity.putExtra("ALBUM_ID", "$RecentAlbumId");
    paramActivity.putExtra("video_refer", "qqstory");
    paramActivity.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    paramActivity.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    paramActivity.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramActivity.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    paramActivity.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramActivity.putExtra("bundle_extra", paramBundle);
    return paramActivity;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (a().c()) {
      QQToast.a(paramActivity, 0, 2131437362, 0).a();
    }
    while (a(paramActivity)) {
      return;
    }
    boolean bool1 = b();
    boolean bool2 = CaptureUtil.a();
    SLog.a("story.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, supportMediaCodec=%s, filterOk=%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(c()));
    ((StoryConfigManager)SuperManager.a(10)).c();
    if (bool2)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      a(localBundle);
      if (bool1)
      {
        QIMCameraCaptureActivity.a(paramActivity, QIMStoryEffectCameraCaptureUnit.class.getName(), localBundle, paramInt);
        return;
      }
      CaptureQmcfSoDownloadActivity.a(paramActivity, QIMStoryEffectCameraCaptureUnit.class.getName(), localBundle, paramInt, true);
      return;
    }
    throw new AndroidRuntimeException("getCaptureIntent supportMediaCodec = false");
  }
  
  public void a(Context paramContext, Bundle paramBundle)
  {
    if (a().c()) {
      QQToast.a(paramContext, 0, 2131437362, 0).a();
    }
    while (a(paramContext)) {
      return;
    }
    boolean bool1 = b();
    boolean bool2 = CaptureUtil.a();
    SLog.a("story.publish.StoryPublishLauncher", "launch, videoSoUsable=%s, supportMediaCodec=%s, filterOK=%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(c()));
    ((StoryConfigManager)SuperManager.a(10)).c();
    if (bool2)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      a(localBundle);
      if (bool1)
      {
        QIMCameraCaptureActivity.a(paramContext, QIMStoryEffectCameraCaptureUnit.class.getName(), localBundle);
        return;
      }
      CaptureQmcfSoDownloadActivity.a(paramContext, QIMStoryEffectCameraCaptureUnit.class.getName(), localBundle, true);
      return;
    }
    throw new AndroidRuntimeException("getCaptureIntent supportMediaCodec = false");
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("entrance_type")) {
      SLog.b("story.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
    }
    paramBundle.putInt("edit_video_type", 10002);
    if (!paramBundle.containsKey("ability_flag")) {
      paramBundle.putInt("ability_flag", 1);
    }
    if (!paramBundle.containsKey("enable_multi_fragment"))
    {
      paramBundle.putBoolean("enable_multi_fragment", true);
      if (!paramBundle.containsKey("capture_max_duration")) {
        paramBundle.putLong("capture_max_duration", 60000L);
      }
    }
    if (!paramBundle.containsKey("capture_max_duration")) {
      paramBundle.putLong("capture_max_duration", 10000L);
    }
  }
  
  public void a(Fragment paramFragment, Bundle paramBundle, int paramInt)
  {
    SLog.b("story.publish.StoryPublishLauncher", "launchAlbumThenEditThenPublishForResult");
    StoryPublishParams.a("story.publish.StoryPublishLauncher", paramBundle);
    if (a(BaseApplicationImpl.getContext())) {
      return;
    }
    boolean bool = CaptureUtil.a();
    SLog.a("story.publish.StoryPublishLauncher", "videoSoUsable=%s, supportMediaCodec=%s", Boolean.valueOf(true), Boolean.valueOf(bool));
    if (bool)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramFragment.startActivityForResult(a(paramFragment.getActivity(), localBundle), paramInt);
      return;
    }
    throw new AndroidRuntimeException("getCaptureIntent supportMediaCodec = false");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    SLog.b("story.publish.StoryPublishLauncher", "launchAlbumThenEditThenPublishForResult");
    StoryPublishParams.a("story.publish.StoryPublishLauncher", paramBundle);
    if (a(paramActivity)) {
      return;
    }
    boolean bool1 = b();
    boolean bool2 = CaptureUtil.a();
    SLog.a("story.publish.StoryPublishLauncher", "videoSoUsable=%s, supportMediaCodec=%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2));
    if (bool2)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      if (bool1)
      {
        paramActivity.startActivityForResult(a(paramActivity, localBundle), paramInt);
        return;
      }
      a(paramActivity, localBundle, paramInt);
      return;
    }
    throw new AndroidRuntimeException("getCaptureIntent supportMediaCodec = false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher
 * JD-Core Version:    0.7.0.1
 */