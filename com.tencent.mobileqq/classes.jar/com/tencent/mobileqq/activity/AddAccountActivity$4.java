package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
import com.tencent.mobileqq.app.QQAppInterface;
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
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onCheckQuickRegisterAccount|isSuccess= ");
      paramArrayOfByte.append(paramBoolean);
      paramArrayOfByte.append(",code=");
      paramArrayOfByte.append(paramInt);
      QLog.d("Login_Optimize_AddAccountActivity", 2, paramArrayOfByte.toString());
    }
    if (!this.a.isFinishing()) {
      try
      {
        this.a.dismissDialog(1);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
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
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("key_register_from", "fromAddAccount");
    RouteUtils.a(this.a, paramArrayOfByte, "/base/register/registerPhoneNumber");
  }
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoginFailed ret=");
    localStringBuilder.append(paramInt1);
    QLog.d("AddAccountActivity", 1, localStringBuilder.toString());
    if ((this.a.mAutoTextAccount != null) && (this.a.mAutoTextAccount.getText() != null)) {
      LoginForbiddenDialogReporter.a(this.a.getAppRuntime(), this.a.mAutoTextAccount.getText().toString(), 3, String.valueOf(paramInt1), paramInt1, paramString2);
    }
    if (!this.a.isFinishing()) {
      try
      {
        this.a.dismissDialog(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    this.a.runOnUiThread(new AddAccountActivity.4.1(this));
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoginFailed errorMsg = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" ret=");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("AddAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      if (paramInt1 == 40)
      {
        localObject = this.a;
        if (LoginFailedHelper.a((Context)localObject, ((AddAccountActivity)localObject).mAutoTextAccount.getText().toString(), this.a.app, paramArrayOfByte2, new AddAccountActivity.4.2(this))) {
          return;
        }
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("type", 8);
        ((Intent)localObject).putExtra("msg", paramString2);
        ((Intent)localObject).putExtra("loginalias", paramString1);
        ((Intent)localObject).putExtra("loginret", paramInt1);
        ((Intent)localObject).putExtra("errorUrl", paramString3);
        ((Intent)localObject).putExtra("expiredSig", paramArrayOfByte1);
        ((Intent)localObject).putExtra("keyFromAddAccount", true);
        ((Intent)localObject).putExtra("tlverror", paramArrayOfByte2);
        ((Intent)localObject).putExtra("title", paramString4);
        ((Intent)localObject).putExtra("errortitle", paramString4);
        if (LoginFailedHelper.a(paramArrayOfByte2) == 1)
        {
          ((Intent)localObject).putExtra("uin", this.a.mAutoTextAccount.getText().toString());
          ((Intent)localObject).putExtra("passwd", this.a.mPwdEdit.getText().toString());
          ((Intent)localObject).putExtra("is_from_login", false);
          ((Intent)localObject).putExtra("keyTipsScenesId", 1);
        }
        RouteUtils.a(this.a, (Intent)localObject, "/base/notification");
        return;
      }
      if (paramInt1 == 2008)
      {
        DialogUtil.a(this.a, 230, HardCodeUtil.a(2131700040), HardCodeUtil.a(2131700041), "OK", null, new AddAccountActivity.4.3(this), null).show();
        QQToast.a(this.a, 2131692995, 0).a();
        return;
      }
      if (paramInt1 == 1)
      {
        paramString1 = this.a.mAutoTextAccount.getText().toString();
        AddAccountActivity.access$400(this.a).a(this.a.app, this.a, paramString1, 2, paramString2, new AddAccountActivity.4.4(this));
        return;
      }
      DialogUtil.a(this.a, 230, HardCodeUtil.a(2131700044), paramString2, new AddAccountActivity.4.5(this), null).show();
      return;
    }
    QQToast.a(this.a, 2131694422, 0).a();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    QLog.d("AddAccountActivity", 1, "onLoginSuccess");
  }
  
  protected void onLoginTimeout(String paramString)
  {
    QLog.d("AddAccountActivity", 1, "onLoginTimeout");
    if (!this.a.isFinishing()) {
      try
      {
        this.a.dismissDialog(0);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    QQToast.a(this.a, 2131694422, 0).a();
  }
  
  protected void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (!this.a.isFinishing()) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.4
 * JD-Core Version:    0.7.0.1
 */