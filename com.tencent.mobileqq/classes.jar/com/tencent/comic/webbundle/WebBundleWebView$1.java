package com.tencent.comic.webbundle;

import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.webbundle.sdk.IWebBundleWebView.OnPageFinishedListener;

class WebBundleWebView$1
  extends WebViewClient
{
  WebBundleWebView$1(WebBundleWebView paramWebBundleWebView, IWebBundleWebView.OnPageFinishedListener paramOnPageFinishedListener) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.jdField_a_of_type_ComTencentWebbundleSdkIWebBundleWebView$OnPageFinishedListener.onPageFinished(this.jdField_a_of_type_ComTencentComicWebbundleWebBundleWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.webbundle.WebBundleWebView.1
 * JD-Core Version:    0.7.0.1
 */