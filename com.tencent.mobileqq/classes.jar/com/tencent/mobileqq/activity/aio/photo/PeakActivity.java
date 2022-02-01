package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class PeakActivity
  extends BaseActivity2
{
  protected boolean o = true;
  
  private static AppInterface b()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
      localObject = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
      if ((localObject instanceof PeakAppInterface))
      {
        localObject = (PeakAppInterface)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("BaseActivity2", 1, "getAppRuntime fail, ", localException);
    }
    return null;
  }
  
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
      b();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.o)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PeakActivity
 * JD-Core Version:    0.7.0.1
 */