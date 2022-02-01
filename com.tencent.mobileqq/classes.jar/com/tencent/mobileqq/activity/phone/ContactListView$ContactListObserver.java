package com.tencent.mobileqq.activity.phone;

import android.widget.TextView;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ContactListView$ContactListObserver
  extends ContactBindObserver
{
  private ContactListView$ContactListObserver(ContactListView paramContactListView) {}
  
  protected void onHideContact(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHideContact isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ContactListView", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_Int == 5)) {
      this.a.j();
    }
  }
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
    if (!paramBoolean1)
    {
      this.a.i();
      this.a.g();
      if (((i == 0) || (i == 7)) && ((this.a.jdField_a_of_type_Int != 2) || (!(this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardShareCardOption))) && (this.a.b == 0)) {
        this.a.a(2131718218, 3000L);
      }
    }
    else
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      if (this.a.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.isAutoUploadContacts()) {
        this.a.a(2131718766, 0L, false);
      }
    }
  }
  
  protected void onQueryContactList(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.a.i();
      ContactListView.a(this.a, true);
      if ((paramInt & 0x1) == 0) {
        this.a.g();
      }
    }
    else
    {
      this.a.g();
    }
    if (this.a.jdField_a_of_type_Int == 6) {
      this.a.f();
    }
  }
  
  protected void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) || (!NetworkUtil.isNetSupport(this.a.getContext())))
    {
      this.a.i();
      this.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.ContactListView.ContactListObserver
 * JD-Core Version:    0.7.0.1
 */