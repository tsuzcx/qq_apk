package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class PhoneContactStatusCheckView$3
  implements Runnable
{
  PhoneContactStatusCheckView$3(PhoneContactStatusCheckView paramPhoneContactStatusCheckView, IPhoneContactService paramIPhoneContactService) {}
  
  public void run()
  {
    IPhoneContactService localIPhoneContactService = this.a;
    if (localIPhoneContactService != null)
    {
      localIPhoneContactService.uploadOrUpdateContact();
      this.a.setNeedUploadResultTip(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView.3
 * JD-Core Version:    0.7.0.1
 */