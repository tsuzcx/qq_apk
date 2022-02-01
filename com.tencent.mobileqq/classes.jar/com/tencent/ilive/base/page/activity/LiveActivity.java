package com.tencent.ilive.base.page.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.falco.utils.UIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LiveActivity
  extends FragmentActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public Resources getResources()
  {
    Log.d("LiveActivity", "getResources");
    Resources localResources = super.getResources();
    if (localResources != null)
    {
      localObject = localResources.getConfiguration();
      if ((localObject != null) && (((Configuration)localObject).fontScale != 1.0F))
      {
        ((Configuration)localObject).fontScale = 1.0F;
        Log.d("LiveActivity", "getResources activity updateConfiguration");
        localResources.updateConfiguration((Configuration)localObject, localResources.getDisplayMetrics());
      }
    }
    Object localObject = getApplicationContext().getResources();
    if (localObject != null)
    {
      Configuration localConfiguration = ((Resources)localObject).getConfiguration();
      if ((localConfiguration != null) && (localConfiguration.fontScale != 1.0F))
      {
        localConfiguration.fontScale = 1.0F;
        Log.d("LiveActivity", "getResources application updateConfiguration");
        ((Resources)localObject).updateConfiguration(localConfiguration, ((Resources)localObject).getDisplayMetrics());
      }
    }
    return localResources;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      Log.e("LiveActivity", "error--onCreate--savedInstanceState != null");
    }
  }
  
  protected void setFullScreen()
  {
    UIUtil.setFullscreen(this, true, true);
    UIUtil.setStatusBarColor(this, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.base.page.activity.LiveActivity
 * JD-Core Version:    0.7.0.1
 */