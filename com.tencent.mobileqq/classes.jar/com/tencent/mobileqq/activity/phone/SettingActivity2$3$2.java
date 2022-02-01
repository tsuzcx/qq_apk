package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class SettingActivity2$3$2
  implements Runnable
{
  SettingActivity2$3$2(SettingActivity2.3 param3) {}
  
  public void run()
  {
    this.a.this$0.mPhoneContactService.uploadPhoneContact();
    this.a.this$0.mPhoneContactService.setNeedUploadResultTip(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.3.2
 * JD-Core Version:    0.7.0.1
 */