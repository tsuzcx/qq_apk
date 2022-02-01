package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.LoginErrorInfo;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.mobileqq.loginregister.LoginSharedPreUtils;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.loginwelcome.GatewayUtil;
import com.tencent.mobileqq.statistics.ReportController;
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
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onCheckQuickRegisterAccount|isSuccess= ");
      paramArrayOfByte.append(paramBoolean);
      paramArrayOfByte.append(",code=");
      paramArrayOfByte.append(paramInt);
      QLog.d("Login_Optimize_LoginActivity.LoginView", 2, paramArrayOfByte.toString());
    }
    this.a.b(4);
    if ((paramBoolean) && (paramInt == 0))
    {
      paramArrayOfByte = new Intent(this.a.b, RegisterByNicknameAndPwdActivity.class);
      paramArrayOfByte.putExtra("key_register_binduin", this.a.a.getAccount());
      paramArrayOfByte.putExtra("key_register_from_quick_register", true);
      paramArrayOfByte.putExtra("key_register_is_phone_num_registered", true);
      paramArrayOfByte.putExtra("not_need_verify_sms", true);
      this.a.b.startActivity(paramArrayOfByte);
      return;
    }
    paramArrayOfByte = new Intent(this.a.b, RegisterPhoneNumActivity.class);
    paramArrayOfByte.putExtra("key_register_from", 1);
    this.a.b.startActivity(paramArrayOfByte);
  }
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LoginActivity onLoginFailed ret=");
    ((StringBuilder)localObject).append(paramInt1);
    QLog.d("login", 1, ((StringBuilder)localObject).toString());
    this.a.b(0);
    this.a.b.runOnUiThread(new LoginView.30.1(this));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoginFailed errorMsg = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" ret=");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.a.d))
    {
      localObject = MobileQQ.sMobileQQ.getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        String str = this.a.h();
        int i = 0;
        while (i < ((List)localObject).size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)((List)localObject).get(i);
          if ((localSimpleAccount != null) && (str.equals(LoginUtils.a(localSimpleAccount.getUin()))))
          {
            LoginSharedPreUtils.a(BaseApplication.getContext(), this.a.d, true);
            break;
          }
          i += 1;
        }
      }
    }
    localObject = this.a.h();
    LoginForbiddenDialogReporter.a(this.a.a, (String)localObject, 1, String.valueOf(paramInt1), paramInt1, paramString2);
    if (paramInt1 == 1)
    {
      LoginView.G(this.a).a(this.a.a, this.a.b, (String)localObject, 1, paramString2, new LoginView.30.2(this));
      return;
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      paramString1 = new LoginErrorInfo(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramString4, this.a.h(), this.a.c(), LoginView.t(this.a));
      this.a.C.a(this.a.b, this.a.a, paramString1);
      return;
    }
    QQToast.makeText(this.a.b, 2131892102, 0).show();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("login", 1, "LoginActivity onLoginSuccess");
    if (this.a.z)
    {
      ReportController.a(this.a.a, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
      ReportController.a(this.a.a, "dc00898", "", "", "0X8007365", "0X8007365", 1, 0, "", "", "", "");
    }
    GatewayUtil.a(this.a.b, this.a.a);
  }
  
  protected void onLoginTimeout(String paramString)
  {
    QLog.d("login", 1, "LoginActivity onLoginTimeout");
    this.a.b(0);
    if (!TextUtils.isEmpty(this.a.d))
    {
      paramString = MobileQQ.sMobileQQ.getAllAccounts();
      if ((paramString != null) && (paramString.size() > 0))
      {
        String str = this.a.h();
        int i = 0;
        while (i < paramString.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)paramString.get(i);
          if ((localSimpleAccount != null) && (str.equals(LoginUtils.a(localSimpleAccount.getUin()))))
          {
            LoginSharedPreUtils.a(BaseApplication.getContext(), this.a.d, true);
            break;
          }
          i += 1;
        }
      }
    }
    QQToast.makeText(this.a.b, 2131892102, 0).show();
  }
  
  protected void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    this.a.b(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.30
 * JD-Core Version:    0.7.0.1
 */