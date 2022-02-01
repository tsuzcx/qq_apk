package com.tencent.mobileqq.ark.browser;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.nativeapi.INativeApiMangerInjector;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class ArkBrowserFragment
  extends WebViewFragment
{
  public String a = null;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2 = this.webView.getPluginEngine();
    Object localObject1 = getCurrentUrl();
    if (TextUtils.isEmpty(DoraemonUtil.a((String)localObject1))) {
      return;
    }
    localObject2 = ((WebViewPluginEngine)localObject2).e();
    if (localObject2 == null) {
      return;
    }
    localObject1 = ((IDoraemonService)QRoute.api(IDoraemonService.class)).getDoraemonAPIModuleByUrl((INativeApiMangerInjector)localObject2, (String)localObject1);
    if (localObject1 == null) {
      return;
    }
    localObject1 = (ArkWebModule)((DoraemonAPIManager)localObject1).a(ArkWebModule.class, false);
    if (localObject1 != null) {
      ((ArkWebModule)localObject1).a(paramIntent, (byte)paramInt1, paramInt2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getUIStyleHandler().f.c &= 0xFFFFFFFB;
  }
  
  public void showActionSheet()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      localSwiftBrowserShareMenuHandler.a(new ArkBrowserFragment.ArkShareToFriendCallback(this));
      localSwiftBrowserShareMenuHandler.a((Share)getShare(), getUIStyle().c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */