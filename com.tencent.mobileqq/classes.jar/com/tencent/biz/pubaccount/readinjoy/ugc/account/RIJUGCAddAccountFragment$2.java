package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

final class RIJUGCAddAccountFragment$2
  implements Runnable
{
  public void run()
  {
    try
    {
      String str = RIJTransMergeKanDianReport.a().a("uin", ReadInJoyUtils.a()).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X800AF12", "0X800AF12", 0, 0, "", "", "", str, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(RIJUGCAddAccountFragment.b(), 1, "[deliverTipsExposureReport] error, e = " + localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment.2
 * JD-Core Version:    0.7.0.1
 */