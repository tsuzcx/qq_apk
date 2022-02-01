package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublicFragmentActivityForTool
  extends PublicFragmentActivity
{
  public static void b(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForTool.class, paramClass, paramInt);
  }
  
  public static void b(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    PublicFragmentActivity.Launcher.a(paramContext, paramIntent, PublicFragmentActivityForTool.class, paramClass);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getModuleId()
  {
    String str2 = getIntent().getStringExtra("moduleId");
    String str1 = str2;
    if (str2 == null) {
      str1 = super.getModuleId();
    }
    return str1;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForTool
 * JD-Core Version:    0.7.0.1
 */