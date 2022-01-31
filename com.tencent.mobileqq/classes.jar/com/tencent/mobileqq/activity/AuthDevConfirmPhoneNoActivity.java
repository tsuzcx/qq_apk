package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import aqax;
import aqaz;
import aqbd;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class AuthDevConfirmPhoneNoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  
  private void a()
  {
    super.setContentView(2131560924);
    setTitle(2131692213);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377678));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377677));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377720));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363549));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363627));
    if ((QLog.isColorLevel()) && ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (this.jdField_b_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_b_of_type_AndroidWidgetButton == null)))
    {
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "one or more controls is null! ");
      return;
    }
    onCreateRightView();
    setRightButton(2131692184, this);
    Object localObject = (TextView)findViewById(2131368624);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_JavaLangString != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    }
    localObject = getString(2131692181);
    String str = getString(2131692215);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setText(str);
    this.jdField_b_of_type_AndroidWidgetButton.setClickable(true);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    try
    {
      aqbd.a().a(null, this.app.getCurrentAccountUin(), 6);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "verify page call back resultCode = " + paramInt2);
            }
            if (paramInt2 == -1)
            {
              if (paramIntent != null) {}
              for (paramIntent = new Intent(paramIntent);; paramIntent = new Intent())
              {
                paramIntent.putExtra("requestCode", paramInt1);
                setResult(-1, paramIntent);
                finish();
                return;
              }
            }
          } while (paramInt2 != 0);
          return;
        } while (paramIntent == null);
        localObject = paramIntent.getExtras();
      } while (localObject == null);
      paramInt2 = ((Bundle)localObject).getInt("resultState", 1);
      localObject = ((Bundle)localObject).getString("resultMobileMask");
    } while (paramInt2 == 1);
    if (paramInt2 == 2) {
      aqax.a().a(aqax.d);
    }
    for (;;)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.putExtra("requestCode", paramInt1);
      paramIntent.putExtra("phone_num", (String)localObject);
      setResult(-1, paramIntent);
      finish();
      return;
      if (paramInt2 == 3)
      {
        aqax.a().a(aqax.c);
        aqax.a().a(0L);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    finish();
    overridePendingTransition(0, 2130772001);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363549: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click confirm mobile phone button! ");
      }
      break;
    }
    try
    {
      aqbd.a().a(null, this.app.getCurrentAccountUin(), 7);
      label71:
      paramView = new Intent(this, AuthDevVerifyCodeActivity.class);
      paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
      paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      paramView.putExtra("mobile_type", 0);
      startActivityForResult(paramView, 1001);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click modify mobile phone button! ");
      }
      try
      {
        aqbd.a().a(null, this.app.getCurrentAccountUin(), 8);
        label157:
        if (this.app != null) {
          this.app.sendWirelessMeibaoReq(1);
        }
        if ((!TextUtils.isEmpty(this.e)) && (this.e.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "subaccount enter webview mUin=" + this.d + " mMainAccount=" + this.f);
          }
          if ((TextUtils.isEmpty(this.d)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
          }
          aqaz.a(this, this.f, this.d, aqaz.c, 1002, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mainaccount enter webview mUin=" + this.d);
        }
        if ((TextUtils.isEmpty(this.d)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
        }
        aqaz.a(this, this.d, this.d, aqaz.c, 1002, null);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "onClick right cancel button! ");
        }
        finish();
        overridePendingTransition(0, 2130772001);
        return;
      }
      catch (Exception paramView)
      {
        break label157;
      }
    }
    catch (Exception paramView)
    {
      break label71;
    }
  }
  
  public void onCreate(Bundle paramBundle)
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
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphUp : " + this.jdField_a_of_type_JavaLangString);
      QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphDown : " + this.jdField_b_of_type_JavaLangString);
    }
    super.onCreate(paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevConfirmPhoneNoActivity
 * JD-Core Version:    0.7.0.1
 */