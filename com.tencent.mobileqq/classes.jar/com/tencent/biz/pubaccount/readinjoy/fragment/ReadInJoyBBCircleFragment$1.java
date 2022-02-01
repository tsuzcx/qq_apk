package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyBBCircleFragment$1
  implements Runnable
{
  ReadInJoyBBCircleFragment$1(ReadInJoyBBCircleFragment paramReadInJoyBBCircleFragment) {}
  
  public void run()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.b("entry_time", "" + ReadInJoyBBCircleFragment.a(this.this$0).a() / 1000L);
    localReportR5Builder.b("postset_time", "" + NetConnInfoCenter.getServerTime());
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X800978C", "0X800978C", 0, 0, "" + ReadInJoyBBCircleFragment.a(this.this$0).b() / 1000L, "", "", localReportR5Builder.a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment.1
 * JD-Core Version:    0.7.0.1
 */