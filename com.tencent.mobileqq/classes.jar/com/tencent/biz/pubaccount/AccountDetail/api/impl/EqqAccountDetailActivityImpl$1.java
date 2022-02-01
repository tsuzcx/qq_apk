package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class EqqAccountDetailActivityImpl$1
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$1(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, String paramString, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.jumpWebView(this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString.contains(HardCodeUtil.a(2131704297))))
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.reportItemEvent(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */