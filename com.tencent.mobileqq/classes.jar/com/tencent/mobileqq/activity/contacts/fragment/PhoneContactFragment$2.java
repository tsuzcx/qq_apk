package com.tencent.mobileqq.activity.contacts.fragment;

import afdx;
import com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class PhoneContactFragment$2
  implements Runnable
{
  PhoneContactFragment$2(PhoneContactFragment paramPhoneContactFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContactFragment", 2, "reset data for ui");
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.this$0.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      if (this.this$0.jdField_a_of_type_Afdx == null)
      {
        this.this$0.jdField_a_of_type_Afdx = new afdx(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentWidgetXListView, 1, true, this.this$0);
        this.this$0.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.this$0.jdField_a_of_type_Afdx);
      }
      this.this$0.jdField_a_of_type_Afdx.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.this$0.jdField_a_of_type_Afdx.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment.2
 * JD-Core Version:    0.7.0.1
 */