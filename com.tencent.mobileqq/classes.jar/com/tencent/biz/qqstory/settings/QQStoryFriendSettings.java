package com.tencent.biz.qqstory.settings;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.delegates.ActivityDelegate;
import com.tencent.biz.qqstory.boundaries.implement.NullableObjectFactoryImplement;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQStoryFriendSettings
  extends IphoneTitleBarActivity
{
  protected ActivityDelegate<QQStoryFriendSettings> a = StoryApi.a(QQStoryFriendSettingDelegate.class, NullableObjectFactoryImplement.a(ActivityDelegate.class), new Object[0]);
  
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
    super.doOnCreate(paramBundle);
    this.a.a(this, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.a(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    StoryReportor.a(7, this.currentActivityStayTime);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettings
 * JD-Core Version:    0.7.0.1
 */