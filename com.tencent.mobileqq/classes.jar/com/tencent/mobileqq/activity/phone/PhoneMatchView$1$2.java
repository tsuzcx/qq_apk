package com.tencent.mobileqq.activity.phone;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class PhoneMatchView$1$2
  implements Runnable
{
  PhoneMatchView$1$2(PhoneMatchView.1 param1) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.this$0.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    localPhoneContactManagerImp.j();
    localPhoneContactManagerImp.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView.1.2
 * JD-Core Version:    0.7.0.1
 */