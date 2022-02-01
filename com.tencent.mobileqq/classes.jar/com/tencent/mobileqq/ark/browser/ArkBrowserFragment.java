package com.tencent.mobileqq.ark.browser;

import aclu;
import acmy;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aowt;
import aowx;
import bgvt;
import bgww;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;

public class ArkBrowserFragment
  extends WebViewFragment
{
  public String a;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.webView.getPluginEngine();
    String str = getCurrentUrl();
    if (TextUtils.isEmpty(acmy.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (aowx)((aclu)localObject).a(aowx.class, false);
    } while (localObject == null);
    ((aowx)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRulesFromUrl(getRulesFromUrl() & 0xFFFFFFFB);
  }
  
  public void showActionSheet()
  {
    bgww localbgww = (bgww)this.mComponentsProvider.a(4);
    if (localbgww != null)
    {
      localbgww.a(new aowt(this));
      localbgww.a(ensureShare(), this.mUIStyle.mRulesFromUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */