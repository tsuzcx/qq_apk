package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;

class LoginInfoActivity$6
  extends LoginVerifyObserver
{
  LoginInfoActivity$6(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void checkSecureResponse(FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse)
  {
    LoginInfoActivity.access$1802(this.a, paramSecureCheckResponse);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QQToast.a(this.a, paramString2, 0).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd : ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" request failed  code : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" message : ");
    localStringBuilder.append(paramString2);
    QLog.e("LoginInfoActivity.AccDevSec", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */