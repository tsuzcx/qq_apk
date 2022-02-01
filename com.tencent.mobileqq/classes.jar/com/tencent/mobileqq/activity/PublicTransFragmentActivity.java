package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@Deprecated
public class PublicTransFragmentActivity
  extends PublicFragmentActivity
{
  public static void b(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void b(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, PublicTransFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", paramClass.getName());
    paramContext.startActivity(localIntent);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicTransFragmentActivity
 * JD-Core Version:    0.7.0.1
 */