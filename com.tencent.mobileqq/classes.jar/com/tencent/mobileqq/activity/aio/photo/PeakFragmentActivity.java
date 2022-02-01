package com.tencent.mobileqq.activity.aio.photo;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import bdfk;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PeakFragmentActivity
  extends FragmentActivity
{
  protected AppInterface appInterface;
  protected boolean mNeedPauseRichMedia = true;
  @Deprecated
  protected PeakAppInterface mPeakApp;
  
  protected void adjustStatusBar()
  {
    bdfk.a(this.mSystemBarComp, getWindow());
  }
  
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
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof PeakAppInterface)) {
      this.mPeakApp = ((PeakAppInterface)getAppRuntime());
    }
    if ((getAppRuntime() instanceof AppInterface)) {
      this.appInterface = ((AppInterface)getAppRuntime());
    }
    setVolumeControlStream(3);
    return true;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.mNeedPauseRichMedia)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public int getStatusBarHeight()
  {
    int i = 0;
    int j = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity
 * JD-Core Version:    0.7.0.1
 */