package com.tencent.mobileqq.activity;

import abbh;
import afur;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import anqe;
import anqt;
import anqx;
import anrg;
import axqw;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FavEmosmManageActivity
  extends IphoneTitleBarActivity
  implements anrg
{
  private afur jdField_a_of_type_Afur;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new abbh(this);
  private anqe jdField_a_of_type_Anqe;
  private anqx jdField_a_of_type_Anqx;
  
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
    this.jdField_a_of_type_Afur = new afur(this);
    this.jdField_a_of_type_Afur.a(localIntent);
    this.jdField_a_of_type_Afur.a();
  }
  
  public static void a(Context paramContext, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localIntent = new Intent("com.tencent.mobileqq.action.upload.emotiom");
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", paramArrayList);
      paramContext.sendBroadcast(localIntent);
    }
    while (!QLog.isColorLevel())
    {
      Intent localIntent;
      return;
    }
    QLog.d("FavEmosmManageActivity", 2, "uploadEmotion pathList is empty");
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
    super.setContentView(2131559022);
    int i = getIntent().getIntExtra("camera_emo_mode", 0);
    this.jdField_a_of_type_Anqx = new anqx(this.app, this);
    this.jdField_a_of_type_Anqx.a(this);
    this.jdField_a_of_type_Anqe = anqt.a(this.app, this.jdField_a_of_type_Anqx, i);
    this.jdField_a_of_type_Anqx.a(this.jdField_a_of_type_Anqe);
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.refresh.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.upload.emotiom");
      getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    }
    a();
    this.jdField_a_of_type_Anqe.a();
    this.jdField_a_of_type_Anqe.g();
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
    if (this.jdField_a_of_type_Anqe.b) {
      getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    if (this.jdField_a_of_type_Afur != null) {
      this.jdField_a_of_type_Afur.e();
    }
    if (this.jdField_a_of_type_Anqe != null) {
      this.jdField_a_of_type_Anqe.d();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_Afur != null)
    {
      this.jdField_a_of_type_Afur.b(paramIntent);
      return;
    }
    setIntent(paramIntent);
    a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_Anqx.b();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_Anqx.a();
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
    if (this.jdField_a_of_type_Anqe != null) {
      this.jdField_a_of_type_Anqe.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    axqw.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Afur != null) {
      this.jdField_a_of_type_Afur.b();
    }
    if (this.jdField_a_of_type_Anqx != null) {
      this.jdField_a_of_type_Anqx.h();
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity
 * JD-Core Version:    0.7.0.1
 */