package com.tencent.biz.webviewplugin;

import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.LoadedBack2;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.smtt.sdk.WebView;

class OfflinePlugin$8
  implements LoadedBack2
{
  OfflinePlugin$8(OfflinePlugin paramOfflinePlugin) {}
  
  public void a()
  {
    Object localObject = this.a.mRuntime.d();
    if (localObject == null) {
      return;
    }
    WebUiBaseInterface localWebUiBaseInterface = this.a.mRuntime.a(this.a.mRuntime.d());
    if (QBaseActivity.sTopActivity != localObject)
    {
      localObject = this.a.mRuntime.a();
      if (localObject != null) {
        try
        {
          if ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))
          {
            ((WebView)localObject).loadUrl(((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface).getCurrentUrl());
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void loaded(String paramString, int paramInt)
  {
    paramString = this.a.u.obtainMessage();
    paramString.arg1 = 5;
    paramString.arg2 = paramInt;
    this.a.u.sendMessage(paramString);
  }
  
  public void progress(int paramInt)
  {
    Message localMessage = this.a.u.obtainMessage();
    localMessage.arg1 = 4;
    localMessage.arg2 = paramInt;
    this.a.u.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.8
 * JD-Core Version:    0.7.0.1
 */