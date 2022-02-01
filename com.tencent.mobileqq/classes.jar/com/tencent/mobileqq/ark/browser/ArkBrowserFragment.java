package com.tencent.mobileqq.ark.browser;

import adgd;
import adhh;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import apps;
import appw;
import bhos;
import bhpv;
import bhqo;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class ArkBrowserFragment
  extends WebViewFragment
{
  public String a;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.webView.getPluginEngine();
    String str = getCurrentUrl();
    if (TextUtils.isEmpty(adhh.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (appw)((adgd)localObject).a(appw.class, false);
    } while (localObject == null);
    ((appw)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRulesFromUrl(getRulesFromUrl() & 0xFFFFFFFB);
  }
  
  public void showActionSheet()
  {
    bhpv localbhpv = (bhpv)this.mComponentsProvider.a(4);
    if (localbhpv != null)
    {
      localbhpv.a(new apps(this));
      localbhpv.a(ensureShare(), this.mUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */