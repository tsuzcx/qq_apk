package com.tencent.mobileqq.activity;

import acsc;
import ahsh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import aphr;
import apig;
import apik;
import apit;
import azmj;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;

public class FavEmosmManageActivity
  extends IphoneTitleBarActivity
  implements apit
{
  private ahsh jdField_a_of_type_Ahsh;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new acsc(this);
  private aphr jdField_a_of_type_Aphr;
  private apik jdField_a_of_type_Apik;
  
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
    this.jdField_a_of_type_Ahsh = new ahsh(this);
    this.jdField_a_of_type_Ahsh.a(localIntent);
    this.jdField_a_of_type_Ahsh.a();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559061);
    int i = getIntent().getIntExtra("camera_emo_mode", 0);
    this.jdField_a_of_type_Apik = new apik(this.app, this);
    this.jdField_a_of_type_Apik.a(this);
    this.jdField_a_of_type_Aphr = apig.a(this.app, this.jdField_a_of_type_Apik, i);
    this.jdField_a_of_type_Apik.a(this.jdField_a_of_type_Aphr);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.refresh.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.upload.emotiom");
      getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    a();
    this.jdField_a_of_type_Aphr.a();
    this.jdField_a_of_type_Aphr.g();
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
    if (this.jdField_a_of_type_Aphr.b) {
      getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    if (this.jdField_a_of_type_Ahsh != null) {
      this.jdField_a_of_type_Ahsh.e();
    }
    this.jdField_a_of_type_Aphr.d();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_Ahsh != null)
    {
      this.jdField_a_of_type_Ahsh.b(paramIntent);
      return;
    }
    setIntent(paramIntent);
    a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Apik.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Apik.a();
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
    if (this.jdField_a_of_type_Aphr != null) {
      this.jdField_a_of_type_Aphr.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    azmj.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Ahsh != null) {
      this.jdField_a_of_type_Ahsh.b();
    }
    if (this.jdField_a_of_type_Apik != null) {
      this.jdField_a_of_type_Apik.g();
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity
 * JD-Core Version:    0.7.0.1
 */