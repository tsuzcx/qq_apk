package com.tencent.gdtad.statistics;

import android.text.TextUtils;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.ThreadManager;

public class GdtReporter
{
  public static final int REPORT_DEEP_LINK_SUCCESS = 137;
  public static final int REPORT_OPEN_MAIN_PAGE = 138;
  
  @Deprecated
  public static void doCgiReport(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new GdtCgiReportRunnable(paramString), 2, null, false);
    GdtLog.b("GDT_CGI_REPORT", paramString);
  }
  
  public static void doExposeCgiReport(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    GdtADFlyingStreamingReportHelper.a().a(1020008L);
    GdtCgiReportRunnable localGdtCgiReportRunnable = new GdtCgiReportRunnable(paramString);
    localGdtCgiReportRunnable.a(new GdtReporter.1());
    ThreadManager.post(localGdtCgiReportRunnable, 2, null, false);
    GdtLog.b("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReporter
 * JD-Core Version:    0.7.0.1
 */