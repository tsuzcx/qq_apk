package com.tencent.biz.pubaccount.subscript;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscriptRecommendAdapter$RecommendItem$4
  implements View.OnClickListener
{
  SubscriptRecommendAdapter$RecommendItem$4(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter) {}
  
  public void onClick(View paramView)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B6F", "0X8005B6F", 0, 0, "", "", "", "", false);
    ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800642D", "0X800642D", 0, 0, "", "", "", "");
    PublicAccountSearchActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_AndroidAppActivity), null, null);
    SubscriptRecommendController.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter$RecommendItem.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem.4
 * JD-Core Version:    0.7.0.1
 */