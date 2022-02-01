package com.tencent.mobileqq.ark.browser;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.ShareToFriendCallback;

class ArkBrowserFragment$ArkShareToFriendCallback
  implements SwiftBrowserShareMenuHandler.ShareToFriendCallback
{
  ArkBrowserFragment$ArkShareToFriendCallback(ArkBrowserFragment paramArkBrowserFragment) {}
  
  public void a(String paramString)
  {
    ArkBrowserFragment localArkBrowserFragment = this.a;
    localArkBrowserFragment.a = paramString;
    paramString = localArkBrowserFragment.getWebView();
    if (paramString != null) {
      paramString.callJs("NativeApi.lightappGetShareData();");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment.ArkShareToFriendCallback
 * JD-Core Version:    0.7.0.1
 */