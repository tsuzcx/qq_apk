package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

public class PayJsPlugin$MyResultRecevicer
  extends ResultReceiver
{
  protected PayJsPlugin a;
  
  public PayJsPlugin$MyResultRecevicer(PayJsPlugin paramPayJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramPayJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    if ((this.a == null) || (paramBundle == null)) {}
    String str1;
    do
    {
      String str2;
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "js callback...");
          }
          switch (paramInt)
          {
          case 5: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 15: 
          default: 
            return;
          case 4: 
          case 6: 
          case 7: 
          case 8: 
          case 14: 
          case 17: 
            str1 = paramBundle.getString("callbackSn");
            paramBundle = paramBundle.getString("result");
          }
        } while ((this.a.mRuntime == null) || (this.a.mRuntime.a() == null) || (str1 == null) || (paramBundle == null));
        this.a.mRuntime.a().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + paramBundle + "});");
        return;
        str1 = paramBundle.getString("callbackSn");
        str2 = paramBundle.getString("result");
        paramBundle.getBoolean("isChoosePubAcc", false);
        paramBundle.getString("pubAcc");
      } while ((this.a.mRuntime == null) || (this.a.mRuntime.a() == null) || (str1 == null) || (str2 == null));
      this.a.mRuntime.a().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + str2 + "});");
      return;
      str1 = paramBundle.getString("callback");
      paramBundle = paramBundle.getString("retData");
    } while ((this.a.mRuntime == null) || (this.a.mRuntime.a() == null) || (str1 == null) || (paramBundle == null));
    this.a.a(str1, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PayJsPlugin.MyResultRecevicer
 * JD-Core Version:    0.7.0.1
 */