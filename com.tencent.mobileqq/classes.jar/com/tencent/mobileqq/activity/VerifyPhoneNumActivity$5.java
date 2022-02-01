package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class VerifyPhoneNumActivity$5
  extends WtloginObserver
{
  VerifyPhoneNumActivity$5(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void onGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("OnGetStViaSMSVerifyLogin  userAccount = ");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt2);
      QLog.d("VerifyPhoneNumActivity", 2, paramArrayOfByte.toString());
      if (paramErrMsg != null)
      {
        paramString = new StringBuilder();
        paramString.append("OnGetStViaSMSVerifyLogin  errMsg = ");
        paramString.append(paramErrMsg.getMessage());
        QLog.d("VerifyPhoneNumActivity", 2, paramString.toString());
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    VerifyPhoneNumActivity.a(this.a);
    VerifyPhoneNumActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.5
 * JD-Core Version:    0.7.0.1
 */