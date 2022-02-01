package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$7$1
  implements Runnable
{
  PermisionPrivacyActivity$7$1(PermisionPrivacyActivity.7 param7, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity$7.this$0.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "updateIntimateRelationshipFriendCount number:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity$7.this$0.c.setRightText(this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity$7.this$0.getString(2131699126, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPermisionPrivacyActivity$7.this$0.c.setRightText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.7.1
 * JD-Core Version:    0.7.0.1
 */