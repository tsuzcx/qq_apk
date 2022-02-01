package com.tencent.mobileqq.ark.browser;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class ArkPlugin$1
  implements View.OnClickListener
{
  ArkPlugin$1(ArkPlugin paramArkPlugin) {}
  
  public void onClick(View paramView)
  {
    if ((ArkPlugin.a(this.a) == 0) && (!TextUtils.isEmpty(ArkPlugin.a(this.a))))
    {
      ArkPlugin.a(this.a).put(ArkPlugin.b(this.a), Integer.valueOf(1));
      WebViewProvider localWebViewProvider = this.a.mRuntime.a();
      if (localWebViewProvider != null) {
        localWebViewProvider.getWebView().loadUrl(ArkPlugin.a(this.a));
      }
      ArkPlugin.a(this.a, null);
    }
    ArkPlugin.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkPlugin.1
 * JD-Core Version:    0.7.0.1
 */