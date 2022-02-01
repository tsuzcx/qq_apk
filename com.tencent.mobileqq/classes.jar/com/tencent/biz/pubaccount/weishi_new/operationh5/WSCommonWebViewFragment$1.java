package com.tencent.biz.pubaccount.weishi_new.operationh5;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class WSCommonWebViewFragment$1
  extends WebKernelCallBackProxy
{
  WSCommonWebViewFragment$1(WSCommonWebViewFragment paramWSCommonWebViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    super.onWebViewInit(paramBundle, paramTouchWebView);
    WSCommonWebViewFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.WSCommonWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */