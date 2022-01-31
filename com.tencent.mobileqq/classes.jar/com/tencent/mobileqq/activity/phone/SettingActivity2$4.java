package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class SettingActivity2$4
  implements Runnable
{
  SettingActivity2$4(SettingActivity2 paramSettingActivity2) {}
  
  public void run()
  {
    if (this.this$0.a == 6)
    {
      this.this$0.finish();
      return;
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.app.getManager(11);
    ContactBindedActivity.a(this.this$0.app, 222, localPhoneContactManagerImp.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.4
 * JD-Core Version:    0.7.0.1
 */