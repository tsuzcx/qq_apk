package com.tencent.gdtad.web;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;

class GdtLandingPageReport$1
  implements Runnable
{
  GdtLandingPageReport$1(GdtLandingPageReport paramGdtLandingPageReport, String paramString, CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    String str = GdtLandingPageReport.a(this.this$0, GdtLandingPageReport.a(this.this$0), GdtLandingPageReport.a(this.this$0, "GdtWebReportQQ_TRACE_ID"), this.jdField_a_of_type_JavaLangString);
    GdtLog.d("GdtLandingPageReport", " webviewInjectScript getScript ==" + str);
    GdtLandingPageReport.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, str, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport.1
 * JD-Core Version:    0.7.0.1
 */