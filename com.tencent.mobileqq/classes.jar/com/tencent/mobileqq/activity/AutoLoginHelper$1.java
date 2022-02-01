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
      QLog.d("AutoLoginHelper", 2, "OnGetStViaSMSVerifyLogin  userAccount = " + paramString + " ret=" + paramInt2);
      if (paramErrMsg != null) {
        QLog.d("AutoLoginHelper", 2, "OnGetStViaSMSVerifyLogin  errMsg = " + paramErrMsg.getMessage());
      }
    }
    if (paramInt2 == 0) {}
    do
    {
      return;
      AutoLoginHelper.a(this.a);
    } while (AutoLoginHelper.a(this.a) == null);
    paramString = new Intent(AutoLoginHelper.a(this.a), LoginActivity.class);
    paramString.putExtra("uin", AutoLoginHelper.a(this.a));
    paramString.putExtra("tab_index", 0);
    paramString.addFlags(131072);
    AutoLoginHelper.a(this.a).startActivity(paramString);
    AutoLoginHelper.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.1
 * JD-Core Version:    0.7.0.1
 */