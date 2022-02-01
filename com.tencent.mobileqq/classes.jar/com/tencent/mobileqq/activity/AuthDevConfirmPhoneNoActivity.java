package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.DevlockPhoneStatus;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevConfirmPhoneNoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private String jdField_a_of_type_JavaLangString = null;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
  private Button jdField_b_of_type_AndroidWidgetButton = null;
  private TextView jdField_b_of_type_AndroidWidgetTextView = null;
  private String jdField_b_of_type_JavaLangString = null;
  private TextView jdField_c_of_type_AndroidWidgetTextView = null;
  private String jdField_c_of_type_JavaLangString = null;
  private String d;
  private String e;
  private String f;
  
  private void a()
  {
    super.setContentView(2131561050);
    setTitle(2131692018);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378528));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378527));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378570));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363897));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363971));
    if ((QLog.isColorLevel()) && ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_b_of_type_AndroidWidgetButton == null)))
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "one or more controls is null! ");
      return;
    }
    onCreateRightView();
    setRightButton(2131691996, this);
    Object localObject = (TextView)findViewById(2131369202);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    localObject = this.jdField_b_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    localObject = this.jdField_c_of_type_JavaLangString;
    if (localObject != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    localObject = getString(2131691993);
    String str = getString(2131692020);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 6);
      return;
    }
    catch (Exception localException) {}
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1002) {
        return;
      }
      if (paramIntent != null)
      {
        localObject = paramIntent.getExtras();
        if (localObject == null) {
          return;
        }
        paramInt2 = ((Bundle)localObject).getInt("resultState", 1);
        localObject = ((Bundle)localObject).getString("resultMobileMask");
        if (paramInt2 != 1)
        {
          if (paramInt2 == 2)
          {
            DevlockPhoneStatus.a().a(DevlockPhoneStatus.e);
          }
          else if (paramInt2 == 3)
          {
            DevlockPhoneStatus.a().a(DevlockPhoneStatus.d);
            DevlockPhoneStatus.a().a(0L);
          }
          paramIntent = new Intent(paramIntent);
          paramIntent.putExtra("requestCode", paramInt1);
          paramIntent.putExtra("phone_num", (String)localObject);
          setResult(-1, paramIntent);
          finish();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("verify page call back resultCode = ");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt2 == -1)
      {
        if (paramIntent != null) {
          paramIntent = new Intent(paramIntent);
        } else {
          paramIntent = new Intent();
        }
        paramIntent.putExtra("requestCode", paramInt1);
        setResult(-1, paramIntent);
        finish();
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772015);
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363897)
    {
      if (i != 2131363971)
      {
        if (i != 2131369233) {
          break label401;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "onClick right cancel button! ");
        }
        finish();
        overridePendingTransition(0, 2130772015);
        break label401;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click modify mobile phone button! ");
      }
    }
    try
    {
      EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 8);
      if (this.app != null) {
        this.app.sendWirelessMeibaoReq(1);
      }
      if ((!TextUtils.isEmpty(this.e)) && (this.e.equals("subaccount")))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("subaccount enter webview mUin=");
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(" mMainAccount=");
          ((StringBuilder)localObject).append(this.f);
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((TextUtils.isEmpty(this.d)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
        }
        EquipLockWebEntrance.a(this, this.f, this.d, EquipLockWebEntrance.c, 1002, null);
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mainaccount enter webview mUin=");
          ((StringBuilder)localObject).append(this.d);
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
        }
        if ((TextUtils.isEmpty(this.d)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
        }
        localObject = this.d;
        EquipLockWebEntrance.a(this, (String)localObject, (String)localObject, EquipLockWebEntrance.c, 1002, null);
        break label401;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click confirm mobile phone button! ");
        }
      }
    }
    catch (Exception localException1)
    {
      try
      {
        EquipmentLockImpl.a().a(null, this.app.getCurrentAccountUin(), 7);
        label344:
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        ((Intent)localObject).putExtra("mobile_type", 0);
        RouteUtils.a(this, (Intent)localObject, "/base/login/authDevVerifyCode", 1001);
        label401:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localException1 = localException1;
      }
      catch (Exception localException2)
      {
        break label344;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("ParaTextUp");
    this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("ParaTextDown");
    this.jdField_c_of_type_JavaLangString = ((Bundle)localObject).getString("PhoneNO");
    this.d = ((Bundle)localObject).getString("uin");
    this.e = ((Bundle)localObject).getString("from_where");
    this.f = ((Bundle)localObject).getString("mainaccount");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)((Bundle)localObject).get("DevlockInfo"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("on Create strParaGraphUp : ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("on Create strParaGraphDown : ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, ((StringBuilder)localObject).toString());
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevConfirmPhoneNoActivity
 * JD-Core Version:    0.7.0.1
 */