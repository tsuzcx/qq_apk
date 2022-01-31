package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class AddContactsView$6
  implements Runnable
{
  AddContactsView$6(AddContactsView paramAddContactsView) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.this$0.a.getManager(11);
    ContactBindedActivity.a(this.this$0.a, 222, localPhoneContactManagerImp.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.6
 * JD-Core Version:    0.7.0.1
 */