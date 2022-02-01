package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class VerifyPhoneNumActivity$6
  extends ContactBindObserver
{
  VerifyPhoneNumActivity$6(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  protected void onReBindMblWTLogin(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VerifyPhoneNumActivity onReBindMblWTLogin isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("; resultOk = ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("VerifyPhoneNumActivity", 2, localStringBuilder.toString());
    }
    this.a.a();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        VerifyPhoneNumActivity.a(this.a, true);
        VerifyPhoneNumActivity.c(this.a);
        return;
      }
      VerifyPhoneNumActivity.c(this.a);
      return;
    }
    VerifyPhoneNumActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.6
 * JD-Core Version:    0.7.0.1
 */