package com.tencent.biz.qqstory.takevideo;

import Override;
import alrr;
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
import anvx;
import bcwr;
import bheg;
import bmwb;
import bnky;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sveffects.SvEffectSdkInitor;
import java.io.File;
import java.util.ArrayList;
import ykq;
import ykv;
import ykw;
import ylr;
import yls;
import ylu;
import ynw;
import ypg;
import yya;
import yye;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements ypg
{
  bcwr a;
  public ynw a;
  
  public EditPicActivity()
  {
    this.jdField_a_of_type_Ynw = new ylu();
    this.jdField_a_of_type_Bcwr = new ylr(this);
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
  
  public Intent a(yya paramyya)
  {
    Object localObject2 = getIntent();
    String str1 = ((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    String str2 = ((Intent)localObject2).getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME");
    ((Intent)localObject2).setClassName(str2, str1);
    ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
    ((Intent)localObject2).putExtra("PhotoConst.HAS_CROP", paramyya.a.d);
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramyya.a.jdField_b_of_type_Boolean) || (!paramyya.a.jdField_a_of_type_Boolean))
    {
      QLog.d("EditPicActivity", 1, "send sourcePath");
      localObject1 = this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath();
      localArrayList.add(localObject1);
      ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject2).putExtra("PhotoConst.SEND_FLAG", true);
      ((Intent)localObject2).putExtra("video_sync_to_story", paramyya.d);
      ((Intent)localObject2).addFlags(603979776);
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject2).getFlags() + ",data = " + ((Intent)localObject2).getExtras());
      }
      localObject1 = a((Intent)localObject2, this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId(), (String)localObject1, str1, str2);
      paramyya = (yya)localObject1;
      if (str1.contains("ForwardRecentActivity")) {
        paramyya = a((Intent)localObject1);
      }
      localObject1 = paramyya.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject2 = paramyya.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      if ((!"com.tencent.mobileqq.activity.SplashActivity".equals(localObject1)) || (!"com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str1)) || (!"com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(localObject2))) {
        break label412;
      }
      paramyya.setClassName(paramyya.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
    }
    for (;;)
    {
      paramyya.putExtra("open_chatfragment_fromphoto", true);
      return paramyya;
      localObject1 = paramyya.a.jdField_b_of_type_JavaLangString;
      if (getIntent().getIntExtra("camera_type", -1) != -1)
      {
        FileUtils.deleteFile(paramyya.a.jdField_a_of_type_JavaLangString);
        new File(paramyya.a.jdField_a_of_type_JavaLangString);
        bheg.a(this, paramyya.a.jdField_a_of_type_JavaLangString);
      }
      ((Intent)localObject2).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label412:
      if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str1)) {
        paramyya.setClassName("com.tencent.mobileqq", (String)localObject1);
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
    ykq.c("EditPicActivity", "doOnActivityResult");
    this.jdField_a_of_type_Ynw.a(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    Object localObject1;
    if (paramInt1 == 666)
    {
      if (paramInt2 == -1)
      {
        localObject2 = getIntent();
        ((Intent)localObject2).setClass(this, EditPicActivity.class);
        if (((Intent)localObject2).getIntExtra("camera_type", -1) == 103) {}
        for (paramIntent = this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath();; paramIntent = ((Intent)localObject2).getStringExtra("image_path"))
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
          if (FileUtils.fileExists((String)localObject1)) {
            break;
          }
          QLog.i("EditPicActivity", 1, "recamera file not exist " + (String)localObject1);
          QQToast.a(this, anvx.a(2131703154), 0).a();
          finish();
          return;
        }
        paramIntent = new EditVideoParams(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId, this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEnableMasks, new EditTakePhotoSource((String)localObject1, 2, 0, 0), EditVideoParams.setBundleForBusiness(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId()));
        ((Intent)localObject2).putExtra(EditVideoParams.class.getName(), paramIntent);
        finish();
        startActivity((Intent)localObject2);
        return;
      }
      ykq.c("EditPicActivity", "recamera cancel, finish");
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
        this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId = 1;
        this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource = new EditTakePhotoSource(paramIntent, 2, this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getWidth(), this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getHeight());
        this.jdField_a_of_type_Ynw.g();
        return;
      }
      a(paramInt2, paramIntent, 2130772030, 0);
      return;
      this.jdField_a_of_type_Ynw.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 != 1001) {
        break;
      }
      a(paramInt2, paramIntent, 2130772030, 0);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    ykq.c("EditPicActivity", "doOnBackPressed");
    if (!this.jdField_a_of_type_Ynw.b()) {
      super.doOnBackPressed();
    }
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    SvEffectSdkInitor.isDovCapture = false;
    SvEffectSdkInitor.init();
    bmwb.a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    yls.a(QQStoryContext.a().a(), this);
    int i = getIntent().getIntExtra("uintype", -1);
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    alrr.a("finish jump activity", alrr.a(getIntent()));
    ykq.d("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if ((localEditVideoParams == null) || (TextUtils.isEmpty(localEditVideoParams.mEditSource.getSourcePath())))
    {
      QQToast.a(this, anvx.a(2131703151), 0).a();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + localEditVideoParams.mEditSource.getSourcePath());
    }
    if (!FileUtils.fileExists(localEditVideoParams.mEditSource.getSourcePath()))
    {
      QQToast.a(this, anvx.a(2131703150), 0).a();
      finish();
      return true;
    }
    int j = getIntent().getIntExtra("editpic_cameratype", -1);
    if (j == 1)
    {
      alrr.h();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    try
    {
      for (;;)
      {
        bnky.c();
        if (VideoEnvironment.loadAVCodecSo("AVCodec", super.getApplicationContext()) != 0) {
          ykq.e("EditPicActivity", "load AVCodec so failed");
        }
        getWindow().addFlags(1024);
        setContentViewC(2131559612);
        a(paramBundle);
        if (localEditVideoParams.mExtra == null) {
          break;
        }
        localEditVideoParams.mExtra.putInt("uintype", i);
        this.jdField_a_of_type_Ynw.a(this, localEditVideoParams);
        if (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
        {
          this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("FILTER_STRING");
          this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.a = getIntent().getIntExtra("FILTER_MAXSIDE", 640);
          this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.c = getIntent().getStringExtra("FILTER_LOADING_PATH");
        }
        if ((this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) && (this.jdField_a_of_type_Ynw.jdField_a_of_type_Ylt != null))
        {
          long l = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
          paramBundle = this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage;
          if (l <= 0L) {
            break label672;
          }
          bool = true;
          paramBundle.jdField_a_of_type_Boolean = bool;
          paramBundle = this.jdField_a_of_type_Ynw.jdField_a_of_type_Ylt;
          if (l <= 0L) {
            break label678;
          }
          bool = true;
          paramBundle.d = bool;
        }
        this.jdField_a_of_type_Ynw.i();
        PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Bcwr, false);
        if (localEditVideoParams.mExtra != null) {
          ykw.a(localEditVideoParams.mExtra.getInt("pic_entrance_type", 0));
        }
        yye.a(null);
        if (localEditVideoParams.mBusinessId == 2)
        {
          if (i != 1) {
            break label684;
          }
          paramBundle = "3";
          ykv.a("aio_shoot", "exp_edit", 0, 0, new String[] { "2", paramBundle });
        }
        StatisticCollector.report("exposure_old_editPic");
        return true;
        if (j == 2) {
          alrr.i();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ykq.c("EditPicActivity", "load so failed", localException);
        continue;
        ykq.e("EditPicActivity", "pic editVideoParams.mExtra is null!!");
        continue;
        label672:
        boolean bool = false;
        continue;
        label678:
        bool = false;
        continue;
        label684:
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
    ykq.b("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_Ynw.n();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ykq.c("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_Ynw.l();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ykq.c("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_Ynw.k();
    alrr.a("resume activity");
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ykq.c("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_Ynw.j();
    ykw.jdField_a_of_type_JavaLangString = ykw.a(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId);
    ykw.jdField_b_of_type_JavaLangString = "pic_edit";
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ykq.c("EditPicActivity", "doOnStop");
    this.jdField_a_of_type_Ynw.m();
    ykw.jdField_a_of_type_JavaLangString = "";
    ykw.jdField_b_of_type_JavaLangString = "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */