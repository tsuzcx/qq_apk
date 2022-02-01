package com.tencent.biz.pubaccount;

import android.os.Bundle;
import com.tencent.mobileqq.webview.cookie.SetCookiesCallback;

class CustomWebView$1
  implements SetCookiesCallback
{
  CustomWebView$1(CustomWebView paramCustomWebView, CustomWebView.LoadUrlInfo paramLoadUrlInfo) {}
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.b, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.c, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.d, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.e);
          return;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData(paramString, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.c, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView$LoadUrlInfo.d);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.CustomWebView.1
 * JD-Core Version:    0.7.0.1
 */