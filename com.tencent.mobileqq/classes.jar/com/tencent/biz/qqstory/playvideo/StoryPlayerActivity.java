package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;

public class StoryPlayerActivity
  extends FragmentActivity
  implements StoryPlayerImpl.Ui, IEventReceiver
{
  public static int a;
  private static int b;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  private StoryPlayerActivity.ClosePlayerAnimationInfoEventReceiver jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity$ClosePlayerAnimationInfoEventReceiver = new StoryPlayerActivity.ClosePlayerAnimationInfoEventReceiver(this);
  protected StoryPlayerImpl a;
  protected AnimationParam a;
  protected boolean a;
  protected AnimationParam b;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_b_of_type_Int = 0;
  }
  
  public StoryPlayerActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = false;
  }
  
  @NonNull
  public Context a()
  {
    return this;
  }
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  public void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl = new StoryPlayerImpl();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.a(this);
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_b_of_type_Int += 1;
    SLog.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate, instance count = %d", Integer.valueOf(jdField_b_of_type_Int));
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    LiuHaiUtils.a(this);
    if (LiuHaiUtils.c())
    {
      getWindow().clearFlags(1024);
      getWindow().addFlags(2048);
    }
    this.isClearCoverLayer = true;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131714425), 0).a();
      finish();
      return false;
    }
    super.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = ((AnimationParam)getIntent().getParcelableExtra("AnimationParam"));
    SLog.b("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate = > StoryPlayerActivity doOnCreate");
    setContentView(2131561887);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.a(paramBundle, getIntent().getExtras());
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      paramBundle = findViewById(16908290);
      paramBundle.getViewTreeObserver().addOnPreDrawListener(new StoryPlayerActivity.1(this, paramBundle));
    }
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity$ClosePlayerAnimationInfoEventReceiver);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_b_of_type_Int -= 1;
    SLog.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnDestroy, instance count = %d", Integer.valueOf(jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.g();
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerActivity$ClosePlayerAnimationInfoEventReceiver);
    FeedManager.d();
    if (jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidOsHandler.post(new StoryPlayerActivity.2(this));
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.e();
    StoryReportor.a(2, this.currentActivityStayTime);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.d();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.f();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void finish()
  {
    boolean bool;
    ViewGroup localViewGroup;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null)
    {
      bool = true;
      SLog.a("Q.qqstory.playernew.StoryPlayerActivity", "finish with animation = %s", Boolean.valueOf(bool));
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam == null) {
        break label94;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.b();
        localViewGroup = (ViewGroup)a();
        if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam == null) {
          break label86;
        }
      }
    }
    label86:
    for (AnimationParam localAnimationParam = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam;; localAnimationParam = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam)
    {
      AnimationUtils.a(localViewGroup, localAnimationParam, new StoryPlayerActivity.3(this));
      return;
      bool = false;
      break;
    }
    label94:
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.b();
    super.finish();
    overridePendingTransition(2130771990, 2130771991);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayerImpl.a()) {
      return true;
    }
    return super.onBackEvent();
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
  
  public void setImmersiveStatus()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      int i = getResources().getColor(2131167305);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, i);
        this.mSystemBarComp.setStatusDrawable(null);
      }
      if (!isInMultiWindow()) {
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity
 * JD-Core Version:    0.7.0.1
 */