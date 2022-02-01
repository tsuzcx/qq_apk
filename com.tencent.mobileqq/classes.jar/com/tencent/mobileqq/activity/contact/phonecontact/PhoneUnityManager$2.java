package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.qphone.base.util.QLog;

class PhoneUnityManager$2
  implements Runnable
{
  PhoneUnityManager$2(PhoneUnityManager paramPhoneUnityManager) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MobileUnityManager", 4, "load phone local data");
    }
    PhoneUnityBannerData localPhoneUnityBannerData = this.this$0.a();
    ((SecSvcHandler)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER)).notifyUI(9, true, localPhoneUnityBannerData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.2
 * JD-Core Version:    0.7.0.1
 */