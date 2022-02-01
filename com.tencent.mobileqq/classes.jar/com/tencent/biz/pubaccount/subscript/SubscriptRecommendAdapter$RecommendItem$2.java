package com.tencent.biz.pubaccount.subscript;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubscriptRecommendAdapter$RecommendItem$2
  implements View.OnClickListener
{
  SubscriptRecommendAdapter$RecommendItem$2(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.b.m.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005731", "0X8005731", 0, 0, "", "", "", "");
    ReportController.b(this.b.m.d, "CliOper", "", "", "0X800642E", "0X800642E", 0, 0, String.valueOf(this.b.l.a), "", "", "");
    if ((this.b.l != null) && (!TextUtils.isEmpty(String.valueOf(this.b.l.a)))) {
      SubscriptRecommendAdapter.RecommendItem.a(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem.2
 * JD-Core Version:    0.7.0.1
 */