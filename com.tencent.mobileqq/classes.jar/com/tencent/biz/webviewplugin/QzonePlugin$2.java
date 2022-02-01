package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.smtt.sdk.WebView;

class QzonePlugin$2
  implements Runnable
{
  QzonePlugin$2(QzonePlugin paramQzonePlugin) {}
  
  public void run()
  {
    if (QzonePlugin.a(this.this$0) != null)
    {
      String str = QzonePlugin.b(this.this$0);
      if (this.this$0.mRuntime.d().getIntent().getExtras().getString("url") != null) {
        str = this.this$0.mRuntime.d().getIntent().getExtras().getString("url");
      }
      QzonePlugin.a(this.this$0).loadData(new String(str).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin.2
 * JD-Core Version:    0.7.0.1
 */