package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class PhoneMatchActivity$2$1
  implements Runnable
{
  PhoneMatchActivity$2$1(PhoneMatchActivity.2 param2) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.this$0.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    localPhoneContactManagerImp.j();
    localPhoneContactManagerImp.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity.2.1
 * JD-Core Version:    0.7.0.1
 */