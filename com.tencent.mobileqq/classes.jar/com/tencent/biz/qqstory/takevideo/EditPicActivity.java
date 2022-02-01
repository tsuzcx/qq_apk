package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sveffects.SvEffectSdkInitor;
import dov.com.qq.im.ae.AEKitForQQ;
import dov.com.qq.im.ae.download.AEResUtil;
import java.io.File;
import java.util.ArrayList;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements EditVideoUi
{
  protected EditVideoPartManager a;
  PtvTemplateManager.DoodleInfoLoadObserver a;
  
  public EditPicActivity()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager = new EditPicPartManager();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver = new EditPicActivity.1(this);
  }
  
  public static Intent a(Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      int i = paramIntent.getFlags();
      if ((0x80000 & i) > 0) {
        paramIntent.setFlags(i & 0xFFF7FFFF);
      }
    }
    return paramIntent;
  }
  
  private Intent a(Intent paramIntent, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return paramIntent;
    case 104: 
      paramString2 = ForwardRecentActivity.class.getName();
      paramIntent.putExtra("forward_type", 1);
      paramIntent.putExtra("forward_ability_entrence_show_in_share", true);
      paramIntent.putExtra("k_qzone", true);
      paramIntent.putExtra("k_qqstory", true);
      paramIntent.putExtra("k_smartdevice", false);
      paramIntent.putExtra("k_favorites", false);
      paramIntent.putExtra("k_phonecontacts", false);
      paramIntent.putExtra("forward_filepath", paramString1);
      paramIntent.putExtra("forward_extra", paramString1);
      paramIntent.putExtra("forward_thumb", paramString1);
      paramIntent.putExtra("forward_urldrawable", true);
      paramIntent.putExtra("forward_urldrawable_big_url", paramString1);
      paramIntent.putExtra("forward_urldrawable_thumb_url", paramString1);
      paramIntent.putExtra("forward_photo_shortvideo_is_edited", true);
      paramIntent.putExtra("forward_source_from_pre_guide", true);
      paramIntent.setClassName("com.tencent.mobileqq", paramString2);
      return paramIntent;
    }
    paramIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
    return paramIntent;
  }
  
  public Context a()
  {
    return this;
  }
  
  public Intent a(GenerateContext paramGenerateContext)
  {
    Object localObject2 = getIntent();
    String str1 = ((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    String str2 = ((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME");
    ((Intent)localObject2).setClassName(str2, str1);
    ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
    ((Intent)localObject2).putExtra("PhotoConst.HAS_CROP", paramGenerateContext.a.d);
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramGenerateContext.a.jdField_b_of_type_Boolean) || (!paramGenerateContext.a.jdField_a_of_type_Boolean))
    {
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      localArrayList.add(localObject1);
      ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject2).putExtra("PhotoConst.SEND_FLAG", true);
      ((Intent)localObject2).putExtra("video_sync_to_story", paramGenerateContext.d);
      ((Intent)localObject2).addFlags(603979776);
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject2).getFlags() + ",data = " + ((Intent)localObject2).getExtras());
      }
      localObject1 = a((Intent)localObject2, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (String)localObject1, str1, str2);
      paramGenerateContext = (GenerateContext)localObject1;
      if (str1.contains("ForwardRecentActivity")) {
        paramGenerateContext = a((Intent)localObject1);
      }
      localObject1 = paramGenerateContext.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject2 = paramGenerateContext.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      if ((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject1)) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str1)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject2))) {
        break label412;
      }
      paramGenerateContext.setClassName(paramGenerateContext.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
    }
    for (;;)
    {
      paramGenerateContext.putExtra("open_chatfragment_fromphoto", true);
      return paramGenerateContext;
      localObject1 = paramGenerateContext.a.jdField_b_of_type_JavaLangString;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        FileUtils.e(paramGenerateContext.a.jdField_a_of_type_JavaLangString);
        new File(paramGenerateContext.a.jdField_a_of_type_JavaLangString);
        ImageUtil.a(this, paramGenerateContext.a.jdField_a_of_type_JavaLangString);
      }
      ((Intent)localObject2).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label412:
      if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str1)) {
        paramGenerateContext.setClassName("com.tencent.mobileqq", (String)localObject1);
      }
    }
  }
  
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public void a(int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    setResult(paramInt1, paramIntent);
    finish();
    overridePendingTransition(paramInt3, paramInt2);
  }
  
  protected void a(Bundle paramBundle) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    SLog.c("EditPicActivity", "doOnActivityResult");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 666)
    {
      if (paramInt2 == -1)
      {
        localObject2 = getIntent();
        ((Intent)localObject2).setClass(this, EditPicActivity.class);
        if (((Intent)localObject2).getIntExtra("camera_type", -1) == 103) {}
        for (paramIntent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();; paramIntent = ((Intent)localObject2).getStringExtra("image_path"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity", 2, "reset2Camera end shoot " + this + " new path " + paramIntent);
          }
          localObject1 = paramIntent;
          if (TextUtils.isEmpty(paramIntent))
          {
            localObject1 = PreferenceManager.getDefaultSharedPreferences(this).getString("edit_pic_new_path", "");
            QLog.d("EditPicActivity", 1, " be killed. read sp " + (String)localObject1);
          }
          if (FileUtils.a((String)localObject1)) {
            break;
          }
          QLog.i("EditPicActivity", 1, "recamera file not exist " + (String)localObject1);
          QQToast.a(this, HardCodeUtil.a(2131703702), 0).a();
          finish();
          return;
        }
        paramIntent = new EditVideoParams(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, new EditTakePhotoSource((String)localObject1, 2, 0, 0), EditVideoParams.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()));
        ((Intent)localObject2).putExtra(EditVideoParams.class.getName(), paramIntent);
        finish();
        startActivity((Intent)localObject2);
        return;
      }
      SLog.c("EditPicActivity", "recamera cancel, finish");
      finish();
      return;
    }
    if (paramInt1 == 1000) {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
        int i = paramIntent.getIntExtra("forward_to_someplace_from_pre_guide", 0);
        if (paramInt1 != 0) {
          break label529;
        }
        paramInt1 = i;
      }
    }
    label529:
    for (;;)
    {
      if (paramInt1 == 1003)
      {
        localObject2 = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        localObject1 = null;
        paramIntent = (Intent)localObject1;
        if (localObject2 != null)
        {
          paramIntent = (Intent)localObject1;
          if (((ArrayList)localObject2).size() > 0) {
            paramIntent = (String)((ArrayList)localObject2).get(0);
          }
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource = new EditTakePhotoSource(paramIntent, 2, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b());
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.g();
        return;
      }
      a(paramInt2, paramIntent, 2130772034, 0);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 != 1001) {
        break;
      }
      a(paramInt2, paramIntent, 2130772034, 0);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    SLog.c("EditPicActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.b()) {
      super.doOnBackPressed();
    }
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    SvEffectSdkInitor.jdField_a_of_type_Boolean = false;
    SvEffectSdkInitor.a();
    AEKitForQQ.a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    EditPicConstants.a(QQStoryContext.a().a(), this);
    int i = getIntent().getIntExtra("uintype", -1);
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    NewFlowCameraReporter.a("finish jump activity", NewFlowCameraReporter.a(getIntent()));
    SLog.d("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if ((localEditVideoParams == null) || (TextUtils.isEmpty(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a())))
    {
      QQToast.a(this, HardCodeUtil.a(2131703699), 0).a();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    }
    if (!FileUtils.a(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()))
    {
      QQToast.a(this, HardCodeUtil.a(2131703698), 0).a();
      finish();
      return true;
    }
    int j = getIntent().getIntExtra("editpic_cameratype", -1);
    if (j == 1)
    {
      NewFlowCameraReporter.h();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    try
    {
      for (;;)
      {
        AEResUtil.e();
        if (VideoEnvironment.loadAVCodecSo() != 0) {
          SLog.e("EditPicActivity", "load AVCodec so failed");
        }
        getWindow().addFlags(1024);
        setContentViewC(2131559688);
        a(paramBundle);
        if (localEditVideoParams.jdField_a_of_type_AndroidOsBundle == null) {
          break;
        }
        localEditVideoParams.jdField_a_of_type_AndroidOsBundle.putInt("uintype", i);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(this, localEditVideoParams);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("FILTER_STRING");
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_Int = getIntent().getIntExtra("FILTER_MAXSIDE", 640);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.c = getIntent().getStringExtra("FILTER_LOADING_PATH");
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart != null))
        {
          long l = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
          paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage;
          if (l <= 0L) {
            break label665;
          }
          bool = true;
          paramBundle.jdField_a_of_type_Boolean = bool;
          paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart;
          if (l <= 0L) {
            break label671;
          }
          bool = true;
          paramBundle.d = bool;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.i();
        PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver, false);
        if (localEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) {
          VideoEditReport.a(localEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("pic_entrance_type", 0));
        }
        GeneratePicArgs.a(null);
        if (localEditVideoParams.jdField_a_of_type_Int == 2)
        {
          if (i != 1) {
            break label677;
          }
          paramBundle = "3";
          StoryReportor.a("aio_shoot", "exp_edit", 0, 0, new String[] { "2", paramBundle });
        }
        StatisticCollector.report("exposure_old_editPic");
        return true;
        if (j == 2) {
          NewFlowCameraReporter.i();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.c("EditPicActivity", "load so failed", localException);
        continue;
        SLog.e("EditPicActivity", "pic editVideoParams.mExtra is null!!");
        continue;
        label665:
        boolean bool = false;
        continue;
        label671:
        bool = false;
        continue;
        label677:
        if (i == 3000) {
          paramBundle = "2";
        } else {
          paramBundle = "1";
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.b("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.n();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    SLog.c("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.l();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    SLog.c("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.k();
    NewFlowCameraReporter.a("resume activity");
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    SLog.c("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.j();
    VideoEditReport.jdField_a_of_type_JavaLangString = VideoEditReport.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    VideoEditReport.jdField_b_of_type_JavaLangString = "pic_edit";
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    SLog.c("EditPicActivity", "doOnStop");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.m();
    VideoEditReport.jdField_a_of_type_JavaLangString = "";
    VideoEditReport.jdField_b_of_type_JavaLangString = "";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */