package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class AutoLoginHelper$1
  extends WtloginObserver
{
  AutoLoginHelper$1(AutoLoginHelper paramAutoLoginHelper) {}
  
  public void onGetStViaSMSVerifyLogin(String paramString, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("OnGetStViaSMSVerifyLogin  userAccount = ");
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" ret=");
      paramArrayOfByte.append(paramInt2);
      QLog.d("AutoLoginHelper", 2, paramArrayOfByte.toString());
      if (paramErrMsg != null)
      {
        paramString = new StringBuilder();
        paramString.append("OnGetStViaSMSVerifyLogin  errMsg = ");
        paramString.append(paramErrMsg.getMessage());
        QLog.d("AutoLoginHelper", 2, paramString.toString());
      }
    }
    if (paramInt2 == 0) {
      return;
    }
    this.a.h();
    if (AutoLoginHelper.a(this.a) != null)
    {
      paramString = new Intent(AutoLoginHelper.a(this.a), LoginActivity.class);
      paramString.putExtra("uin", AutoLoginHelper.a(this.a));
      paramString.putExtra("tab_index", 0);
      paramString.addFlags(131072);
      AutoLoginHelper.a(this.a).startActivity(paramString);
      AutoLoginHelper.a(this.a).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.1
 * JD-Core Version:    0.7.0.1
 */