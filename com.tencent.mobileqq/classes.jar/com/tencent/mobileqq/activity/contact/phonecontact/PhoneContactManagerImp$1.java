package com.tencent.mobileqq.activity.contact.phonecontact;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;

public class PhoneContactManagerImp$1
  implements Runnable
{
  PhoneContactManagerImp$1(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    PhoneContactManagerImp.a(this.this$0, this.this$0.a());
    PhoneContactManagerImp.a(this.this$0);
    this.this$0.f = this.this$0.a.getLong("key_contacts_switches", 0L);
    if (PhoneContactManagerImp.a(this.this$0) != null) {
      ContactSyncManager localContactSyncManager = (ContactSyncManager)PhoneContactManagerImp.a(this.this$0).getManager(41);
    }
    this.this$0.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.1
 * JD-Core Version:    0.7.0.1
 */