package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;

class RegisterActivity$4
  implements DialogInterface.OnClickListener
{
  RegisterActivity$4(RegisterActivity paramRegisterActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131713268));
    localStringBuilder.append(HardCodeUtil.a(2131713289));
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(HardCodeUtil.a(2131713267));
    localStringBuilder.append(this.b);
    localStringBuilder.append(HardCodeUtil.a(2131713260));
    RegisterActivity.a(paramDialogInterface, localStringBuilder.toString());
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity);
    RegisterActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterActivity, 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.4
 * JD-Core Version:    0.7.0.1
 */