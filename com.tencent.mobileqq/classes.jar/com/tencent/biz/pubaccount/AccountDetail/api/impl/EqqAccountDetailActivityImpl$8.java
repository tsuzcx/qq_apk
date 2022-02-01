package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class EqqAccountDetailActivityImpl$8
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$8(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.g)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.f)))
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl, QQMapActivity.class);
      paramView.putExtra("lat", this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.g);
      paramView.putExtra("lon", this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.f);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramView.putExtra("loc", this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin, "", "", "");
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.reportItemEvent(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.TAG, 2, "buildMapItemForEqq no lat or lng");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.8
 * JD-Core Version:    0.7.0.1
 */