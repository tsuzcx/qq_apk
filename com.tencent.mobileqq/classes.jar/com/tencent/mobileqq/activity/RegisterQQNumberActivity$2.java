package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.observer.AccountObserver;

class RegisterQQNumberActivity$2
  extends AccountObserver
{
  RegisterQQNumberActivity$2(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  protected void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, String paramString4)
  {
    super.onLoginFailed(paramString1, paramString2, paramString3, paramInt1, paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramString4);
    if (QLog.isDevelopLevel()) {
      QLog.d("RegisterQQNumberActivity", 4, String.format(Locale.getDefault(), "onLoginFailed, ret: %s, uin: %s, msg: %s, alias: %s", new Object[] { Integer.valueOf(paramInt1), RegisterQQNumberActivity.a(this.a), paramString2, paramString1 }));
    }
    RegisterQQNumberActivity.a(this.a);
    paramString1 = new Intent(this.a, LoginActivity.class);
    paramString1.putExtra("uin", RegisterQQNumberActivity.a(this.a));
    paramString1.putExtra("tab_index", 0);
    paramString1.addFlags(131072);
    this.a.startActivity(paramString1);
    this.a.finish();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    super.onLoginSuccess(paramString1, paramString2, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginSuccess ");
    }
  }
  
  protected void onLoginTimeout(String paramString)
  {
    super.onLoginTimeout(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onLoginTimeout ");
    }
    RegisterQQNumberActivity.a(this.a);
    this.a.handler.post(new RegisterQQNumberActivity.2.1(this));
  }
  
  protected void onUserCancel(String paramString)
  {
    super.onUserCancel(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "AccountObserver ,onUserCancel ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterQQNumberActivity.2
 * JD-Core Version:    0.7.0.1
 */