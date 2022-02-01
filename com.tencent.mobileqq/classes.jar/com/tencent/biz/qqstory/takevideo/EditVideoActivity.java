package com.tencent.biz.qqstory.takevideo;

import Override;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import anvx;
import bczp;
import bdla;
import bheg;
import bmwb;
import bnky;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sveffects.SvEffectSdkInitor;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import vzh;
import wjl;
import wjs;
import wjy;
import ykq;
import ykv;
import ykw;
import yls;
import ynw;
import ypg;
import yya;
import yye;
import zch;
import zeb;

public class EditVideoActivity
  extends QQStoryBaseActivity
  implements ypg
{
  public ynw a;
  
  private void e()
  {
    wjl localwjl = (wjl)wjs.a(10);
    boolean bool1 = ((Boolean)localwjl.b("boolean_enable_revert_play_mode", Boolean.valueOf(true))).booleanValue();
    boolean bool2 = ((Boolean)localwjl.b("boolean_enable_flow_decode", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = ((Boolean)localwjl.b("boolean_use_flow_decode_first", Boolean.valueOf(false))).booleanValue();
    QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 2, "check reverse play mode. enableIFrameRevert = " + bool1 + ", enableFlowRevert = " + bool2 + ", useFlowDecodeFirst = " + bool3);
    if (bool3)
    {
      if (bool2)
      {
        bbld.jdField_a_of_type_Boolean = true;
        bbld.jdField_b_of_type_Boolean = true;
        return;
      }
      if (bool1)
      {
        bbld.jdField_a_of_type_Boolean = true;
        bbld.jdField_b_of_type_Boolean = false;
        return;
      }
      bbld.jdField_a_of_type_Boolean = false;
      bbld.jdField_b_of_type_Boolean = false;
      return;
    }
    if (bool1)
    {
      bbld.jdField_a_of_type_Boolean = true;
      bbld.jdField_b_of_type_Boolean = false;
      return;
    }
    if (bool2)
    {
      bbld.jdField_a_of_type_Boolean = true;
      bbld.jdField_b_of_type_Boolean = true;
      return;
    }
    bbld.jdField_a_of_type_Boolean = false;
    bbld.jdField_b_of_type_Boolean = false;
  }
  
  private void f()
  {
    long l1 = Runtime.getRuntime().totalMemory() / 1024L;
    long l2 = Runtime.getRuntime().maxMemory() / 1024L;
    long l3 = l1 - Runtime.getRuntime().freeMemory() / 1024L;
    long l4 = l2 - l3;
    ykq.a("Q.qqstory.publish.edit.EditVideoActivity", "trimMemoryIfNeeded, memory %d/%d, max %d, remain %d", Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4));
    if (l4 < 51200L)
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoActivity", "URLDrawable clearMemoryCache, memory %d/%d KB, max %d KB, remain %d KB, URLDrawable cache size %d KB", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l4), Integer.valueOf(BaseApplicationImpl.sImageCache.size() / 1024) });
      ((wjy)wjs.a(26)).a(2);
      return;
    }
    ((wjy)wjs.a(26)).a(0);
  }
  
  @NonNull
  public Activity a()
  {
    return this;
  }
  
  public Intent a(yya paramyya)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalGifSource))
    {
      Intent localIntent = getIntent();
      localObject1 = localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(localIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject1);
      ArrayList localArrayList = new ArrayList();
      EditLocalGifSource localEditLocalGifSource = (EditLocalGifSource)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource;
      Object localObject2;
      if ((paramyya.jdField_a_of_type_Yye.jdField_b_of_type_Boolean) || (!paramyya.jdField_a_of_type_Yye.jdField_a_of_type_Boolean)) {
        if (!TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource.getSourcePath();
          localIntent.putExtra("need_combine_gif", paramyya.jdField_a_of_type_Yye.c);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.publish.edit.EditVideoActivity", 1, "send sourcePath | generateContext.generatePicArgs.isDelayTimeChange:" + paramyya.jdField_a_of_type_Yye.c);
            localObject2 = localObject1;
          }
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(localEditLocalGifSource.jdField_a_of_type_JavaLangString)) {
          break label507;
        }
        localIntent.putExtra("orign_path", localEditLocalGifSource.getSourcePath());
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        localIntent.putExtra("gif_delay_time", paramyya.jdField_a_of_type_Yye.jdField_b_of_type_Int);
        localIntent.putExtra("gif_has_antishake", this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d);
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditTakeGifSource)) {
          localIntent.putExtra("PhotoConst.IS_RECORD_GIF", true);
        }
        localArrayList.add(localObject2);
        bheg.a(this, (String)localObject2);
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
          if (!paramyya.jdField_a_of_type_Yye.c) {
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
        localObject2 = paramyya.jdField_a_of_type_Yye.jdField_b_of_type_JavaLangString;
        localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
        localIntent.putExtra("need_combine_gif", true);
      }
      label507:
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d) {
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.b);
      }
      for (;;)
      {
        localIntent.putExtra("combine_image_path", (String)localObject2);
        localIntent.putExtra("doodle_bitmap_path", paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
        localIntent.putExtra("gif_delay_time", paramyya.jdField_a_of_type_Yye.jdField_b_of_type_Int);
        localIntent.putExtra("gif_has_antishake", this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.d);
        break;
        localIntent.putExtra("orign_list_path", localEditLocalGifSource.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra(PublishParam.jdField_a_of_type_JavaLangString, paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
    return localObject1;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  protected void a()
  {
    if (this.a == null) {
      this.a = new ynw();
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
    f();
  }
  
  protected void a(Bundle paramBundle) {}
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    if ((Build.MODEL.equals("HM NOTE 1TD")) && (Build.VERSION.SDK_INT < 18))
    {
      ykq.d("Q.qqstory.publish.edit.EditVideoActivity", "disable show loading dialog");
      return;
    }
    super.a(paramCharSequence, paramBoolean, paramLong);
  }
  
  public void c()
  {
    super.c();
    ykq.d("Q.qqstory.publish.edit.EditVideoActivity", "onOutOfMemory");
    f();
  }
  
  public void d()
  {
    if (this.a.jdField_a_of_type_Yll != null) {
      return;
    }
    ((TrimTextureVideoView)findViewById(2131367011)).b();
  }
  
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
    int i;
    if (paramInt1 == 10010)
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
          break label211;
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
          break label226;
        }
        a(paramInt2, paramIntent, 2130772030, 0);
      }
    }
    for (;;)
    {
      ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnActivityResult requestCode=" + paramInt1 + " resultCode=" + paramInt2);
      this.a.a(paramInt1, paramInt2, paramIntent);
      return;
      label211:
      getIntent().putExtra("forward_source_from_shoot_quick", true);
      break;
      label226:
      if (i == 1003)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId = 1;
        this.a.a();
      }
      else
      {
        a(paramInt2, paramIntent, 2130772030, 0);
        continue;
        super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void doOnBackPressed()
  {
    ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnBackPressed");
    if (!this.a.b()) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    e();
    SvEffectSdkInitor.isDovCapture = false;
    SvEffectSdkInitor.init();
    bmwb.a();
    ykq.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate start");
    a();
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    this.isClearCoverLayer = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    bczp.a(QQStoryContext.a().a(), this);
    yls.a(QQStoryContext.a().a(), this);
    try
    {
      bnky.c();
      if (VideoEnvironment.loadAVCodecSo("AVCodec", getApplicationContext()) != 0)
      {
        ykq.e("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed");
        finish();
        return true;
      }
    }
    catch (Exception paramBundle)
    {
      ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "load AVCodec so failed", paramBundle);
      finish();
      return true;
    }
    int i = getIntent().getIntExtra("uintype", -1);
    EditVideoParams localEditVideoParams = (EditVideoParams)getIntent().getParcelableExtra(EditVideoParams.class.getName());
    if ((getIntent().getBooleanExtra("extra_has_antishake", false)) && (localEditVideoParams != null) && ((localEditVideoParams.mEditSource instanceof EditLocalGifSource)))
    {
      localObject = (EditLocalGifSource)localEditVideoParams.mEditSource;
      ((EditLocalGifSource)localObject).b = getIntent().getStringArrayListExtra("extra_antishake_gif_path_list");
      if ((((EditLocalGifSource)localObject).b != null) && (((EditLocalGifSource)localObject).b.size() > 1)) {
        ((EditLocalGifSource)localObject).jdField_a_of_type_Boolean = true;
      }
    }
    if ((localEditVideoParams != null) && ((localEditVideoParams.mEditSource instanceof EditLocalGifSource))) {
      ((EditLocalGifSource)localEditVideoParams.mEditSource).jdField_a_of_type_Int = getIntent().getIntExtra("extra_checked_similarity_ok_to_antishake", 0);
    }
    ykq.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, video params=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localEditVideoParams });
    if (localEditVideoParams != null) {}
    for (Object localObject = localEditVideoParams.checkParams(); !TextUtils.isEmpty((CharSequence)localObject); localObject = "can not find EditVideoParams")
    {
      QQToast.a(this, anvx.a(2131703293) + (String)localObject, 0).a();
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
      if (localEditVideoParams.mBusinessId == 1)
      {
        localObject = "grp_story";
        str1 = "video_edit";
      }
    }
    ykq.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnCreate instance=%d, department=%s, opType=%s", new Object[] { Integer.valueOf(System.identityHashCode(this)), localObject, str1 });
    try
    {
      VideoSourceHelper.nativeSetPlayStepFrameCount(1);
      VideoSourceHelper.nativeSetPlayGapFrameCount(1);
      getWindow().addFlags(1024);
      setContentViewC(2131561829);
      a(paramBundle);
      if (localEditVideoParams.mExtra != null)
      {
        localEditVideoParams.mExtra.putInt("uintype", i);
        zch.a("Q.qqstory.publish.edit.EditVideoActivity", localEditVideoParams.mExtra);
        this.a.a(this, localEditVideoParams);
        this.a.i();
        zeb.a(vzh.e);
        ykw.jdField_a_of_type_JavaLangString = (String)localObject;
        ykw.jdField_b_of_type_JavaLangString = str1;
        if ((!ykw.a()) || (VideoEnvironment.getAVCodecVersion() < 21)) {}
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          VideoSourceHelper.nativeSetMaxPhotoFrameCount(3);
          ykq.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity set min frame!");
          ykw.a("0X80076B5");
          if (localEditVideoParams.mBusinessId == 2)
          {
            if (i != 1) {
              break;
            }
            paramBundle = "3";
            ykv.a("aio_shoot", "exp_edit", 0, 0, new String[] { "1", paramBundle });
          }
          LpReportInfo_pf00064.allReport(628, 1);
          ykq.b("Q.qqstory.publish.edit.EditVideoActivity", "EditVideoActivity doOnCreate end");
          if (localEditVideoParams.mBusinessId == 10) {
            bdla.b(null, "dc00899", "Grp_tribe", "", "video_edit", "exp_edit", 0, 0, "", "", "", "");
          }
          f();
          if ((localEditVideoParams.mBusinessId == 10) || (localEditVideoParams.mBusinessId == 12)) {
            ((RelativeLayout)findViewById(2131366018)).setBackgroundColor(-16777216);
          }
          StatisticCollector.report("exposure_old_editVideo");
          return true;
          localThrowable = localThrowable;
          QLog.w("Q.qqstory.publish.edit.EditVideoActivity", 1, "VideoSourceHelper error:", localThrowable);
        }
        ykq.e("Q.qqstory.publish.edit.EditVideoActivity", "video editVideoParams.mExtra is null!!");
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
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    ykq.d("Q.qqstory.publish.edit.EditVideoActivity", "doOnDestroy %d", new Object[] { Integer.valueOf(System.identityHashCode(this)) });
    this.a.n();
    ykw.jdField_a_of_type_JavaLangString = "";
    ykw.jdField_b_of_type_JavaLangString = "";
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnPause");
    this.a.l();
    ThreadManagerV2.excute(new EditVideoActivity.2(this), 16, null, false);
  }
  
  public void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnRestoreInstanceState");
    this.a.a(paramBundle);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnResume");
    this.a.k();
    ThreadManagerV2.excute(new EditVideoActivity.1(this), 16, null, false);
    d();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnSaveInstanceState");
    this.a.b(paramBundle);
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStart");
    this.a.j();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    ykq.c("Q.qqstory.publish.edit.EditVideoActivity", "doOnStop");
    this.a.m();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    ykq.d("Q.qqstory.publish.edit.EditVideoActivity", "onTrimMemory %d", new Object[] { Integer.valueOf(paramInt) });
    f();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoActivity
 * JD-Core Version:    0.7.0.1
 */