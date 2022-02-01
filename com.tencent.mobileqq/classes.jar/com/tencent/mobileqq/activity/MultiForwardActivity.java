package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.forward.MergeForwardRevokeHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MultiForwardActivity
  extends ChatActivity
{
  public MergeForwardRevokeHelper a = new MergeForwardRevokeHelper();
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    this.a.a(this);
    return bool;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = getChatFragment();
    if (localObject != null) {
      localObject = ((ChatFragment)localObject).k();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((BaseChatPie)localObject).K();
    }
    this.a.c(this);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.a.b(this);
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MultiForwardActivity
 * JD-Core Version:    0.7.0.1
 */