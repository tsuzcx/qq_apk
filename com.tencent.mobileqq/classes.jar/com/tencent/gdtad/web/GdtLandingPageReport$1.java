package com.tencent.gdtad.web;

import acho;
import acld;
import com.tencent.biz.pubaccount.CustomWebView;

public class GdtLandingPageReport$1
  implements Runnable
{
  public GdtLandingPageReport$1(acld paramacld, String paramString, CustomWebView paramCustomWebView) {}
  
  public void run()
  {
    String str = acld.a(this.this$0, acld.a(this.this$0), acld.a(this.this$0, "GdtWebReportQQ_TRACE_ID"), this.jdField_a_of_type_JavaLangString);
    acho.d("GdtLandingPageReport", " webviewInjectScript getScript ==" + str);
    acld.a(this.this$0, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, str, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport.1
 * JD-Core Version:    0.7.0.1
 */