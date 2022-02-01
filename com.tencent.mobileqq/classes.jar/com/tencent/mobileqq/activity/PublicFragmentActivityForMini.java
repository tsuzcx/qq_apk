package com.tencent.mobileqq.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublicFragmentActivityForMini
  extends PublicFragmentActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("PublicFragmentActivityForMini", 1, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    MiniAppController.getInstance().notifyResultListener(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    MiniAppConfig localMiniAppConfig = (MiniAppConfig)getIntent().getParcelableExtra("CONFIG");
    if ((localMiniAppConfig != null) && (localMiniAppConfig.isEngineTypeMiniGame()))
    {
      this.mNeedStatusTrans = false;
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
    return super.doOnCreate(paramBundle);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivityForMini
 * JD-Core Version:    0.7.0.1
 */