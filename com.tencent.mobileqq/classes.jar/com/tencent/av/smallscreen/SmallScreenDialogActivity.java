package com.tencent.av.smallscreen;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import lzd;
import lze;
import maf;
import mqq.app.BaseActivity;

public class SmallScreenDialogActivity
  extends BaseActivity
{
  private lzd a;
  
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    int i = getIntent().getIntExtra("tag_model", 0);
    if (i == 0) {
      this.a = new lze(this);
    }
    while (this.a != null)
    {
      this.a.a(paramBundle);
      return;
      if (1 == i) {
        this.a = new maf(this);
      } else {
        this.a = null;
      }
    }
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.a != null) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDialogActivity
 * JD-Core Version:    0.7.0.1
 */