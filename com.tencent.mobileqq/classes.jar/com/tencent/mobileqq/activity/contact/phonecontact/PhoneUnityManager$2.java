package com.tencent.mobileqq.activity.contact.phonecontact;

import ajnf;
import ajng;
import aohe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PhoneUnityManager$2
  implements Runnable
{
  public PhoneUnityManager$2(ajng paramajng) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    ajnf localajnf = this.this$0.a();
    ((aohe)this.this$0.a.a(34)).notifyUI(9, true, localajnf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */