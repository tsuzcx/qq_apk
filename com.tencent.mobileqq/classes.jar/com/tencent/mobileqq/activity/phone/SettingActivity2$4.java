package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;

class SettingActivity2$4
  implements Runnable
{
  SettingActivity2$4(SettingActivity2 paramSettingActivity2) {}
  
  public void run()
  {
    if (this.this$0.h == 6)
    {
      this.this$0.finish();
      return;
    }
    IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.this$0.app.getRuntimeService(IPhoneContactService.class, "");
    ContactBindedActivity.a(this.this$0.app, 222, localIPhoneContactService.generateRandomList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.4
 * JD-Core Version:    0.7.0.1
 */