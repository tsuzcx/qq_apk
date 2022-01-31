package com.tencent.mobileqq.app;

import amoa;
import android.content.SharedPreferences;

public class PhoneContactManagerImp$1
  implements Runnable
{
  PhoneContactManagerImp$1(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    PhoneContactManagerImp.a(this.this$0, this.this$0.a());
    PhoneContactManagerImp.a(this.this$0);
    this.this$0.g = this.this$0.a.getLong("key_contacts_switches", 0L);
    if (PhoneContactManagerImp.a(this.this$0) != null) {
      amoa localamoa = (amoa)PhoneContactManagerImp.a(this.this$0).getManager(41);
    }
    this.this$0.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.1
 * JD-Core Version:    0.7.0.1
 */