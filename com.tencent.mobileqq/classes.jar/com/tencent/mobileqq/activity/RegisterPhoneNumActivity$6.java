package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.register.QueryAccount;
import mqq.app.AppActivity;

class RegisterPhoneNumActivity$6
  implements DialogInterface.OnClickListener
{
  RegisterPhoneNumActivity$6(RegisterPhoneNumActivity paramRegisterPhoneNumActivity, AppActivity paramAppActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      RegisterPhoneNumActivity.access$102(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity.mLoginUserPrivateHelper.a(this.jdField_a_of_type_MqqAppAppActivity, false)) {
        RegisterPhoneNumActivity.access$000(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterPhoneNumActivity).b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity.6
 * JD-Core Version:    0.7.0.1
 */