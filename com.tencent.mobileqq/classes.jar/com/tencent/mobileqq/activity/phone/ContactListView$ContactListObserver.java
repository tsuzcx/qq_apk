package com.tencent.mobileqq.activity.phone;

import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ContactListView$ContactListObserver
  extends ContactBindObserver
{
  private ContactListView$ContactListObserver(ContactListView paramContactListView) {}
  
  public void onHideContact(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactListView", 2, "onHideContact isSuccess=" + paramBoolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_Int == 5)) {
      this.a.j();
    }
  }
  
  public void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d();
    if (!paramBoolean1)
    {
      this.a.i();
      this.a.g();
      if (((i == 0) || (i == 7)) && ((this.a.jdField_a_of_type_Int != 2) || (!(this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption))) && (this.a.b == 0)) {
        this.a.a(2131718550, 3000L);
      }
    }
    do
    {
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    } while (!this.a.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.f());
    this.a.a(2131719050, 0L, false);
  }
  
  public void onQueryContactList(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.i();
      ContactListView.a(this.a, true);
      if ((paramInt & 0x1) == 0) {
        this.a.g();
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Int == 6) {
        this.a.f();
      }
      return;
      this.a.g();
    }
  }
  
  public void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!NetworkUtil.d(this.a.getContext())))
    {
      this.a.i();
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.ContactListObserver
 * JD-Core Version:    0.7.0.1
 */