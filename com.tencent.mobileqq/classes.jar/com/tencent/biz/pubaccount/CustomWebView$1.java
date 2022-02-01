package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.webview.cookie.SetCookiesCallback;

class CustomWebView$1
  implements SetCookiesCallback
{
  CustomWebView$1(CustomWebView paramCustomWebView, CustomWebView.LoadUrlInfo paramLoadUrlInfo) {}
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    switch (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.a)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(paramString);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData(paramString, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.c, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.d);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.b, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.c, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.d, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView.1
 * JD-Core Version:    0.7.0.1
 */