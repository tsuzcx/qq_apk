package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$6
  extends WebKernelCallBackProxy
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$6(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public boolean interceptStartLoadUrl()
  {
    return this.a.b();
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    this.a.b(paramBundle);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.a(paramWebView, paramString, this.webViewKernelCallBack);
  }
  
  public void onShowPreview(Bundle paramBundle)
  {
    super.onShowPreview(paramBundle);
    this.a.a(paramBundle);
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    this.a.a(paramBundle, paramTouchWebView, this.webViewKernelCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.6
 * JD-Core Version:    0.7.0.1
 */