package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.SharedPreferences;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$27
  implements Handler.Callback
{
  AccountDetailGroupListContainer$27(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMessage.what)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (QLog.isColorLevel()) {
          QLog.i("AccountDetailGroupListContainer", 2, "refresh recent list, from_handle");
        }
        bool1 = bool2;
      } while (!this.a.b);
      bool1 = bool2;
    } while (this.a.jdField_a_of_type_AndroidViewView == null);
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
    int i;
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      i = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getInt("setting_result_" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -10000);
      this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getInt("setting_status_" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0) {
        break;
      }
      bool1 = bool2;
      if (this.a.jdField_a_of_type_Int <= -1) {
        break;
      }
      AccountDetailGroupListContainer.b(this.a, this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_AndroidViewView.setOnClickListener(new AccountDetailGroupListContainer.27.1(this));
      return true;
      i = -10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.27
 * JD-Core Version:    0.7.0.1
 */