package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class WebSoPlugin$2$1
  implements Runnable
{
  WebSoPlugin$2$1(WebSoPlugin.2 param2) {}
  
  public void run()
  {
    if ((this.a.this$0.mRuntime != null) && (this.a.this$0.mRuntime.a() != null)) {
      try
      {
        this.a.this$0.a(this.a.this$0.mRuntime.a());
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("asynJudgmentDynamicCover, useSoftwareMode err, ExceptionMsg = ");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("WebSoPlugin", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.WebSoPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */