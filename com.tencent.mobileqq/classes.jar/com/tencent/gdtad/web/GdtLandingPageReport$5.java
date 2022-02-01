package com.tencent.gdtad.web;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;

class GdtLandingPageReport$5
  implements GdtLandingPageReport.WebviewEvaluateListener
{
  GdtLandingPageReport$5(GdtLandingPageReport paramGdtLandingPageReport, CustomWebView paramCustomWebView, String paramString) {}
  
  public void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("true")))
    {
      GdtLandingPageReport.a(this.jdField_a_of_type_ComTencentGdtadWebGdtLandingPageReport, true);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" should supply performance inject. resp: ");
    localStringBuilder.append(paramString);
    GdtLog.a("GdtLandingPageReport", localStringBuilder.toString());
    GdtLandingPageReport.a(this.jdField_a_of_type_ComTencentGdtadWebGdtLandingPageReport, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport.5
 * JD-Core Version:    0.7.0.1
 */