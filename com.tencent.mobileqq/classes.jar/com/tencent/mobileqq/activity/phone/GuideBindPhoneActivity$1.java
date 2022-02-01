package com.tencent.mobileqq.activity.phone;

import com.tencent.qphone.base.util.QLog;

class GuideBindPhoneActivity$1
  implements Runnable
{
  GuideBindPhoneActivity$1(GuideBindPhoneActivity paramGuideBindPhoneActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GuideBindPhoneActivity", 2, "have read phone contact permission");
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity.1
 * JD-Core Version:    0.7.0.1
 */