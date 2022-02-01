package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoyChannelWaterFallViewController$2
  implements Runnable
{
  ReadInJoyChannelWaterFallViewController$2(ReadInJoyChannelWaterFallViewController paramReadInJoyChannelWaterFallViewController) {}
  
  public void run()
  {
    if (ReadInJoyChannelWaterFallViewController.a(this.this$0) == 40677)
    {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, ReadInJoyHelper.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(ReadInJoyChannelWaterFallViewController.a(this.this$0)), false);
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, ReadInJoyHelper.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(ReadInJoyChannelWaterFallViewController.a(this.this$0)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.2
 * JD-Core Version:    0.7.0.1
 */