package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bifw;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PayJsPlugin$MyResultRecevicer
  extends ResultReceiver
{
  private WeakReference<PayJsPlugin> a;
  
  public PayJsPlugin$MyResultRecevicer(PayJsPlugin paramPayJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.a = new WeakReference(paramPayJsPlugin);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel())
    {
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "MyResultRecevicer receive = " + this);
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "resultCode = " + paramInt + " resultData = " + paramBundle);
    }
    PayJsPlugin localPayJsPlugin = (PayJsPlugin)this.a.get();
    if ((localPayJsPlugin == null) || (paramBundle == null)) {}
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
        } while ((localPayJsPlugin.mRuntime == null) || (localPayJsPlugin.mRuntime.a() == null) || (str1 == null) || (paramBundle == null));
        localPayJsPlugin.mRuntime.a().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + paramBundle + "});");
        return;
        str1 = paramBundle.getString("callbackSn");
        str2 = paramBundle.getString("result");
        paramBundle.getBoolean("isChoosePubAcc", false);
        paramBundle.getString("pubAcc");
      } while ((localPayJsPlugin.mRuntime == null) || (localPayJsPlugin.mRuntime.a() == null) || (str1 == null) || (str2 == null));
      localPayJsPlugin.mRuntime.a().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + str1 + "',{'r':0,'result':" + str2 + "});");
      return;
      str1 = paramBundle.getString("callback");
      paramBundle = paramBundle.getString("retData");
    } while ((localPayJsPlugin.mRuntime == null) || (localPayJsPlugin.mRuntime.a() == null) || (str1 == null) || (paramBundle == null));
    localPayJsPlugin.a(str1, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PayJsPlugin.MyResultRecevicer
 * JD-Core Version:    0.7.0.1
 */