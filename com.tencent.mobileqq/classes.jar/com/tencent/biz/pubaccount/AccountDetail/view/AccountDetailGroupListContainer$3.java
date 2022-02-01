package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;

class AccountDetailGroupListContainer$3
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$3(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, String paramString, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    AccountDetailGroupListContainer.c(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_JavaLangString);
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "Clk_msg");
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.3
 * JD-Core Version:    0.7.0.1
 */