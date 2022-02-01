package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;

class UserLoginLogic$4
  implements DialogInterface.OnCancelListener
{
  UserLoginLogic$4(UserLoginLogic paramUserLoginLogic) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.d();
    DoraemonUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic.4
 * JD-Core Version:    0.7.0.1
 */