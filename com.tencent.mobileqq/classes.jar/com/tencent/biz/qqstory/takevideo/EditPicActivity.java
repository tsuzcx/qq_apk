package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.DoodleInfoLoadObserver;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.VideoModule;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import obl;

public class EditPicActivity
  extends QQStoryBaseActivity
  implements EditVideoUi
{
  public EditVideoPartManager a;
  PtvTemplateManager.DoodleInfoLoadObserver a;
  
  public EditPicActivity()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager = new EditPicPartManager();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver = new obl(this);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt, 99);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, 99, 0, false, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, 99, 0, false, null);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, HashMap paramHashMap)
  {
    return a(paramActivity, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramInt1, 99, 0, false, paramHashMap);
  }
  
  public static Intent a(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean6, HashMap paramHashMap)
  {
    Intent localIntent = new Intent(paramActivity.getIntent());
    localIntent.setClass(paramActivity, ArtFilterBridgeActivity.class);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    if ((paramActivity instanceof SplashActivity)) {
      localIntent.putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
    }
    int j = 0;
    if (paramBoolean1) {
      j = 1;
    }
    int i = j;
    if (paramBoolean2) {
      i = j | 0x4;
    }
    j = i;
    if (paramBoolean3) {
      j = i | 0x8;
    }
    i = j;
    if (paramBoolean4) {
      i = j | 0x2;
    }
    j = i | 0x400;
    i = j;
    if (paramInt1 == 2) {
      i = j | 0x40000;
    }
    localIntent.putExtra("EDIT_BUSI", paramInt1);
    localIntent.putExtra("entrance_type", paramInt2);
    localIntent.putExtra("pic_entrance_type", paramInt3);
    localIntent.putExtra("TEMP_PARAM", i);
    localIntent.putExtra("PATH", paramString);
    localIntent.putExtra("USE_FILTER", paramBoolean5);
    localIntent.putExtra("go_publish_activity", paramBoolean6);
    if (paramHashMap != null) {
      localIntent.putExtra("user_params", paramHashMap);
    }
    localIntent.removeExtra("camera_type");
    if (paramActivity.getClass().getName().contains("ForwardRecentActivity")) {
      return a(localIntent);
    }
    return localIntent;
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
    case 101: 
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
      if (paramInt == 104) {
        paramIntent.putExtra("forward_source_from_pre_guide", true);
      }
      for (;;)
      {
        paramIntent.setClassName("com.tencent.mobileqq", paramString2);
        return paramIntent;
        paramIntent.putExtra("forward_source_from_shoot_quick", true);
      }
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
      paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      localArrayList.add(paramGenerateContext);
      ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)localArrayList.get(0));
      ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      ((Intent)localObject2).putExtra("PhotoConst.SEND_FLAG", true);
      ((Intent)localObject2).addFlags(603979776);
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity", 2, "sendPhotoForPhotoPlus , activity = " + this + ",flag = " + ((Intent)localObject2).getFlags() + ",data = " + ((Intent)localObject2).getExtras());
      }
      localObject1 = a((Intent)localObject2, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), paramGenerateContext, str1, str2);
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
        FileUtils.d(paramGenerateContext.a.jdField_a_of_type_JavaLangString);
        new File(paramGenerateContext.a.jdField_a_of_type_JavaLangString);
        ImageUtil.a(this, paramGenerateContext.a.jdField_a_of_type_JavaLangString);
      }
      ((Intent)localObject2).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      paramGenerateContext = (GenerateContext)localObject1;
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
          QQToast.a(this, "图片不存在", 0).a();
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
          break label526;
        }
        paramInt1 = i;
      }
    }
    label526:
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
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.h();
        return;
      }
      a(paramInt2, paramIntent, 2131034158, 0);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 != 1001) {
        break;
      }
      a(paramInt2, paramIntent, 2131034158, 0);
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
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoModule.init(this);
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    EditPicConstants.a(QQStoryContext.a().a(), this);
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    NewFlowCameraReporter.a("finish jump activity", NewFlowCameraReporter.a(getIntent()));
    SLog.d("EditPicActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if ((localEditVideoParams == null) || (TextUtils.isEmpty(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a())))
    {
      QQToast.a(this, "图片参数错误", 0).a();
      finish();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity", 2, "source " + localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    }
    if (!FileUtils.a(localEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()))
    {
      QQToast.a(this, "图片不存在", 0).a();
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("editpic_cameratype", -1);
    if (i == 1)
    {
      NewFlowCameraReporter.h();
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", System.currentTimeMillis()).commit();
    }
    try
    {
      for (;;)
      {
        PtvFilterSoLoad.a(VideoEnvironment.a(), false);
        if (VideoEnvironment.a("AVCodec", super.getApplicationContext()) != 0) {
          SLog.e("EditPicActivity", "load AVCodec so failed");
        }
        getWindow().addFlags(1024);
        setContentViewC(2130969186);
        a(paramBundle);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(this, localEditVideoParams);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("FILTER_STRING");
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.jdField_a_of_type_Int = getIntent().getIntExtra("FILTER_MAXSIDE", 640);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoArtFilter.c = getIntent().getStringExtra("FILTER_LOADING_PATH");
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart != null))
        {
          long l2 = getIntent().getLongExtra("babyq_ability", 0L) & 0x2;
          long l1 = l2;
          if (l2 == 0L) {
            l1 = getIntent().getLongExtra("arithmetic_ability", 0L) & 1L;
          }
          paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicRawImage;
          if (l1 <= 0L) {
            break;
          }
          bool = true;
          paramBundle.jdField_a_of_type_Boolean = bool;
          paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditPicCropPart;
          if (l1 <= 0L) {
            break label593;
          }
          bool = true;
          paramBundle.d = bool;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.j();
        PtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$DoodleInfoLoadObserver, false);
        if (localEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) {
          VideoEditReport.a(localEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("pic_entrance_type", 0));
        }
        GeneratePicArgs.a(null);
        return true;
        if (i == 2) {
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
        boolean bool = false;
        continue;
        label593:
        bool = false;
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SLog.b("EditPicActivity", "doOnDestroy %d", Integer.valueOf(System.identityHashCode(this)));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.o();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SLog.c("EditPicActivity", "doOnPause");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.m();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    SLog.c("EditPicActivity", "doOnResume");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.l();
    NewFlowCameraReporter.a("resume activity");
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    SLog.c("EditPicActivity", "doOnStart");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.k();
    VideoEditReport.jdField_a_of_type_JavaLangString = VideoEditReport.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int);
    VideoEditReport.jdField_b_of_type_JavaLangString = "pic_edit";
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    SLog.c("EditPicActivity", "doOnStop");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.n();
    VideoEditReport.jdField_a_of_type_JavaLangString = "";
    VideoEditReport.jdField_b_of_type_JavaLangString = "";
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicActivity
 * JD-Core Version:    0.7.0.1
 */