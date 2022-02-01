package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;

class LoginInfoActivity$6
  extends LoginVerifyObserver
{
  LoginInfoActivity$6(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void a(FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse)
  {
    LoginInfoActivity.access$1802(this.a, paramSecureCheckResponse);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.a, paramString2, 0).a();
    QLog.e("LoginInfoActivity.AccDevSec", 1, "cmd : " + paramString1 + " request failed  code : " + paramInt + " message : " + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */