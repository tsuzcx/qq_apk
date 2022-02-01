package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EqqAccountDetailActivityImpl$14
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$14(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, PaConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.selectedState = this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.d;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.showMessageSettingActionSheet(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.selectedState);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.14
 * JD-Core Version:    0.7.0.1
 */