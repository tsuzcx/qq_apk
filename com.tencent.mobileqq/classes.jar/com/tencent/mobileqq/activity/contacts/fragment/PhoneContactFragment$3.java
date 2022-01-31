package com.tencent.mobileqq.activity.contacts.fragment;

import android.os.Handler;
import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.qphone.base.util.QLog;

class PhoneContactFragment$3
  implements Runnable
{
  PhoneContactFragment$3(PhoneContactFragment paramPhoneContactFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContactFragment", 2, "reset data");
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.removeCallbacks(PhoneContactFragment.a(this.this$0));
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(PhoneContactFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment.3
 * JD-Core Version:    0.7.0.1
 */