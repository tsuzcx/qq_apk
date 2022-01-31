package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import jrj;
import jrk;
import jrm;

public class CallbackWaitingActivity
  extends BaseActivity
{
  private static String f = "CallbackWaitingActivity";
  int jdField_a_of_type_Int = 1001;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jrm(this);
  AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new jrj(this, Looper.getMainLooper());
  public BaseCallbackUI a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  public int b;
  public String b;
  int c;
  public String c;
  String d;
  public String e;
  
  public CallbackWaitingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "user close!");
    }
    if (this.jdField_a_of_type_Int == 1001)
    {
      paramView = new Intent();
      paramView.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
      paramView.setAction("tencent.av.v2q.CancelCallBack");
      paramView.putExtra("fromPhone", this.jdField_c_of_type_JavaLangString);
      paramView.putExtra("toPhone", this.jdField_b_of_type_JavaLangString);
      paramView.putExtra("fromUin", this.e);
      paramView.putExtra("uinType", this.jdField_b_of_type_Int);
      paramView.putExtra("toUin", this.d);
      paramView.putExtra("callBackId", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramView);
      finish();
      return;
    }
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      finish();
      return;
    }
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.requestWindowFeature(1);
    super.doOnCreate(paramBundle);
    setContentView(2130969264);
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "onCreate");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getAppRuntime());
    if ((Build.VERSION.SDK_INT >= 19) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      super.getWindow().addFlags(67108864);
    }
    if (ImmersiveUtils.a()) {
      ImmersiveUtils.a(getWindow(), true);
    }
    paramBundle = getIntent();
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("type", 1001);
    if (this.jdField_a_of_type_Int == 1001)
    {
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("toPhone");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("fromPhone");
    }
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("callbackId");
    this.d = paramBundle.getStringExtra("toUin");
    this.e = paramBundle.getStringExtra("fromUin");
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("uinType", 0);
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI = new BaseCallbackUI(this, 1001);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("android.intent.action.PHONE_STATE"));
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.jdField_a_of_type_AndroidOsHandler.postDelayed(new jrk(this), 30000L);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "onDestroy");
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_c_of_type_Int);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "onPause");
    }
    AudioUtil.a();
    if (this.jdField_a_of_type_Int == 1001) {
      finish();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d(f, 2, "onResume");
    }
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(2);
    AudioUtil.a(2131230733, 1, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.CallbackWaitingActivity
 * JD-Core Version:    0.7.0.1
 */