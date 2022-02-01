package com.tencent.gamecenter.wadl.base;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WadlPluginProxyActivity
  extends PluginProxyActivity
{
  public static String a = "WadlPluginProxyActivity";
  
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
  
  public void onCreate(@Nullable Bundle paramBundle, @Nullable PersistableBundle paramPersistableBundle)
  {
    super.onCreate(paramBundle, paramPersistableBundle);
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onCreate...");
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onDestroy...");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onResume...");
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onStart...");
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onStop...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.base.WadlPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */