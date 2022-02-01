package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class RegisterQQNumberActivity$1
  extends WtloginObserver
{
  RegisterQQNumberActivity$1(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void onGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("OnGetStViaSMSVerifyLogin  userAccount = ");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt2);
      QLog.d("RegisterQQNumberActivity", 2, paramArrayOfByte.toString());
      if (paramErrMsg != null)
      {
        paramString = new StringBuilder();
        paramString.append("OnGetStViaSMSVerifyLogin  errMsg = ");
        paramString.append(paramErrMsg.getMessage());
        QLog.d("RegisterQQNumberActivity", 2, paramString.toString());
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    RegisterQQNumberActivity.a(this.a);
    paramString = new Intent(this.a, LoginActivity.class);
    paramString.putExtra("uin", RegisterQQNumberActivity.b(this.a));
    paramString.putExtra("tab_index", 0);
    paramString.addFlags(131072);
    this.a.startActivity(paramString);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity.1
 * JD-Core Version:    0.7.0.1
 */