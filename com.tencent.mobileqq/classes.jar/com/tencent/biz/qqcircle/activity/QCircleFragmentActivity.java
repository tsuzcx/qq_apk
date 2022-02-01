package com.tencent.biz.qqcircle.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import uxh;
import vri;
import vrl;

public class QCircleFragmentActivity
  extends PublicFragmentActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (300001 == paramInt1)
    {
      QLog.d("QCircleFragmentActivity", 1, "doOnActivityResult，return from qzone publish page");
      vri.a().d(36);
    }
  }
  
  public void doOnBackPressed()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnBackPressed");
    super.doOnBackPressed();
    PublicBaseFragment localPublicBaseFragment = a();
    if ((localPublicBaseFragment instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)localPublicBaseFragment).i();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnCreate");
    return super.doOnCreate(paramBundle);
  }
  
  public void doOnDestroy()
  {
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnDestroy");
    super.doOnDestroy();
    uxh.a();
    VSNetworkHelper.a().a(this);
    vrl.a().a();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    QLog.d("QCircleFragmentActivity", 1, "QCircleFragmentActivity->doOnNewIntent");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.activity.QCircleFragmentActivity
 * JD-Core Version:    0.7.0.1
 */