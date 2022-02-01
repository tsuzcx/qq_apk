package com.tencent.av.smallscreen;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
{
  private DialogModelBase a = null;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    int i = getIntent().getIntExtra("tag_model", 0);
    if (i == 0) {
      this.a = new FloatWindowPrivacyModel(this);
    } else if (1 == i) {
      this.a = new WTDialogModel(this);
    } else {
      this.a = null;
    }
    DialogModelBase localDialogModelBase = this.a;
    if (localDialogModelBase != null)
    {
      localDialogModelBase.a(paramBundle);
      return;
    }
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    DialogModelBase localDialogModelBase = this.a;
    if (localDialogModelBase != null) {
      localDialogModelBase.d();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    DialogModelBase localDialogModelBase = this.a;
    if (localDialogModelBase != null) {
      localDialogModelBase.b();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    DialogModelBase localDialogModelBase = this.a;
    if (localDialogModelBase != null) {
      localDialogModelBase.a();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    DialogModelBase localDialogModelBase = this.a;
    if (localDialogModelBase != null) {
      localDialogModelBase.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDialogActivity
 * JD-Core Version:    0.7.0.1
 */