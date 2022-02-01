package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import bmqa;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import oge;
import oiz;
import sgc;

public class ReadInJoyFollowActivity
  extends IphoneTitleBarActivity
{
  public oge a;
  
  private void a()
  {
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131376073);
    this.a = new oge(this);
    this.a.a(70);
    this.a.b(0);
    this.a.a(localViewGroup);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    sgc.a().a(this);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2131560175);
    getWindow().setBackgroundDrawable(null);
    setClickableTitle("BB圈", new oiz(this));
    a();
    this.a.a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.d();
    sgc.a().b(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.a.g();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.a.h();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    bmqa.a(getAppRuntime());
    this.a.e();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.a.f();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity
 * JD-Core Version:    0.7.0.1
 */