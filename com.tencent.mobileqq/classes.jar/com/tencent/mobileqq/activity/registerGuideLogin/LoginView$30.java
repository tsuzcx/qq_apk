package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginErrorInfo;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.mobileqq.loginregister.LoginSharedPreUtils;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.loginwelcome.GatewayUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

class LoginView$30
  extends AccountObserver
{
  LoginView$30(LoginView paramLoginView) {}
  
  public void onCheckQuickRegisterAccount(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super.onCheckQuickRegisterAccount(paramBoolean, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_LoginActivity.LoginView", 2, "onCheckQuickRegisterAccount|isSuccess= " + paramBoolean + ",code=" + paramInt);
    }
    LoginView.a(this.a, 4);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramArrayOfByte = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, RegisterByNicknameAndPwdActivity.class);
      paramArrayOfByte.putExtra("key_register_binduin", this.a.jdField_a_of_type_MqqAppAppRuntime.getAccount());
      paramArrayOfByte.putExtra("key_register_from_quick_register", true);
      paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
      paramArrayOfByte.putExtra("not_need_verify_sms", true);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, RegisterPhoneNumActivity.class);
    paramArrayOfByte.putExtra("key_register_from", 3);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity(paramArrayOfByte);
  }
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    QLog.d("login", 1, "LoginActivity onLoginFailed ret=" + paramInt1);
    LoginView.a(this.a, 0);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new LoginView.30.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onLoginFailed errorMsg = " + paramString2 + " ret=" + paramInt1);
    }
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
    {
      List localList = MobileQQ.sMobileQQ.getAllAccounts();
      if ((localList != null) && (localList.size() > 0))
      {
        String str = this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        int i = 0;
        if (i < localList.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)localList.get(i);
          if (localSimpleAccount == null) {}
          while (!str.equals(LoginUtils.a(localSimpleAccount.getUin())))
          {
            i += 1;
            break;
          }
          LoginSharedPreUtils.a(BaseApplication.getContext(), this.a.jdField_a_of_type_JavaLangString, true);
        }
      }
    }
    if (paramInt1 == 1)
    {
      LoginView.a(this.a).a(this.a.jdField_a_of_type_MqqAppAppRuntime, this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString(), 1, paramString2, new LoginView.30.2(this));
      return;
    }
    if ((paramString2 == null) || (paramString2.equals("")))
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694457, 0).a();
      return;
    }
    paramString1 = new LoginErrorInfo(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramString4, this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString(), this.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString(), LoginView.h(this.a));
    LoginView.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.a.jdField_a_of_type_MqqAppAppRuntime, paramString1);
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("login", 1, "LoginActivity onLoginSuccess");
    if (LoginView.g(this.a))
    {
      ReportController.a(this.a.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
      ReportController.a(this.a.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 1, 0, "", "", "", "");
    }
    GatewayUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.a.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public void onLoginTimeout(String paramString)
  {
    QLog.d("login", 1, "LoginActivity onLoginTimeout");
    LoginView.a(this.a, 0);
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
    {
      paramString = MobileQQ.sMobileQQ.getAllAccounts();
      if ((paramString != null) && (paramString.size() > 0))
      {
        String str = this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        int i = 0;
        if (i < paramString.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)paramString.get(i);
          if (localSimpleAccount == null) {}
          while (!str.equals(LoginUtils.a(localSimpleAccount.getUin())))
          {
            i += 1;
            break;
          }
          LoginSharedPreUtils.a(BaseApplication.getContext(), this.a.jdField_a_of_type_JavaLangString, true);
        }
      }
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694457, 0).a();
  }
  
  public void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    LoginView.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.30
 * JD-Core Version:    0.7.0.1
 */