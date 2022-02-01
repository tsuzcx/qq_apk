package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
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
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp isSuccess=" + paramBoolean + ",code=" + paramInt);
    }
    if (this.a.isFinishing()) {}
    label234:
    label241:
    do
    {
      return;
      this.a.closeDialog();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        AppRuntime localAppRuntime = RegisterVerifyCodeActivity.a(this.a);
        String str2 = Integer.toString(paramInt);
        if (TextUtils.isEmpty(this.a.inviteCode))
        {
          str1 = "2";
          if (paramArrayOfByte != null) {
            break label234;
          }
          localObject = "";
          ReportController.a(localAppRuntime, "new_reg", "msg_page", "next_clk", "", 1, "", str2, str1, (String)localObject, "", "", "", "", "");
          if ((paramBoolean) && (paramInt == 0)) {
            break label241;
          }
          paramString1 = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            paramString1 = this.a.getString(2131716956);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterCommitSmsCodeResp error=" + paramString1);
          }
          this.a.notifyToast(paramString1, 1);
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
          continue;
          String str1 = "1";
          continue;
          Object localObject = paramArrayOfByte;
        }
        if (!TextUtils.isEmpty(paramString1)) {
          RegisterVerifyCodeActivity.a(this.a, paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          RegisterVerifyCodeActivity.b(this.a, paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          RegisterVerifyCodeActivity.c(this.a, paramString3);
        }
        if (!TextUtils.isEmpty(paramString4)) {
          RegisterVerifyCodeActivity.d(this.a, paramString4);
        }
        this.a.a();
        ReportController.a(RegisterVerifyCodeActivity.b(this.a), "dc00898", "", "", "0X800B609", "0X800B609", 0, 0, "", "", this.a.phoneNum, "");
      }
    } while (!QLog.isColorLevel());
    QLog.d("Login_Optimize_RegisterVerifyCodeActivity", 2, "onRegisterCommitSmsCodeResp code=" + paramInt + " ,uin=" + paramString1 + " ,nick=" + paramString2 + " ,faceUrl=" + paramString3);
  }
  
  public void onRegisterSendResendSmsreqResp(boolean paramBoolean, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp");
    }
    if (this.a.isFinishing()) {
      return;
    }
    this.a.closeDialog();
    if (!paramBoolean) {
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        localObject = paramArrayOfByte;
        if (TextUtils.isEmpty(paramArrayOfByte)) {
          localObject = this.a.getString(2131716956);
        }
        this.a.notifyToast((String)localObject, 1);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      }
    }
    if (paramArrayOfByte != null) {}
    try
    {
      localObject = new String(paramArrayOfByte, "utf-8");
      if (QLog.isColorLevel()) {
        QLog.d("RegisterVerifyCodeActivity", 2, "RegisterVerifyCodeActivity onRegisterSendResendSmsreqResp code = " + paramInt1 + ";strMsg = " + (String)localObject + ";next_chk_time =" + paramInt2 + ";total_time_over =" + paramInt3);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        if (paramInt1 == 5)
        {
          paramInt1 = paramInt2;
          if (paramInt2 <= 60) {
            paramInt1 = 60;
          }
          RegisterVerifyCodeActivity.a(this.a, paramInt1);
        }
      }
    }
    if (paramInt1 == 0)
    {
      RegisterVerifyCodeActivity.a(this.a, 60);
      RegisterVerifyCodeActivity.a(this.a, RegisterVerifyCodeActivity.c(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterVerifyCodeActivity.3
 * JD-Core Version:    0.7.0.1
 */