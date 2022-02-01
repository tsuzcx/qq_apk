package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PeakActivity
  extends BaseActivity2
{
  protected boolean e = true;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected String getModuleId()
  {
    return "peak";
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
    setVolumeControlStream(3);
    if (!isLatecyWaitRuntime()) {
      ((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.e)
    {
      NativeVideoImage.pauseAll();
      AbstractGifImage.pauseAll();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakActivity
 * JD-Core Version:    0.7.0.1
 */