package com.tencent.mobileqq.activity.contacts.phone;

import aiqi;
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneContactStatusCheckView.b(PhoneContactFragment.c(this.this$0));
    }
    if (this.this$0.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      if (this.this$0.jdField_a_of_type_Aiqi == null)
      {
        this.this$0.jdField_a_of_type_Aiqi = new aiqi(PhoneContactFragment.a(this.this$0), PhoneContactFragment.d(this.this$0), this.this$0.jdField_a_of_type_ComTencentWidgetXListView, 1, true, this.this$0);
        this.this$0.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.this$0.jdField_a_of_type_Aiqi);
      }
      this.this$0.jdField_a_of_type_Aiqi.a(PhoneContactFragment.e(this.this$0));
      this.this$0.jdField_a_of_type_Aiqi.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment.2
 * JD-Core Version:    0.7.0.1
 */