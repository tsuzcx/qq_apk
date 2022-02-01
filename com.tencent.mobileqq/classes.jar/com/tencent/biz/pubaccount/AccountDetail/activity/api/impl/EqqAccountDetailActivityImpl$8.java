package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EqqAccountDetailActivityImpl$8
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$8(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, PaConfigAttr.PaConfigInfo paramPaConfigInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.g)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f))) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.TAG, 2, "buildMapItemForEqq no lat or lng");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl, QQMapActivity.class);
      localIntent.putExtra("lat", this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.g);
      localIntent.putExtra("lon", this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.f);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localIntent.putExtra("loc", this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.app, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin, "", "", "");
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.reportItemEvent(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.8
 * JD-Core Version:    0.7.0.1
 */