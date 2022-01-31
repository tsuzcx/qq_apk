package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.takevideo2.StoryPublishParams;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements EditVideoUi
{
  public EditVideoPartManager a;
  
  private void b()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    boolean bool1 = ((Boolean)localStoryConfigManager.b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
    boolean bool2 = ((Boolean)localStoryConfigManager.b("boolean_enable_flow_decode", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = ((Boolean)localStoryConfigManager.b("boolean_use_flow_decode_first", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "check reverse play mode. enableIFrameRevert = " + bool1 + ", enableFlowRevert = " + bool2 + ", useFlowDecodeFirst = " + bool3);
    if (bool3)
    {
      if (bool2)
      {
        com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_a_of_type_Boolean = true;
        com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_b_of_type_Boolean = true;
        return;
      }
      if (bool1)
      {
        com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_a_of_type_Boolean = true;
        com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_b_of_type_Boolean = false;
        return;
      }
      com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_a_of_type_Boolean = false;
      com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_b_of_type_Boolean = false;
      return;
    }
    if (bool1)
    {
      com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_a_of_type_Boolean = true;
      com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_b_of_type_Boolean = false;
      return;
    }
    if (bool2)
    {
      com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_a_of_type_Boolean = true;
      com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_b_of_type_Boolean = true;
      return;
    }
    com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_a_of_type_Boolean = false;
    com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Constants.jdField_b_of_type_Boolean = false;
  }
  
  private void c()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    SLog.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 51200L)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((TrimmableManager)SuperManager.a(26)).a(2);
      return;
    }
    ((TrimmableManager)SuperManager.a(26)).a(0);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  public Intent a(GenerateContext paramGenerateContext)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))
    {
      Intent localIntent = getIntent();
      localObject1 = localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      ArrayList localArrayList = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      Object localObject2;
      if ((paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Boolean) || (!paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_a_of_type_Boolean)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
          localIntent.putExtra("need_combine_gif", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c);
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString)) {
          break label506;
        }
        localIntent.putExtra("orign_path", localEditLocalGifSource.a());
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        localIntent.putExtra("gif_delay_time", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Int);
        localIntent.putExtra("gif_has_antishake", this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d);
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource)) {
          localIntent.putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        localArrayList.add(localObject2);
        ImageUtil.a(this, (String)localObject2);
        localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
        localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        localIntent.addFlags(603979776);
        localIntent.putExtra("PhotoConst.SEND_FLAG", true);
        return localIntent;
        if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
          if ((localEditLocalGifSource.b != null) && (localEditLocalGifSource.b.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.b.get(0);
          }
        }
        for (;;)
        {
          if (!paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.c) {
            localIntent.putExtra("use_orign", true);
          }
          localIntent.putExtra("need_combine_gif", true);
          break;
          localObject1 = "";
          continue;
          if ((localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList != null) && (localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
            localObject1 = (String)localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList.get(0);
          } else {
            localObject1 = "";
          }
        }
        localObject2 = paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_JavaLangString;
        localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        localIntent.putExtra("need_combine_gif", true);
      }
      label506:
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.b);
      }
      for (;;)
      {
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        localIntent.putExtra("gif_delay_time", paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGeneratePicArgs.jdField_b_of_type_Int);
        localIntent.putExtra("gif_has_antishake", this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d);
        break;
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramGenerateContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
    return localObject1;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public void a()
  {
    if (this.a == null) {
      this.a = new EditVideoPartManager();
    }
  }
  
  public void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3)
  {
    int i = getIntent().getIntExtra("entrance_type", 99);
    Intent localIntent = paramIntent;
    if (i == 15)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("entrance_type", i);
    }
    setResult(paramInt1, localIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
    c();
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    if ((Build.MODEL.equals("HM NOTE 1TD")) && (Build.VERSION.SDK_INT < 18))
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "disable show loading dialog");
      return;
    }
    super.a(paramCharSequence, paramBoolean, paramLong);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i;
    if ((paramInt1 == 10004) || (paramInt1 == 10010))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "quick shoot onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        SessionInfo localSessionInfo = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (localSessionInfo != null) {
          getIntent().putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo);
        }
        if (paramInt1 != 10010) {
          break label218;
        }
        getIntent().putExtra("forward_source_from_pre_guide", true);
        int j = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
        i = j;
        if (j == 0)
        {
          i = j;
          if (paramInt1 == 10010) {
            i = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
          }
        }
        if (i != 1002) {
          break label233;
        }
        a(paramInt2, paramIntent, 2131034158, 0);
      }
    }
    for (;;)
    {
      SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
      this.a.a(paramInt1, paramInt2, paramIntent);
      return;
      label218:
      getIntent().putExtra("forward_source_from_shoot_quick", true);
      break;
      label233:
      if (i == 1003)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int = 1;
        this.a.a();
      }
      else
      {
        a(paramInt2, paramIntent, 2131034158, 0);
        continue;
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void doOnBackPressed()
  {
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.a.b()) {
      super.doOnBackPressed();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    b();
    VideoModule.init(this);
    SLog.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
    a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    GloableValue.a(QQStoryContext.a().a(), this);
    EditPicConstants.a(QQStoryContext.a().a(), this);
    try
    {
      PtvFilterSoLoad.a(VideoEnvironment.a(), false);
      if (VideoEnvironment.a("AVCodec", getApplicationContext()) != 0)
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed");
        finish();
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed", paramBundle);
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("uintype", -1);
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent().getBooleanExtra("extra_has_antishake", false)) && (localEditVideoParams != null) && ((localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)))
    {
      localObject = (EditLocalGifSource)localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      ((EditLocalGifSource)localObject).b = getIntent().getStringArrayListExtra("extra_antishake_gif_path_list");
      if ((((EditLocalGifSource)localObject).b != null) && (((EditLocalGifSource)localObject).b.size() > 1)) {
        ((EditLocalGifSource)localObject).jdField_a_of_type_Boolean = true;
      }
    }
    if ((localEditVideoParams != null) && ((localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource))) {
      ((EditLocalGifSource)localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int = getIntent().getIntExtra("extra_checked_similarity_ok_to_antishake", 0);
    }
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (Object localObject = localEditVideoParams.a(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      QQToast.a(this, "视频参数错误: " + (String)localObject, 0).a();
      finish();
      return true;
    }
    String str2 = getIntent().getStringExtra("op_department");
    String str3 = getIntent().getStringExtra("op_type");
    String str1 = str3;
    localObject = str2;
    if (localEditVideoParams != null)
    {
      str1 = str3;
      localObject = str2;
      if (localEditVideoParams.jdField_a_of_type_Int == 1)
      {
        localObject = "grp_story";
        str1 = "video_edit";
      }
    }
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str1 });
    try
    {
      VideoSourceHelper.nativeSetPlayStepFrameCount(1);
      VideoSourceHelper.nativeSetPlayGapFrameCount(1);
      getWindow().addFlags(1024);
      setContentViewC(2130970886);
      a(paramBundle);
      if (localEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
      {
        localEditVideoParams.jdField_a_of_type_AndroidOsBundle.putInt("uintype", i);
        StoryPublishParams.a("Q.qqstory.publish.edit.EditVideoActivity", localEditVideoParams.jdField_a_of_type_AndroidOsBundle);
        this.a.a(this, localEditVideoParams);
        this.a.j();
        FileUtils.a(QQStoryConstant.c);
        VideoEditReport.jdField_a_of_type_JavaLangString = (String)localObject;
        VideoEditReport.jdField_b_of_type_JavaLangString = str1;
        if ((!VideoEditReport.a()) || (VideoEnvironment.b() < 21)) {}
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          VideoSourceHelper.nativeSetMaxPhotoFrameCount(3);
          SLog.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity set min frame!");
          VideoEditReport.a("0X80076B5");
          if (localEditVideoParams.jdField_a_of_type_Int == 2)
          {
            if (i != 1) {
              break;
            }
            paramBundle = "3";
            StoryReportor.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1", paramBundle });
          }
          LpReportInfo_pf00064.allReport(628, 1);
          SLog.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
          if (localEditVideoParams.jdField_a_of_type_Int == 10) {
            ReportController.b(null, "dc00899", "Grp_tribe", "", "video_edit", "exp_edit", 0, 0, "", "", "", "");
          }
          paramBundle = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
          if (paramBundle.a() == null) {
            paramBundle.b();
          }
          c();
          if ((localEditVideoParams.jdField_a_of_type_Int == 10) || (localEditVideoParams.jdField_a_of_type_Int == 12)) {
            ((RelativeLayout)findViewById(2131364430)).setBackgroundColor(-16777216);
          }
          return true;
          localThrowable = localThrowable;
          QLog.w("Q.qqstory.publish.edit.EditVideoActivity", 1, "VideoSourceHelper error:", localThrowable);
        }
        SLog.e("Q.qqstory.publish.edit.EditVideoActivity", "video editVideoParams.mExtra is null!!");
      }
      catch (UnsatisfiedLinkError paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "nativeSetMaxPhotoFrameCount:exp=", paramBundle);
            continue;
            if (i == 3000) {
              paramBundle = "2";
            } else {
              paramBundle = "1";
            }
          }
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.a.o();
    VideoEditReport.jdField_a_of_type_JavaLangString = "";
    VideoEditReport.jdField_b_of_type_JavaLangString = "";
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.a.m();
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnRestoreInstanceState");
    this.a.a(paramBundle);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnResume");
    this.a.l();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnSaveInstanceState");
    this.a.b(paramBundle);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStart");
    this.a.k();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    SLog.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.a.n();
  }
  
  protected void g()
  {
    super.g();
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "onOutOfMemory");
    c();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    SLog.d("Q.qqstory.publish.edit.EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    c();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */