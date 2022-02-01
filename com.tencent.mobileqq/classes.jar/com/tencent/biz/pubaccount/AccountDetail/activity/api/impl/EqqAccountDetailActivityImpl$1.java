package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EqqAccountDetailActivityImpl$1
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$1(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, String paramString, PaConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.jumpWebView(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString.contains(HardCodeUtil.a(2131704206)))) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.reportItemEvent(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */