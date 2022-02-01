package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.SharedPreferences;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$27
  implements Handler.Callback
{
  AccountDetailGroupListContainer$27(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1000) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AccountDetailGroupListContainer", 2, "refresh recent list, from_handle");
    }
    if ((this.a.b) && (this.a.jdField_a_of_type_AndroidViewView != null))
    {
      paramMessage = this.a;
      paramMessage.jdField_a_of_type_AndroidContentSharedPreferences = paramMessage.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("public_account_detail_setting_status", 0);
      paramMessage = this.a.jdField_a_of_type_AndroidContentSharedPreferences;
      int i = -10000;
      if (paramMessage != null)
      {
        paramMessage = this.a.jdField_a_of_type_AndroidContentSharedPreferences;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setting_result_");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        i = paramMessage.getInt(((StringBuilder)localObject).toString(), -10000);
        paramMessage = this.a;
        localObject = paramMessage.jdField_a_of_type_AndroidContentSharedPreferences;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setting_status_");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
        localStringBuilder.append("_");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramMessage.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -1);
      }
      if ((i == 0) && (this.a.jdField_a_of_type_Int > -1))
      {
        paramMessage = this.a;
        AccountDetailGroupListContainer.b(paramMessage, paramMessage.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_AndroidViewView.setOnClickListener(new AccountDetailGroupListContainer.27.1(this));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.27
 * JD-Core Version:    0.7.0.1
 */