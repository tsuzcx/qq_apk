package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

class OfflinePlugin$2
  extends Handler
{
  OfflinePlugin$2(OfflinePlugin paramOfflinePlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.g) {
      return;
    }
    if (paramMessage.what == 121) {
      OfflinePlugin.a(this.a, paramMessage);
    }
    Object localObject1;
    if (paramMessage.arg1 == 1)
    {
      this.a.j = paramMessage.arg2;
      localObject1 = (String)paramMessage.obj;
      localObject3 = this.a.mRuntime.a();
      if (localObject3 == null) {
        return;
      }
      if (this.a.o == -1L) {
        this.a.o = System.currentTimeMillis();
      }
      ((CustomWebView)localObject3).loadUrlOriginal((String)localObject1);
      ((CustomWebView)localObject3).requestFocus();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mCheckupHandler loadUrl start \n");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("OfflinePluginQQ", 2, ((StringBuilder)localObject3).toString());
      }
      this.a.b((String)localObject1);
    }
    else if (paramMessage.arg1 == 2)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("OfflinePluginQQ", 4, "checkOfflineUpBack refresh current url");
      }
      this.a.e();
    }
    else if (paramMessage.arg1 == 3)
    {
      try
      {
        localObject1 = (JSONObject)paramMessage.obj;
        this.a.a((JSONObject)localObject1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject2 = this.a.mRuntime.d();
    Object localObject3 = this.a.mRuntime.a(this.a.mRuntime.d());
    if (localObject3 != null)
    {
      if (!(localObject3 instanceof WebUiUtils.QQBrowserBaseActivityInterface)) {
        return;
      }
      if (paramMessage.arg1 == 4)
      {
        if ((OfflinePlugin.e != null) && (!TextUtils.isEmpty(OfflinePlugin.a(this.a))))
        {
          localObject2 = (OfflineUpdateStatus)OfflinePlugin.e.get(OfflinePlugin.a(this.a));
          if (this.a.d != null) {
            this.a.d.setProgress(paramMessage.arg2);
          }
          if (this.a.c != null)
          {
            localObject3 = this.a.c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((OfflineUpdateStatus)localObject2).e);
            localStringBuilder.append(paramMessage.arg2);
            localStringBuilder.append("%");
            ((TextView)localObject3).setText(localStringBuilder.toString());
          }
        }
      }
      else if ((paramMessage.arg1 == 5) && (OfflinePlugin.e != null) && (!TextUtils.isEmpty(OfflinePlugin.a(this.a))))
      {
        localObject3 = (OfflineUpdateStatus)OfflinePlugin.e.get(OfflinePlugin.a(this.a));
        if (localObject3 != null) {
          OfflinePlugin.a(this.a, paramMessage, (Activity)localObject2, (OfflineUpdateStatus)localObject3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.2
 * JD-Core Version:    0.7.0.1
 */