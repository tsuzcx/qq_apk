package com.tencent.mobileqq.app.utils;

import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

class SmsContent$1
  implements QQPermissionCallback
{
  SmsContent$1(SmsContent paramSmsContent, AppActivity paramAppActivity, SMSBodyObserver paramSMSBodyObserver) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, deny");
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    SmsContent.a(this.c, this.a, this.b);
    if (QLog.isColorLevel()) {
      QLog.d("sms.content", 2, "checkPermission, grant");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.SmsContent.1
 * JD-Core Version:    0.7.0.1
 */