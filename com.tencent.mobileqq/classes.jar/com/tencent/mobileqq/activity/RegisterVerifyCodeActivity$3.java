package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.VerifyCodeView;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;

class RegisterVerifyCodeActivity$3
  extends AccountObserver
{
  RegisterVerifyCodeActivity$3(RegisterVerifyCodeActivity paramRegisterVerifyCodeActivity) {}
  
  public void onRegisterCommitSmsCodeResp(boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp isSuccess=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(",code=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.closeDialog();
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = null;
    }
    AppRuntime localAppRuntime = RegisterVerifyCodeActivity.f(this.a);
    String str = Integer.toString(paramInt);
    if (TextUtils.isEmpty(this.a.inviteCode)) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    Object localObject2;
    if (paramArrayOfByte == null) {
      localObject2 = "";
    } else {
      localObject2 = paramArrayOfByte;
    }
    ReportController.a(localAppRuntime, "new_reg", "msg_page", "next_clk", "", 1, "", str, (String)localObject1, (String)localObject2, "", "", "", "", "");
    if ((paramBoolean) && (paramInt == 0))
    {
      if (!TextUtils.isEmpty(paramString4)) {
        RegisterVerifyCodeActivity.a(this.a, paramString4);
      }
      this.a.b();
      ReportController.a(RegisterVerifyCodeActivity.g(this.a), "dc00898", "", "", "0X800B609", "0X800B609", 0, 0, "", "", this.a.phoneNum, "");
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onRegisterCommitSmsCodeResp code=");
        paramArrayOfByte.append(paramInt);
        paramArrayOfByte.append(" ,uin=");
        paramArrayOfByte.append(paramString1);
        paramArrayOfByte.append(" ,nick=");
        paramArrayOfByte.append(paramString2);
        paramArrayOfByte.append(" ,faceUrl=");
        paramArrayOfByte.append(paramString3);
        QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, paramArrayOfByte.toString());
      }
      RegisterVerifyCodeActivity.h(this.a);
      return;
    }
    paramString1 = paramArrayOfByte;
    if (TextUtils.isEmpty(paramArrayOfByte)) {
      paramString1 = this.a.getString(2131914072);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp error=");
      paramString2.append(paramString1);
      QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, paramString2.toString());
    }
    RegisterVerifyCodeActivity.d(this.a).a();
    this.a.notifyToast(paramString1, 1);
  }
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.closeDialog();
    Object localObject = null;
    if (!paramBoolean)
    {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      localObject = paramArrayOfByte;
      if (TextUtils.isEmpty(paramArrayOfByte)) {
        localObject = this.a.getString(2131914072);
      }
      this.a.notifyToast((String)localObject, 1);
      return;
    }
    if (paramArrayOfByte != null) {}
    try
    {
      localObject = new String(paramArrayOfByte, "utf-8");
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp code = ");
        paramArrayOfByte.append(paramInt1);
        paramArrayOfByte.append(";strMsg = ");
        paramArrayOfByte.append((String)localObject);
        paramArrayOfByte.append(";nextChkTime =");
        paramArrayOfByte.append(paramInt2);
        paramArrayOfByte.append(";totalTimeOver =");
        paramArrayOfByte.append(paramInt3);
        QLog.d("RegisterVerifyCodeActivity", 2, paramArrayOfByte.toString());
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramInt3 = 60;
    if (paramInt1 == 0)
    {
      RegisterVerifyCodeActivity.a(this.a, 60);
    }
    else if (paramInt1 == 5)
    {
      if (paramInt2 <= 60) {
        paramInt2 = paramInt3;
      }
      RegisterVerifyCodeActivity.a(this.a, paramInt2);
    }
    paramArrayOfByte = this.a;
    RegisterVerifyCodeActivity.b(paramArrayOfByte, RegisterVerifyCodeActivity.e(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */