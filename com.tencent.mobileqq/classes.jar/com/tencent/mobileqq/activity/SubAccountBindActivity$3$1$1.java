package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.qphone.base.remote.SimpleAccount;

class SubAccountBindActivity$3$1$1
  implements Runnable
{
  SubAccountBindActivity$3$1$1(SubAccountBindActivity.3.1 param1) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.e();
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.b(this.a.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.getString(2131719626));
    Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a, SubLoginActivity.class);
    localIntent.putExtra("subuin", this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    localIntent.putExtra("fromWhere", this.a.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.b);
    this.a.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3.1.1
 * JD-Core Version:    0.7.0.1
 */