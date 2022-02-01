package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

public class QQIdentiferLegacyActivity
  extends IphoneTitleBarActivity
{
  public static void a(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = paramFragmentActivity.beginTransaction();
    if (paramFragmentActivity.findFragmentById(2131368153) != null) {
      localFragmentTransaction.replace(2131368153, paramFragment);
    }
    while (VersionUtils.e())
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      localFragmentTransaction.add(2131368153, paramFragment);
    }
    localFragmentTransaction.commit();
  }
  
  private void a(String paramString)
  {
    String str = getIntent().getStringExtra("method");
    if ("setFaceData".equals(str)) {
      ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "1", "", "", "");
    }
    if ("loginVerify".equals(str)) {
      ReportController.a(null, "dc00898", "", "", paramString, paramString, 0, 0, "2", "", "", "");
    }
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
    super.doOnCreate(paramBundle);
    paramBundle = new FrameLayout(this);
    paramBundle.setId(2131368153);
    paramBundle.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    setContentView(paramBundle);
    a(this, new QQIdentiferLegacy());
    return true;
  }
  
  public boolean onBackEvent()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131368153);
    if ((localFragment != null) && ((localFragment instanceof QQLightRecognitionGuide))) {
      a("0X800A85E");
    }
    return super.onBackEvent();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131368153);
    if ((localFragment != null) && ((localFragment instanceof QQLightRecognitionGuide))) {
      a("0X800A85E");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacyActivity
 * JD-Core Version:    0.7.0.1
 */