package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PeakFragmentActivity
  extends QBaseActivity
{
  protected AppInterface appInterface;
  protected boolean mNeedPauseRichMedia = true;
  
  protected void adjustStatusBar()
  {
    SimpleUIUtil.a(this.mSystemBarComp, getWindow());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    if ((getAppRuntime() instanceof AppInterface)) {
      this.appInterface = ((AppInterface)getAppRuntime());
    }
    setVolumeControlStream(3);
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.mNeedPauseRichMedia)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
  
  protected String getModuleId()
  {
    return "peak";
  }
  
  public int getStatusBarHeight()
  {
    int i = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity
 * JD-Core Version:    0.7.0.1
 */