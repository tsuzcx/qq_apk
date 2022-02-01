package com.tencent.mobileqq.ark.browser;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.Doraemon.NativeApiManagerImpl;
import com.tencent.mobileqq.Doraemon.impl.webview.WebViewDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class ArkBrowserFragment
  extends WebViewFragment
{
  public String a = null;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2 = this.webView.getPluginEngine();
    Object localObject1 = getCurrentUrl();
    if (TextUtils.isEmpty(DoraemonUtil.a((String)localObject1))) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = (NativeApiManagerImpl)((WebViewPluginEngine)localObject2).a();
        } while (localObject2 == null);
        localObject1 = ((NativeApiManagerImpl)localObject2).a((String)localObject1);
      } while (localObject1 == null);
      localObject1 = (ArkWebModule)((WebViewDoraemonAPIManager)localObject1).a(ArkWebModule.class, false);
    } while (localObject1 == null);
    ((ArkWebModule)localObject1).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRulesFromUrl(getRulesFromUrl() & 0xFFFFFFFB);
  }
  
  public void showActionSheet()
  {
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      localSwiftBrowserShareMenuHandler.a(new ArkBrowserFragment.ArkShareToFriendCallback(this));
      localSwiftBrowserShareMenuHandler.a(ensureShare(), this.mUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */