package com.tencent.biz.pubaccount.accountdetail.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.widget.Switch;

class AccountDetailGroupListContainer$17
  implements CompoundButton.OnCheckedChangeListener
{
  AccountDetailGroupListContainer$17(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, Switch paramSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.c)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.c = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.f == 1) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo, paramBoolean);
    } else if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.f == 2)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo, paramBoolean);
      }
    }
    else if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.f == 3)
    {
      if (!paramBoolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo, paramBoolean);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo, paramBoolean);
    }
    AccountDetailGroupListContainer.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer, this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.17
 * JD-Core Version:    0.7.0.1
 */