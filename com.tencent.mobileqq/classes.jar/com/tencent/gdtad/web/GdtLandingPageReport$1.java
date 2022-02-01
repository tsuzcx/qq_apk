package com.tencent.gdtad.web;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;

class GdtLandingPageReport$1
  implements Runnable
{
  GdtLandingPageReport$1(GdtLandingPageReport paramGdtLandingPageReport, String paramString, CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    localObject = GdtLandingPageReport.a((GdtLandingPageReport)localObject, GdtLandingPageReport.a((GdtLandingPageReport)localObject), GdtLandingPageReport.a(this.this$0, "GdtWebReportQQ_TRACE_ID"), this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" webviewInjectScript getScript ==");
    localStringBuilder.append((String)localObject);
    GdtLog.d("GdtLandingPageReport", localStringBuilder.toString());
    GdtLandingPageReport.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, (String)localObject, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport.1
 * JD-Core Version:    0.7.0.1
 */