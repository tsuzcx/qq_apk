package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.readinjoy.ReadInJoyHelper;

final class RIJFrameworkReportManager$3
  implements Runnable
{
  RIJFrameworkReportManager$3(int paramInt) {}
  
  public void run()
  {
    if (this.a == 40677) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, ReadInJoyHelper.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(this.a), false);
    }
    for (;;)
    {
      if (this.a == 56) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", VideoReporter.a(this.a, null), false);
      }
      return;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, ReadInJoyHelper.a("default_feeds_proteus_offline_bid"), "", "", RIJTransMergeKanDianReport.b(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager.3
 * JD-Core Version:    0.7.0.1
 */