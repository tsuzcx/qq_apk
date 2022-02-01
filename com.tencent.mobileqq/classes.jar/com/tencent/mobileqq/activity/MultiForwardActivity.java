package com.tencent.mobileqq.activity;

import Override;
import afoc;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MultiForwardActivity
  extends ChatActivity
{
  public afoc a = new afoc();
  
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
    boolean bool = super.doOnCreate(paramBundle);
    this.a.a(this);
    return bool;
  }
  
  public void doOnDestroy()
  {
    Object localObject = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {}
    for (localObject = ((ChatFragment)localObject).a();; localObject = null)
    {
      if (localObject != null) {
        ((BaseChatPie)localObject).doOnDestroy();
      }
      this.a.c(this);
      super.doOnDestroy();
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.a.b(this);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MultiForwardActivity
 * JD-Core Version:    0.7.0.1
 */