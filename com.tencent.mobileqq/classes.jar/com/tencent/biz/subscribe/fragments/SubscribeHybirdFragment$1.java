package com.tencent.biz.subscribe.fragments;

import android.os.Bundle;
import android.widget.ImageView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;

class SubscribeHybirdFragment$1
  extends WebKernelCallBackProxy
{
  SubscribeHybirdFragment$1(SubscribeHybirdFragment paramSubscribeHybirdFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    this.a.getUIStyleHandler().a.D = false;
    this.a.getUIStyleHandler().a.f = true;
    SubscribeHybirdFragment localSubscribeHybirdFragment = this.a;
    SubscribeHybirdFragment.a(localSubscribeHybirdFragment, new SubscribeShareHelper(localSubscribeHybirdFragment.getHostActivity()));
    SubscribeHybirdFragment.a(this.a);
    super.onDataInit(paramBundle);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    this.a.a(paramBundle);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if ((paramInt > 25) && (SubscribeHybirdFragment.a(this.a) != null)) {
      SubscribeHybirdFragment.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.1
 * JD-Core Version:    0.7.0.1
 */