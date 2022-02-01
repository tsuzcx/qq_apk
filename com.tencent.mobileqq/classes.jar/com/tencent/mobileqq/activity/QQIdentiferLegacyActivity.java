package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

@RoutePage(desc="人脸识别引导页", path="/base/connectface/legacy")
public class QQIdentiferLegacyActivity
  extends QIphoneTitleBarActivity
{
  public static void changeBaseFragment(FragmentActivity paramFragmentActivity, Fragment paramFragment)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = paramFragmentActivity.beginTransaction();
    if (paramFragmentActivity.findFragmentById(2131367906) != null) {
      localFragmentTransaction.replace(2131367906, paramFragment);
    } else {
      localFragmentTransaction.add(2131367906, paramFragment);
    }
    if (VersionUtils.e())
    {
      localFragmentTransaction.commitAllowingStateLoss();
      return;
    }
    localFragmentTransaction.commit();
  }
  
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
    super.doOnCreate(paramBundle);
    paramBundle = new FrameLayout(this);
    paramBundle.setId(2131367906);
    paramBundle.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    setContentView(paramBundle);
    changeBaseFragment(this, new QQIdentiferLegacy());
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacyActivity
 * JD-Core Version:    0.7.0.1
 */