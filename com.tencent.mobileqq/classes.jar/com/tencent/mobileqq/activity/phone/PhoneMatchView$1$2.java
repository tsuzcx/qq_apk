package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class PhoneMatchView$1$2
  implements Runnable
{
  PhoneMatchView$1$2(PhoneMatchView.1 param1) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.a.this$0.a.getRuntimeService(IPhoneContactService.class, "");
    localIPhoneContactService.uploadOrUpdateContact();
    localIPhoneContactService.setNeedUploadResultTip(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView.1.2
 * JD-Core Version:    0.7.0.1
 */