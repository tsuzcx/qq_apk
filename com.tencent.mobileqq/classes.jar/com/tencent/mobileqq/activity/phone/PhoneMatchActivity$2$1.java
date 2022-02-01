package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class PhoneMatchActivity$2$1
  implements Runnable
{
  PhoneMatchActivity$2$1(PhoneMatchActivity.2 param2) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.a.this$0.app.getRuntimeService(IPhoneContactService.class, "");
    localIPhoneContactService.uploadOrUpdateContact();
    localIPhoneContactService.setNeedUploadResultTip(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity.2.1
 * JD-Core Version:    0.7.0.1
 */