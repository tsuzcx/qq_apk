package com.tencent.biz.qqstory.storyHome.discover.view;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class StoryDiscoverActivity
  extends QQStoryBaseActivity
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity
 * JD-Core Version:    0.7.0.1
 */