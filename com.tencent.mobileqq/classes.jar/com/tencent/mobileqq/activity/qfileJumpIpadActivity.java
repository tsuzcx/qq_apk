package com.tencent.mobileqq.activity;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import antf;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qfileJumpIpadActivity
  extends qfileJumpActivity
{
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
    this.a = antf.A;
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpIpadActivity
 * JD-Core Version:    0.7.0.1
 */