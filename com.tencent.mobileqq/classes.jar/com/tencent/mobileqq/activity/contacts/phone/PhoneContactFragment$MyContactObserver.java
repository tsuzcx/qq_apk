package com.tencent.mobileqq.activity.contacts.phone;

import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class PhoneContactFragment$MyContactObserver
  extends ContactBindObserver
{
  private PhoneContactFragment$MyContactObserver(PhoneContactFragment paramPhoneContactFragment) {}
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("refreshResult [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.a.d)
    {
      if (PhoneContactFragment.a(this.a) != null) {
        PhoneContactFragment.b(this.a).a(this.a.b(), paramBoolean, null);
      }
      if (paramBoolean) {
        this.a.c();
      }
      this.a.d = false;
    }
  }
  
  public void onHideContact(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("onHideContact [%s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.a.c();
  }
  
  public void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, String.format("onQueryBindState [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    a(paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment.MyContactObserver
 * JD-Core Version:    0.7.0.1
 */