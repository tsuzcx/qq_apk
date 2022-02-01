package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadinjoySubscriptManagerActivity$SubscribeAdapter$2
  implements View.OnClickListener
{
  ReadinjoySubscriptManagerActivity$SubscribeAdapter$2(ReadinjoySubscriptManagerActivity.SubscribeAdapter paramSubscribeAdapter, ReadinjoySubscriptManagerActivity.SubscribeFeedData paramSubscribeFeedData) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter.a, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeFeedData));
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeFeedData), "0X80078A8", "0X80078A8", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.SubscribeAdapter.2
 * JD-Core Version:    0.7.0.1
 */