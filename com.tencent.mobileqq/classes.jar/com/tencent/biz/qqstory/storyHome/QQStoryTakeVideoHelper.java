package com.tencent.biz.qqstory.storyHome;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.publish.GenerateVideoManifestSegment;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import java.io.File;

@TargetApi(14)
public class QQStoryTakeVideoHelper
{
  public int a;
  public long a;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
  public String a;
  private final boolean jdField_a_of_type_Boolean;
  public int b;
  private boolean b;
  public int c = 1;
  
  public QQStoryTakeVideoHelper(@NonNull Activity paramActivity, @NonNull RMVideoStateMgr paramRMVideoStateMgr, @NonNull Intent paramIntent)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = paramRMVideoStateMgr;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("extra_now_tab", StoryApi.a(2131099651).booleanValue());
    this.c = paramIntent.getIntExtra("extra_memories_from", 1);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("start_origin", -1);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("start_time", -1L);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("extra_donot_jump_story_home", false);
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("story_default_label");
    if ((paramIntent.getIntExtra("edit_video_type", 0) == 10002) && (this.jdField_a_of_type_Long > 0L)) {
      StoryReportor.b("take_video", "video_startup", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(this.jdField_b_of_type_Int) });
    }
    SLog.a("QQStoryTakeVideoHelper", "default label:%s", this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(PublishParam paramPublishParam, String paramString, int paramInt)
  {
    boolean bool2 = true;
    Intent localIntent;
    if (!this.jdField_b_of_type_Boolean)
    {
      if (((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Int == 3)) && ((!this.jdField_a_of_type_Boolean) || (this.c < 1000))) {
        break label235;
      }
      if (StoryDepends.a())
      {
        StoryTransitionActivity.a(this.jdField_a_of_type_AndroidAppActivity, DisplayFullScreenImageCode.class.getName(), null);
        this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
      }
    }
    else
    {
      localIntent = new Intent();
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.putExtra("totalPublishVideoCount", paramPublishParam.k);
      if (paramPublishParam.h != 1) {
        break label287;
      }
      bool1 = true;
      label111:
      localIntent.putExtra("isTakePhoto", bool1);
      if (paramPublishParam.l != 1) {
        break label293;
      }
    }
    label287:
    label293:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localIntent.putExtra("isLocalPublish", bool1);
      if (!(this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)) {
        break label299;
      }
      return;
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      break;
      label235:
      if (paramInt == 15)
      {
        StoryTransitionActivity.a(this.jdField_a_of_type_AndroidAppActivity);
        break;
      }
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQStoryMainActivity.class);
      localIntent.putExtra("new_video_extra_info", paramString);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      break;
      bool1 = false;
      break label111;
    }
    label299:
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
  }
  
  private boolean a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString))
    {
      SLog.e("QQStoryTakeVideoHelper", "check manifest's existance error. directory is null.");
      return false;
    }
    return FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + File.separator + "manifest.ini");
  }
  
  public String a()
  {
    return (String)((StoryConfigManager)SuperManager.a(10)).b("StorySvc.get_photography_guide.word", HardCodeUtil.a(2131711026));
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_Int == 3) && (this.c != 2)) {
      QQStoryMemoriesActivity.a(this.jdField_a_of_type_AndroidAppActivity, this.c, QQStoryContext.a().b(), false);
    }
  }
  
  public void a(Intent paramIntent, @NonNull ImageView paramImageView)
  {
    SLog.b("QQStoryTakeVideoHelper", "preview confirm");
    PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
    if (localPublishParam == null) {
      return;
    }
    int i = paramIntent.getIntExtra("entrance_type", 99);
    String str = localPublishParam.c;
    Object localObject;
    if (paramImageView != null)
    {
      localObject = null;
      paramIntent = localObject;
      if (new File(str).exists())
      {
        paramIntent = new BitmapFactory.Options();
        paramIntent.inPreferredConfig = Bitmap.Config.RGB_565;
        paramIntent.inSampleSize = 2;
      }
    }
    try
    {
      paramIntent = BitmapFactory.decodeFile(str);
      if (paramIntent != null) {
        paramImageView.setImageBitmap(paramIntent);
      }
      for (;;)
      {
        paramImageView.setVisibility(0);
        if (localPublishParam.h != 1) {
          break;
        }
        SLog.b("QQStoryTakeVideoHelper", "preview confirm takephoto ");
        a(localPublishParam, str, i);
        return;
        paramImageView.setImageDrawable(new ColorDrawable(-16777216));
      }
      if (!a())
      {
        SLog.d("QQStoryTakeVideoHelper", "manifest file doesn't exist. generate again before publishing.");
        a(new QQStoryTakeVideoHelper.1(this, localPublishParam, str, i));
        return;
      }
      SLog.c("QQStoryTakeVideoHelper", "manifest file already exists. start publishing.");
      a(localPublishParam, str, i);
      return;
    }
    catch (OutOfMemoryError paramIntent)
    {
      for (;;)
      {
        paramIntent = localObject;
      }
    }
  }
  
  public void a(QQStoryTakeVideoHelper.GenerateManifestCallback paramGenerateManifestCallback)
  {
    this.jdField_a_of_type_Int = 1;
    Stream.of(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr).map(new ThreadOffFunction("QQStoryTakeVideoHelper", 2)).map(new GenerateVideoManifestSegment()).subscribe(new QQStoryTakeVideoHelper.2(this, paramGenerateManifestCallback));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper
 * JD-Core Version:    0.7.0.1
 */