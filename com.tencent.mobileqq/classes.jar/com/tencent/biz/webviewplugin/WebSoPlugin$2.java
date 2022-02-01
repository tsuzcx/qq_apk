package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.webso.WebSoUtils;

class WebSoPlugin$2
  implements Runnable
{
  WebSoPlugin$2(WebSoPlugin paramWebSoPlugin, String paramString) {}
  
  public void run()
  {
    if ((WebSoUtils.c(this.a)) && (this.this$0.mRuntime != null) && (this.this$0.mRuntime.a() != null)) {
      this.this$0.mRuntime.a().runOnUiThread(new WebSoPlugin.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.2
 * JD-Core Version:    0.7.0.1
 */