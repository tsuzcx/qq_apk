package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EqqAccountDetailActivityImpl$9
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$9(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, boolean paramBoolean1, String paramString, boolean paramBoolean2, PaConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.showCallConfirm(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.b);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.reportItemEvent(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.9
 * JD-Core Version:    0.7.0.1
 */