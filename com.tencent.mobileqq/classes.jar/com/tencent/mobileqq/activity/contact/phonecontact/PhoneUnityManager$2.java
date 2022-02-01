package com.tencent.mobileqq.activity.contact.phonecontact;

import ajcn;
import ajco;
import aodi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class PhoneUnityManager$2
  implements Runnable
{
  public PhoneUnityManager$2(ajco paramajco) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    ajcn localajcn = this.this$0.a();
    ((aodi)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER)).notifyUI(9, true, localajcn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */