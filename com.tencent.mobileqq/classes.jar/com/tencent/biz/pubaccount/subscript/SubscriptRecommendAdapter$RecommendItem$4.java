package com.tencent.biz.pubaccount.subscript;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.activity.PublicAccountSearchActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscriptRecommendAdapter$RecommendItem$4
  implements View.OnClickListener
{
  SubscriptRecommendAdapter$RecommendItem$4(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter) {}
  
  public void onClick(View paramView)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.b.m.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B6F", "0X8005B6F", 0, 0, "", "", "", "", false);
    ReportController.b(this.b.m.d, "CliOper", "", "", "0X800642D", "0X800642D", 0, 0, "", "", "", "");
    PublicAccountSearchActivity.a(this.b.m.a, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b.m.d, this.b.m.a), null, null);
    SubscriptRecommendController.b(this.b.m.d, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem.4
 * JD-Core Version:    0.7.0.1
 */