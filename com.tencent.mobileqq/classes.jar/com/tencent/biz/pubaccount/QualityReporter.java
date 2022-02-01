package com.tencent.biz.pubaccount;

import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoReq;

public class QualityReporter
{
  public static void a(ReadinjoyVideoReportData paramReadinjoyVideoReportData)
  {
    ThreadManager.excute(new QualityReporter.1(paramReadinjoyVideoReportData), 16, null, true);
  }
  
  private static void b(cc_sso_report_svr.ReportInfoReq paramReportInfoReq)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), PublicAccountServletImpl.class);
    localNewIntent.putExtra("cmd", "FeedsContentCenter.QualityReport");
    localNewIntent.putExtra("data", paramReportInfoReq.toByteArray());
    localNewIntent.setObserver(new QualityReporter.ResponseObserver(localNewIntent));
    ReadInJoyUtils.a().startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.QualityReporter
 * JD-Core Version:    0.7.0.1
 */