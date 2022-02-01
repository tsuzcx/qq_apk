package com.tencent.mobileqq.activity;

import Override;
import aelt;
import aelu;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bhdj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class OverloadTipsActivity
  extends BaseActivity
{
  private QQCustomDialog a;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559556);
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
      this.a = bhdj.a(this, 230);
      this.a.setContentView(2131559019);
      this.a.setTitle(null).setMessage(paramBundle).setPositiveButton(2131694482, new aelt(this));
      this.a.setTextContentDescription(paramBundle);
      this.a.setOnKeyListener(new aelu(this));
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