package com.tencent.mobileqq.activity.qwallet;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QWalletFullWindowActivity
  extends QQTranslucentBrowserActivity
{
  public QWalletFullWindowActivity()
  {
    this.a = QWalletFullWindowActivity.QWalletFullWindowFragment.class;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    sendBroadcast(new Intent("action_onpause"));
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    sendBroadcast(new Intent("action_onresume"));
  }
  
  public void onBackPressed()
  {
    sendBroadcast(new Intent("action_close_camera"));
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    if (findViewById(2131363653) != null) {}
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletFullWindowActivity
 * JD-Core Version:    0.7.0.1
 */