package com.tencent.mobileqq.ark.browser;

import adpb;
import adqf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aqdi;
import aqdm;
import bipn;
import biqq;
import birj;
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
    if (TextUtils.isEmpty(adqf.a(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (aqdm)((adpb)localObject).a(aqdm.class, false);
    } while (localObject == null);
    ((aqdm)localObject).a(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRulesFromUrl(getRulesFromUrl() & 0xFFFFFFFB);
  }
  
  public void showActionSheet()
  {
    biqq localbiqq = (biqq)this.mComponentsProvider.a(4);
    if (localbiqq != null)
    {
      localbiqq.a(new aqdi(this));
      localbiqq.a(ensureShare(), this.mUIStyle.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */