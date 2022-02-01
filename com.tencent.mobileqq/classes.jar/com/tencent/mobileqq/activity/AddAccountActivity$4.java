package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class AddAccountActivity$4
  extends AccountObserver
{
  AddAccountActivity$4(AddAccountActivity paramAddAccountActivity) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_AddAccountActivity", 2, "onCheckQuickRegisterAccount|isSuccess= " + paramBoolean + ",code=" + paramInt);
    }
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(1);
      if ((paramBoolean) && (paramInt == 0))
      {
        paramArrayOfByte = new Intent();
        paramArrayOfByte.putExtra("key_register_binduin", this.a.app.getCurrentAccountUin());
        paramArrayOfByte.putExtra("key_register_from_quick_register", true);
        paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
        paramArrayOfByte.putExtra("not_need_verify_sms", true);
        RouteUtils.a(this.a, paramArrayOfByte, "/base/safe/registerByNickAndPwd");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      paramArrayOfByte = new Intent();
      paramArrayOfByte.putExtra("key_register_from", "fromAddAccount");
      RouteUtils.a(this.a, paramArrayOfByte, "/base/register/registerPhoneNumber");
    }
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    QLog.d("AddAccountActivity", 1, "onLoginFailed ret=" + paramInt1);
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      this.a.runOnUiThread(new AddAccountActivity.4.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("AddAccountActivity", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt1);
      }
      if ((paramString2 == null) || (paramString2.equals("")))
      {
        QQToast.a(this.a, 2131694457, 0).a();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (paramInt1 == 40)
      {
        LoginFailedHelper.a(this.a, this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString(), this.a.app);
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        Intent localIntent = new Intent(this.a, NotificationActivity.class);
        localIntent.putExtra("type", 8);
        localIntent.putExtra("msg", paramString2 + " " + paramString3);
        localIntent.putExtra("loginalias", paramString1);
        localIntent.putExtra("loginret", paramInt1);
        localIntent.putExtra("errorUrl", paramString3);
        localIntent.putExtra("expiredSig", paramArrayOfByte1);
        localIntent.putExtra("keyFromAddAccount", true);
        localIntent.putExtra("title", paramString4);
        if (ThirdPartyLoginBlockUtilImpl.a().a(paramArrayOfByte2) == 1)
        {
          localIntent.putExtra("uin", this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString());
          localIntent.putExtra("passwd", this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString());
          localIntent.putExtra("is_from_login", false);
          localIntent.putExtra("keyTipsScenesId", 1);
        }
        this.a.startActivity(localIntent);
        return;
      }
      if (paramInt1 == 2008)
      {
        DialogUtil.a(this.a, 230, HardCodeUtil.a(2131699899), HardCodeUtil.a(2131699900), "OK", null, new AddAccountActivity.4.2(this), null).show();
        QQToast.a(this.a, 2131693035, 0).a();
        return;
      }
      if (paramInt1 == 1)
      {
        paramString1 = this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        AddAccountActivity.a(this.a).a(this.a.app, this.a, paramString1, 2, paramString2, new AddAccountActivity.4.3(this));
        return;
      }
      DialogUtil.a(this.a, 230, HardCodeUtil.a(2131699903), paramString2, new AddAccountActivity.4.4(this), null).show();
    }
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("AddAccountActivity", 1, "onLoginSuccess");
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("AddAccountActivity", 1, "onLoginTimeout");
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      QQToast.a(this.a, 2131694457, 0).a();
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (!this.a.isFinishing()) {}
    try
    {
      this.a.dismissDialog(0);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.4
 * JD-Core Version:    0.7.0.1
 */