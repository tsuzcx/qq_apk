package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoyDailyFragment$4
  implements Runnable
{
  ReadInJoyDailyFragment$4(ReadInJoyDailyFragment paramReadInJoyDailyFragment, String paramString1, String paramString2) {}
  
  public void run()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.b("folder_status", this.a);
    localReportR5Builder.b("entry_time", "" + ReadInJoyDailyFragment.a().a() / 1000L);
    localReportR5Builder.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    localReportR5Builder.b("version", VideoReporter.a);
    localReportR5Builder.b("os", "1");
    localReportR5Builder.b("cmd", ReadInJoyHelper.i());
    localReportR5Builder.b("channel_id", KandianDailyReportUtils.b());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, this.b, this.b, 0, 0, "" + ReadInJoyDailyFragment.a().b() / 1000L, "", "", localReportR5Builder.a(), false);
    QLog.d("ReadInJoyDailyFragment", 2, "reportDuringTime time is" + ReadInJoyDailyFragment.a().b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment.4
 * JD-Core Version:    0.7.0.1
 */