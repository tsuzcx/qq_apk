package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AddContactsView$7
  implements Runnable
{
  AddContactsView$7(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.a.getManager(QQManagerFactory.CONTACT_MANAGER);
    ContactBindedActivity.a(this.this$0.a, 222, localPhoneContactManagerImp.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.7
 * JD-Core Version:    0.7.0.1
 */