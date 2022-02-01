package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

class BindNumberActivity$6
  implements DialogInterface.OnClickListener
{
  BindNumberActivity$6(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, "new user guild confirm unbind");
    }
    this.a.a("dc00898", "0X8009F16", 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.a.jdField_a_of_type_JavaLangString, this.a.c, 0, this.a.jdField_a_of_type_Boolean, this.a.b);
    this.a.a(2131719050, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberActivity.6
 * JD-Core Version:    0.7.0.1
 */