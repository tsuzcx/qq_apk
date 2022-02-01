package com.tencent.mobileqq.activity.contact.phonecontact;

import com.tencent.mobileqq.phonecontact.ContactBindObserver2;
import com.tencent.qphone.base.util.QLog;

class PhoneContactManagerImp$22
  extends ContactBindObserver2
{
  PhoneContactManagerImp$22(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onQueryShowBindPhonePage result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (paramBoolean)
    {
      paramBoolean = PhoneContactManagerImp.b(this.a, PhoneContactManagerImp.g(this.a));
      PhoneContactManagerImp.c(this.a, paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("onSetShowBindPhonePageResult result=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.22
 * JD-Core Version:    0.7.0.1
 */