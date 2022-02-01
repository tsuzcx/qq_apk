package com.tencent.biz.pubaccount.weishi_new.operationh5;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class WSOperationWebViewFragment$1
  extends WebKernelCallBackProxy
{
  WSOperationWebViewFragment$1(WSOperationWebViewFragment paramWSOperationWebViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    WSOperationWebViewFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.WSOperationWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */