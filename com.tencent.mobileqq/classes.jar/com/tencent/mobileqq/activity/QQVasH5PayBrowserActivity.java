package com.tencent.mobileqq.activity;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.manager.MonitorManager;

public class QQVasH5PayBrowserActivity
  extends QQBrowserActivity
{
  public QQVasH5PayBrowserActivity()
  {
    this.a = QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment.class;
  }
  
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
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "QQVasH5PayBrowserActivity doOnCreate: ");
    }
    boolean bool = super.doOnCreate(paramBundle);
    overridePendingTransition(0, 0);
    MonitorManager.a().a(1, 0, "会员：呼起透明支付Activity", "");
    return bool;
  }
  
  public void doOnDestroy()
  {
    setResult(-1);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
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
    getWindow().setBackgroundDrawableResource(2131167296);
    findViewById(2131363780).setBackgroundResource(2131167296);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity
 * JD-Core Version:    0.7.0.1
 */