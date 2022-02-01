package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.smtt.sdk.WebView;

class QzonePlugin$2
  implements Runnable
{
  QzonePlugin$2(QzonePlugin paramQzonePlugin) {}
  
  public void run()
  {
    if (QzonePlugin.a(this.this$0) != null)
    {
      Object localObject = QzonePlugin.a(this.this$0);
      if (this.this$0.mRuntime.a().getIntent().getExtras().getString("url") != null) {
        localObject = this.this$0.mRuntime.a().getIntent().getExtras().getString("url");
      }
      QzonePlugin.a(this.this$0).loadData(new String((String)localObject).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
      localObject = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof WebUiUtils.WebUiMethodInterface))) {
        ((WebUiUtils.WebUiMethodInterface)localObject).setBottomBarVisible(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QzonePlugin.2
 * JD-Core Version:    0.7.0.1
 */