package com.sina.weibo.sdk.share;

import Override;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseActivity
  extends Activity
{
  private boolean l()
  {
    try
    {
      TypedArray localTypedArray = obtainStyledAttributes((int[])Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
      Method localMethod = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[] { TypedArray.class });
      localMethod.setAccessible(true);
      bool = ((Boolean)localMethod.invoke(null, new Object[] { localTypedArray })).booleanValue();
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod.setAccessible(false);
        return bool;
      }
      catch (Exception localException2)
      {
        boolean bool;
        break label77;
      }
      localException1 = localException1;
      bool = false;
    }
    label77:
    return bool;
  }
  
  private boolean m()
  {
    try
    {
      Field localField = Activity.class.getDeclaredField("mActivityInfo");
      localField.setAccessible(true);
      ((ActivityInfo)localField.get(this)).screenOrientation = -1;
      localField.setAccessible(false);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
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
    if ((Build.VERSION.SDK_INT == 26) && (l())) {
      m();
    }
    super.onCreate(paramBundle);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((Build.VERSION.SDK_INT == 26) && (l())) {
      return;
    }
    super.setRequestedOrientation(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.share.BaseActivity
 * JD-Core Version:    0.7.0.1
 */