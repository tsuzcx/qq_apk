package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy;
import com.tencent.mobileqq.emosm.EmosmStrategyFactory;
import com.tencent.mobileqq.emosm.FavEmosmViewPage;
import com.tencent.mobileqq.emosm.FavEmosmViewPage.IEmosmViewPagerListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FavEmosmManageActivity
  extends IphoneTitleBarActivity
  implements FavEmosmViewPage.IEmosmViewPagerListener
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new FavEmosmManageActivity.1(this);
  private SDKEmotionSettingManager jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager;
  private BaseEmosmStrategy jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy;
  private FavEmosmViewPage jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage;
  
  private void a()
  {
    Intent localIntent = getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmManageActivity", 2, "SDKEmotionSettingManager not init ");
      }
    }
    boolean bool;
    do
    {
      return;
      bool = localIntent.getBooleanExtra("key_from_sdk_set_emotion", false);
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmManageActivity", 2, "initParam fromSdkSetAvatar =  " + bool);
      }
    } while (!bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager = new SDKEmotionSettingManager(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.a(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (localFlingGestureHandler.mTopLayout != null) {
        localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(false);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean);
      return;
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
    super.setContentView(2131559204);
    int i = getIntent().getIntExtra("camera_emo_mode", 0);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage = new FavEmosmViewPage(this.app, this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a(this);
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy = EmosmStrategyFactory.a(this.app, this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage, i);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a(this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.refresh.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.upload.emotiom");
      getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a();
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.g();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.b) {
      getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.d();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.b(paramIntent);
      return;
    }
    setIntent(paramIntent);
    a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.a();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public boolean isWrapContent()
  {
    return super.isWrapContent();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmBaseEmosmStrategy.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavEmosmViewPage.g();
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity
 * JD-Core Version:    0.7.0.1
 */