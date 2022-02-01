package com.tencent.biz.qqstory.debug.activities;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DebugPollLayoutActivity
  extends Activity
{
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
    super.onCreate(paramBundle);
    setContentView(2131558447);
    paramBundle = PollWidgetUtils.a(this, 1, 1, null);
    ((FrameLayout)findViewById(2131365255)).addView(paramBundle.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugPollLayoutActivity
 * JD-Core Version:    0.7.0.1
 */