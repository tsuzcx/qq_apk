package com.tencent.mobileqq.activity.aio.photo;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import bdgb;
import bplg;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PeakActivity
  extends BaseActivity2
{
  @Deprecated
  protected AppInterface appInterface;
  protected boolean mNeedPauseRichMedia = true;
  
  protected void adjustStatusBar()
  {
    bdgb.a(this.mSystemBarComp, getWindow());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public String getModuleId()
  {
    return "peak";
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
    setVolumeControlStream(3);
    if (!isLatecyWaitRuntime()) {
      bplg.a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mNeedPauseRichMedia)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakActivity
 * JD-Core Version:    0.7.0.1
 */