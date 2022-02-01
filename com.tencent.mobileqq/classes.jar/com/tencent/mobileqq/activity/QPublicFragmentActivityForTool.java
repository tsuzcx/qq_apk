package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QPublicFragmentActivityForTool
  extends QPublicFragmentActivity
{
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass, int paramInt)
  {
    QPublicFragmentActivity.Launcher.a(paramActivity, paramIntent, QPublicFragmentActivityForTool.class, paramClass, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends QPublicBaseFragment> paramClass)
  {
    QPublicFragmentActivity.Launcher.a(paramContext, paramIntent, QPublicFragmentActivityForTool.class, paramClass);
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
 * Qualified Name:     com.tencent.mobileqq.activity.QPublicFragmentActivityForTool
 * JD-Core Version:    0.7.0.1
 */