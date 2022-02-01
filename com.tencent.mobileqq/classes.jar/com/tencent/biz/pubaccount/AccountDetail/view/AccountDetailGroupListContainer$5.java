package com.tencent.biz.pubaccount.AccountDetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailGroupListContainer$5
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$5(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, PaConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer);
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.5
 * JD-Core Version:    0.7.0.1
 */