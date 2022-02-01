package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
    paramArrayOfByte.putExtra("key_register_from", 2);
    RouteUtils.a(this.a, paramArrayOfByte, "/base/register/registerPhoneNumber");
  }
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onLoginFailed ret=");
    ((StringBuilder)localObject1).append(paramInt1);
    QLog.d("AddAccountActivity", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.a.mBaseUI.m();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      LoginForbiddenDialogReporter.a(this.a.getAppRuntime(), (String)localObject1, 3, String.valueOf(paramInt1), paramInt1, paramString2);
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onLoginFailed errorMsg = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" ret=");
      ((StringBuilder)localObject2).append(paramInt1);
      QLog.d("AddAccountActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      if (paramInt1 == 40)
      {
        localObject2 = this.a;
        if (LoginFailedHelper.a((Context)localObject2, (String)localObject1, ((AddAccountActivity)localObject2).app, paramArrayOfByte2, new AddAccountActivity.4.2(this))) {
          return;
        }
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("type", 8);
        ((Intent)localObject2).putExtra("msg", paramString2);
        ((Intent)localObject2).putExtra("loginalias", paramString1);
        ((Intent)localObject2).putExtra("loginret", paramInt1);
        ((Intent)localObject2).putExtra("errorUrl", paramString3);
        ((Intent)localObject2).putExtra("expiredSig", paramArrayOfByte1);
        ((Intent)localObject2).putExtra("keyFromAddAccount", true);
        ((Intent)localObject2).putExtra("tlverror", paramArrayOfByte2);
        ((Intent)localObject2).putExtra("title", paramString4);
        ((Intent)localObject2).putExtra("errortitle", paramString4);
        if (LoginFailedHelper.a(paramArrayOfByte2) == 1)
        {
          ((Intent)localObject2).putExtra("uin", (String)localObject1);
          ((Intent)localObject2).putExtra("passwd", this.a.mBaseUI.n());
          ((Intent)localObject2).putExtra("is_from_login", false);
          ((Intent)localObject2).putExtra("keyTipsScenesId", 1);
        }
        RouteUtils.a(this.a, (Intent)localObject2, "/base/notification");
        return;
      }
      if (paramInt1 == 2008)
      {
        DialogUtil.a(this.a, 230, HardCodeUtil.a(2131898087), HardCodeUtil.a(2131898088), "OK", null, new AddAccountActivity.4.3(this), null).show();
        QQToast.makeText(this.a, 2131890109, 0).show();
        return;
      }
      if (paramInt1 == 1)
      {
        AddAccountActivity.access$500(this.a).a(this.a.app, this.a, (String)localObject1, 2, paramString2, new AddAccountActivity.4.4(this));
        return;
      }
      DialogUtil.a(this.a, 230, HardCodeUtil.a(2131898090), paramString2, new AddAccountActivity.4.5(this), null).show();
      return;
    }
    QQToast.makeText(this.a, 2131892102, 0).show();
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
    QQToast.makeText(this.a, 2131892102, 0).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddAccountActivity.4
 * JD-Core Version:    0.7.0.1
 */