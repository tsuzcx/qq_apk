package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$PublicAccountMoreInfoObserverCallback
  extends IPublicAccountObserver.OnCallback
{
  private AccountDetailGroupListContainer b;
  
  public AccountDetailGroupListContainer$PublicAccountMoreInfoObserverCallback(AccountDetailGroupListContainer paramAccountDetailGroupListContainer1, AccountDetailGroupListContainer paramAccountDetailGroupListContainer2)
  {
    this.b = paramAccountDetailGroupListContainer2;
  }
  
  public void onDestroy()
  {
    this.b = null;
  }
  
  public void onSetRecvMsgState(boolean paramBoolean, Object paramObject)
  {
    paramObject = (SetRecvMsgStateRsp)paramObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRecvMsgState isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AccountDetailGroupListContainer", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramObject.result == 0))
    {
      paramObject = this.a;
      AccountDetailGroupListContainer.b(paramObject, paramObject.jdField_a_of_type_Int);
      if (this.a.jdField_a_of_type_AndroidContentSharedPreferences != null)
      {
        paramObject = this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setting_status_");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin);
        localStringBuilder.append("_");
        localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramObject.putInt(localStringBuilder.toString(), this.a.jdField_a_of_type_Int).commit();
      }
    }
  }
  
  public void onUpdateFunctionFlag(boolean paramBoolean, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramBoolean) && (paramPaConfigInfo != null))
    {
      if ((paramPaConfigInfo.e != 3) && (paramPaConfigInfo.e == 6))
      {
        AccountDetailGroupListContainer localAccountDetailGroupListContainer = this.b;
        if (localAccountDetailGroupListContainer != null) {
          AccountDetailGroupListContainer.a(localAccountDetailGroupListContainer, paramPaConfigInfo);
        }
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    paramPaConfigInfo = this.b;
    if (paramPaConfigInfo != null) {
      AccountDetailGroupListContainer.a(paramPaConfigInfo, 2131695217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.PublicAccountMoreInfoObserverCallback
 * JD-Core Version:    0.7.0.1
 */