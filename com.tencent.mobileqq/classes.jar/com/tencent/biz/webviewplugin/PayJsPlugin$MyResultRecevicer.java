package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MyResultRecevicer receive = ");
      ((StringBuilder)localObject1).append(this);
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resultCode = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" resultData = ");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.i("JsBridge.JsHandle.PayJsHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (PayJsPlugin)this.a.get();
    if (localObject1 != null)
    {
      if (paramBundle == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("JsBridge.JsHandle.PayJsHandler", 2, "js callback...");
      }
      Object localObject2;
      if ((paramInt != 4) && (paramInt != 14)) {
        if (paramInt != 16)
        {
          if (paramInt == 17) {}
        }
        else {
          switch (paramInt)
          {
          default: 
            return;
          case 9: 
            str = paramBundle.getString("callbackSn");
            localObject2 = paramBundle.getString("result");
            paramBundle.getBoolean("isChoosePubAcc", false);
            paramBundle.getString("pubAcc");
            if ((((PayJsPlugin)localObject1).mRuntime == null) || (((PayJsPlugin)localObject1).mRuntime.a() == null) || (str == null) || (localObject2 == null)) {
              break;
            }
            paramBundle = ((PayJsPlugin)localObject1).mRuntime.a();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("javascript:window.JsBridge&&JsBridge.callback('");
            ((StringBuilder)localObject1).append(str);
            ((StringBuilder)localObject1).append("',{'r':0,'result':");
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("});");
            paramBundle.loadUrl(((StringBuilder)localObject1).toString());
            return;
            str = paramBundle.getString("callback");
            paramBundle = paramBundle.getString("retData");
            if ((((PayJsPlugin)localObject1).mRuntime == null) || (((PayJsPlugin)localObject1).mRuntime.a() == null) || (str == null) || (paramBundle == null)) {
              break;
            }
            ((PayJsPlugin)localObject1).a(str, paramBundle);
            return;
          }
        }
      }
      String str = paramBundle.getString("callbackSn");
      paramBundle = paramBundle.getString("result");
      if ((((PayJsPlugin)localObject1).mRuntime != null) && (((PayJsPlugin)localObject1).mRuntime.a() != null) && (str != null) && (paramBundle != null))
      {
        localObject1 = ((PayJsPlugin)localObject1).mRuntime.a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("javascript:window.JsBridge&&JsBridge.callback('");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("',{'r':0,'result':");
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append("});");
        ((CustomWebView)localObject1).loadUrl(((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PayJsPlugin.MyResultRecevicer
 * JD-Core Version:    0.7.0.1
 */