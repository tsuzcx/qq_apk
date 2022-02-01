package com.tencent.mobileqq.activity;

import Override;
import afbw;
import afbx;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bhlq;
import bhpc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class OverloadTipsActivity
  extends BaseActivity
{
  private bhpc a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559521);
    if ((getIntent() != null) && (getIntent().getExtras() != null)) {}
    for (paramBundle = getIntent().getExtras().getString("msg");; paramBundle = null)
    {
      if (paramBundle == null)
      {
        finish();
        return false;
      }
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      this.a = null;
      this.a = bhlq.a(this, 230);
      this.a.setContentView(2131558984);
      this.a.setTitle(null).setMessage(paramBundle).setPositiveButton(2131694181, new afbw(this));
      this.a.setTextContentDescription(paramBundle);
      this.a.setOnKeyListener(new afbx(this));
      this.a.show();
      return false;
    }
  }
  
  public void finish()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.finish();
  }
  
  public void onBackPressed() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.OverloadTipsActivity
 * JD-Core Version:    0.7.0.1
 */