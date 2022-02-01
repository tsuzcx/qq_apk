package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$PublicAccountMoreInfoObserver
  extends PublicAccountObserver
{
  private AccountDetailGroupListContainer b;
  
  public AccountDetailGroupListContainer$PublicAccountMoreInfoObserver(AccountDetailGroupListContainer paramAccountDetailGroupListContainer1, AccountDetailGroupListContainer paramAccountDetailGroupListContainer2)
  {
    this.b = paramAccountDetailGroupListContainer2;
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void onSetRecvMsgState(boolean paramBoolean, SetRecvMsgStateRsp paramSetRecvMsgStateRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailGroupListContainer", 2, "onGetRecvMsgState isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (paramSetRecvMsgStateRsp.result == 0))
    {
      AccountDetailGroupListContainer.b(this.a, this.a.jdField_a_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("setting_status_" + this.a.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin + "_" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_Int).commit();
      }
    }
  }
  
  public void onUpdateFunctionFlag(boolean paramBoolean, PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramBoolean) && (paramPaConfigInfo != null)) {
      if (paramPaConfigInfo.e != 3) {}
    }
    while (this.b == null) {
      for (;;)
      {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_JavaLangString);
        return;
        if ((paramPaConfigInfo.e == 6) && (this.b != null)) {
          AccountDetailGroupListContainer.a(this.b, paramPaConfigInfo);
        }
      }
    }
    AccountDetailGroupListContainer.a(this.b, 2131695222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.PublicAccountMoreInfoObserver
 * JD-Core Version:    0.7.0.1
 */