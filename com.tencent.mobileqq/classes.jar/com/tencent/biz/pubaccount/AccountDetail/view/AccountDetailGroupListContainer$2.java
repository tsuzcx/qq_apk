package com.tencent.biz.pubaccount.AccountDetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailGroupListContainer$2
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$2(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, String paramString, PaConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    AccountDetailGroupListContainer.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_JavaLangString);
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.2
 * JD-Core Version:    0.7.0.1
 */