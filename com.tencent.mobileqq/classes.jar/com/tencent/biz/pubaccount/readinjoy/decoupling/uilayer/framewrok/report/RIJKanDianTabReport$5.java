package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class RIJKanDianTabReport$5
  implements Runnable
{
  RIJKanDianTabReport$5(long paramLong) {}
  
  public void run()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((QQAppInterface)ReadInJoyUtils.a(), "CliOper", "", "", "0X80066F7", "0X80066F7", 1, 1, Long.toString(this.a / 1000L), "", "", RIJTransMergeKanDianReport.b(), false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.4tab", 2, "report ReadinjoyTabFrame use time: " + this.a / 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport.5
 * JD-Core Version:    0.7.0.1
 */