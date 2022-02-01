package com.tencent.mobileqq.activity.contact.phonecontact;

import aiho;
import aihp;
import anat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PhoneUnityManager$2
  implements Runnable
{
  public PhoneUnityManager$2(aihp paramaihp) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    aiho localaiho = this.this$0.a();
    ((anat)this.this$0.a.getBusinessHandler(34)).notifyUI(9, true, localaiho);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */