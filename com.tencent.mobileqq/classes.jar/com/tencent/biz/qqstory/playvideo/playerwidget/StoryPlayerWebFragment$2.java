package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class StoryPlayerWebFragment$2
  extends WebKernelCallBackProxy
{
  StoryPlayerWebFragment$2(StoryPlayerWebFragment paramStoryPlayerWebFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onShowPreview(Bundle paramBundle)
  {
    this.a.a();
  }
  
  public void onWebViewInit(Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    super.onWebViewInit(paramBundle, paramTouchWebView);
    ((SwiftBrowserSetting)this.a.mComponentsProvider.a(-1)).a("web_view_long_click", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment.2
 * JD-Core Version:    0.7.0.1
 */