package com.tencent.biz.pubaccount.AccountDetail.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

class AccountDetailGroupListContainer$17
  implements CompoundButton.OnCheckedChangeListener
{
  AccountDetailGroupListContainer$17(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, PaConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.c)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.c = true;
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 1) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
    }
    for (;;)
    {
      AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.a);
      break;
      if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 2)
      {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f == 3)
      {
        if (!paramBoolean) {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.17
 * JD-Core Version:    0.7.0.1
 */