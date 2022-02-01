package com.tencent.biz.qqstory.playvideo;

import Override;
import amtj;
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
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import vli;
import wmc;
import wme;
import wmg;
import wml;
import wmt;
import wqq;
import xnp;
import xvv;
import xwa;

public class StoryPlayerActivity
  extends FragmentActivity
  implements IEventReceiver, wmt
{
  public static int a;
  private static int b;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  protected Handler a;
  public AnimationParam a;
  private wmg jdField_a_of_type_Wmg = new wmg(this);
  protected wml a;
  public boolean a;
  public AnimationParam b;
  
  public StoryPlayerActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
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
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    this.jdField_a_of_type_Wml = new wml();
    this.jdField_a_of_type_Wml.a(this);
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
    this.jdField_a_of_type_Wml.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    jdField_b_of_type_Int += 1;
    xvv.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate, instance count = %d", Integer.valueOf(jdField_b_of_type_Int));
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
      QQToast.a(this, amtj.a(2131713582), 0).a();
      finish();
      return false;
    }
    super.getWindow().addFlags(128);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam = ((AnimationParam)getIntent().getParcelableExtra("AnimationParam"));
    xvv.b("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate = > StoryPlayerActivity doOnCreate");
    setContentView(2131561687);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_a_of_type_Wml.a(paramBundle, getIntent().getExtras());
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      paramBundle = findViewById(16908290);
      paramBundle.getViewTreeObserver().addOnPreDrawListener(new wmc(this, paramBundle));
    }
    vli.a().registerSubscriber(this.jdField_a_of_type_Wmg);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_b_of_type_Int -= 1;
    xvv.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnDestroy, instance count = %d", Integer.valueOf(jdField_b_of_type_Int));
    this.jdField_a_of_type_Wml.g();
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wmg);
    xnp.d();
    if (jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_AndroidOsHandler.post(new StoryPlayerActivity.2(this));
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Wml.e();
    xwa.a(2, this.currentActivityStayTime);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Wml.d();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_Wml.c();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_Wml.f();
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
      xvv.a("Q.qqstory.playernew.StoryPlayerActivity", "finish with animation = %s", Boolean.valueOf(bool));
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam == null) {
        break label94;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Wml.b();
        localViewGroup = (ViewGroup)a();
        if (this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam == null) {
          break label86;
        }
      }
    }
    label86:
    for (AnimationParam localAnimationParam = this.jdField_b_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam;; localAnimationParam = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetAnimationParam)
    {
      wqq.a(localViewGroup, localAnimationParam, new wme(this));
      return;
      bool = false;
      break;
    }
    label94:
    this.jdField_a_of_type_Wml.b();
    super.finish();
    overridePendingTransition(2130771988, 2130771989);
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Wml.a()) {
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
      int i = getResources().getColor(2131167276);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, i);
        this.mSystemBarComp.setStatusDrawable(null);
      }
      if (!isInMultiWindow()) {
        ImmersiveUtils.a(getWindow(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity
 * JD-Core Version:    0.7.0.1
 */