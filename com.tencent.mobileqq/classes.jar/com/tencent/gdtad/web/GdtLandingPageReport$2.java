package com.tencent.gdtad.web;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;

class GdtLandingPageReport$2
  implements Runnable
{
  GdtLandingPageReport$2(GdtLandingPageReport paramGdtLandingPageReport, String paramString, CustomWebView paramCustomWebView, int paramInt, long paramLong, GdtLandingPageReport.WebviewEvaluateListener paramWebviewEvaluateListener) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" injectScript start script =");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    GdtLog.a("GdtLandingPageReport", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.evaluateJavascript(this.jdField_a_of_type_JavaLangString, new GdtLandingPageReport.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport.2
 * JD-Core Version:    0.7.0.1
 */