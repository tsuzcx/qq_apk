package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VerifyCodeActivity2
  extends VerifyCodeActivity
{
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
    try
    {
      boolean bool = super.doOnCreate(paramBundle);
      return bool;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyCodeActivity2", 2, "e= " + paramBundle);
      }
      finish();
      return false;
    }
    catch (Error paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VerifyCodeActivity2", 2, "e= " + paramBundle);
        }
        finish();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyCodeActivity2
 * JD-Core Version:    0.7.0.1
 */