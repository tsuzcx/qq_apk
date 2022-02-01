package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class DevlockQuickLoginActivity$3
  extends WtloginObserver
{
  DevlockQuickLoginActivity$3(DevlockQuickLoginActivity paramDevlockQuickLoginActivity) {}
  
  public void onCloseCode(String paramString, byte[] paramArrayOfByte1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("OnCloseCode userAccount=");
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append(" ret=");
      paramArrayOfByte1.append(paramInt);
      paramArrayOfByte1.append(" time=");
      paramArrayOfByte1.append(paramLong);
      QLog.d("DevlockQuickLoginActivity", 2, paramArrayOfByte1.toString());
      if (paramArrayOfByte2 != null) {
        try
        {
          paramString = new String(paramArrayOfByte2, "utf-8");
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("OnCloseCode errMsg=");
          paramArrayOfByte1.append(paramString);
          QLog.d("DevlockQuickLoginActivity", 2, paramArrayOfByte1.toString());
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
    this.a.c();
    if (DevlockQuickLoginActivity.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      QQToast.makeText(this.a.getApplicationContext(), 2, 2131889005, 0).show(DevlockQuickLoginActivity.b(this.a));
      DevlockQuickLoginActivity.c(this.a);
      DevlockQuickLoginActivity.a(this.a, 0, 2130772018);
      return;
    }
    if (paramInt == 21)
    {
      paramString = this.a.getString(2131889002);
      paramArrayOfByte1 = this.a.getString(2131916870);
      this.a.a(null, paramString, paramArrayOfByte1, new DevlockQuickLoginActivity.3.1(this));
      return;
    }
    paramString = DevlockQuickLoginActivity.a(this.a, 2131889003);
    QQToast.makeText(this.a.getApplicationContext(), 1, paramString, 0).show(DevlockQuickLoginActivity.e(this.a));
  }
  
  public void onException(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnException e=");
      localStringBuilder.append(paramString);
      QLog.d("DevlockQuickLoginActivity", 2, localStringBuilder.toString());
    }
    this.a.c();
    QQToast.makeText(DevlockQuickLoginActivity.k(this.a), 1, this.a.getString(2131889004), 0).show(DevlockQuickLoginActivity.j(this.a));
  }
  
  public void onVerifyCode(String paramString, byte[] paramArrayOfByte1, long paramLong, ArrayList<String> paramArrayList, byte[] paramArrayOfByte2, int paramInt, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("OnVerifyCode userAccount=");
      paramArrayOfByte1.append(paramString);
      paramArrayOfByte1.append(" ret=");
      paramArrayOfByte1.append(paramInt);
      QLog.d("DevlockQuickLoginActivity", 2, paramArrayOfByte1.toString());
    }
    if (DevlockQuickLoginActivity.f(this.a))
    {
      this.a.c();
      return;
    }
    if (paramInt == 0)
    {
      this.a.b();
      return;
    }
    this.a.c();
    if (paramInt == 21)
    {
      paramString = this.a.getString(2131889002);
      paramArrayOfByte1 = this.a.getString(2131916870);
      this.a.a(null, paramString, paramArrayOfByte1, new DevlockQuickLoginActivity.3.2(this));
      return;
    }
    paramString = this.a.getString(2131889003);
    QQToast.makeText(DevlockQuickLoginActivity.i(this.a), 1, paramString, 0).show(DevlockQuickLoginActivity.h(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockQuickLoginActivity.3
 * JD-Core Version:    0.7.0.1
 */