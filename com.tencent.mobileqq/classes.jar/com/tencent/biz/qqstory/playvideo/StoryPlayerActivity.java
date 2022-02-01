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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;

public class StoryPlayerActivity
  extends BaseActivity
  implements StoryPlayerImpl.Ui, IEventReceiver
{
  public static int a;
  private static int g;
  protected StoryPlayerImpl b;
  protected Handler c = new Handler(Looper.getMainLooper());
  protected AnimationParam d;
  protected AnimationParam e;
  protected boolean f = false;
  private AudioManager h;
  private StoryPlayerActivity.ClosePlayerAnimationInfoEventReceiver i = new StoryPlayerActivity.ClosePlayerAnimationInfoEventReceiver(this);
  
  @NonNull
  public View a()
  {
    return getWindow().getDecorView();
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    this.b = new StoryPlayerImpl();
    this.b.a(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.b.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    g += 1;
    SLog.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate, instance count = %d", Integer.valueOf(g));
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    LiuHaiUtils.f(this);
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
      QQToast.makeText(this, HardCodeUtil.a(2131911860), 0).show();
      finish();
      return false;
    }
    super.getWindow().addFlags(128);
    this.d = ((AnimationParam)getIntent().getParcelableExtra("AnimationParam"));
    SLog.b("Q.qqstory.playernew.StoryPlayerActivity", "doOnCreate = > StoryPlayerActivity doOnCreate");
    setContentView(2131628116);
    this.h = ((AudioManager)getSystemService("audio"));
    this.b.a(paramBundle, getIntent().getExtras());
    if ((this.d != null) && (!this.f))
    {
      this.f = true;
      paramBundle = findViewById(16908290);
      paramBundle.getViewTreeObserver().addOnPreDrawListener(new StoryPlayerActivity.1(this, paramBundle));
    }
    StoryDispatcher.a().registerSubscriber(this.i);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    g -= 1;
    SLog.a("Q.qqstory.playernew.StoryPlayerActivity", "doOnDestroy, instance count = %d", Integer.valueOf(g));
    this.b.h();
    StoryDispatcher.a().unRegisterSubscriber(this.i);
    FeedManager.j();
    if (g == 0) {
      this.c.post(new StoryPlayerActivity.2(this));
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.b.f();
    StoryReportor.a(2, this.currentActivityStayTime);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.b.e();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.b.d();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.b.g();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void finish()
  {
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    SLog.a("Q.qqstory.playernew.StoryPlayerActivity", "finish with animation = %s", Boolean.valueOf(bool));
    if (this.d != null)
    {
      if (!this.f)
      {
        this.f = true;
        this.b.c();
        ViewGroup localViewGroup = (ViewGroup)a();
        AnimationParam localAnimationParam = this.e;
        if (localAnimationParam == null) {
          localAnimationParam = this.d;
        }
        AnimationUtils.a(localViewGroup, localAnimationParam, new StoryPlayerActivity.3(this));
      }
    }
    else
    {
      this.b.c();
      super.finish();
      overridePendingTransition(2130772005, 2130772006);
    }
  }
  
  @NonNull
  public Context getContext()
  {
    return this;
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  protected boolean onBackEvent()
  {
    if (this.b.a()) {
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void setImmersiveStatus()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      getWindow().addFlags(67108864);
      int j = getResources().getColor(2131168376);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, j);
        this.mSystemBarComp.setStatusDrawable(null);
      }
      if (!isInMultiWindow()) {
        ImmersiveUtils.clearCoverForStatus(getWindow(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerActivity
 * JD-Core Version:    0.7.0.1
 */