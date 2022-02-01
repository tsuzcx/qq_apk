package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class VerifyPhoneNumActivity$6
  extends ContactBindObserver
{
  VerifyPhoneNumActivity$6(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void onReBindMblWTLogin(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 2, "VerifyPhoneNumActivity onReBindMblWTLogin isSuccess = " + paramBoolean1 + "; resultOk = " + paramBoolean2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.6
 * JD-Core Version:    0.7.0.1
 */