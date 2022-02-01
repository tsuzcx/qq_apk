package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoyVideoSubChannelActivity$3
  implements Runnable
{
  ReadInJoyVideoSubChannelActivity$3(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, ReadInJoyHelper.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(ReadInJoyVideoSubChannelActivity.a(this.this$0)), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.a(this.this$0), null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity.3
 * JD-Core Version:    0.7.0.1
 */