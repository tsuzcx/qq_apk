package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class PubAccountMailJsPlugin$3
  implements QQPermissionCallback
{
  PubAccountMailJsPlugin$3(PubAccountMailJsPlugin paramPubAccountMailJsPlugin) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PubAccountMailJsPlugin", 1, "CheckPermission user denied = ");
    DialogUtil.a(this.a.mRuntime.a(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PubAccountMailJsPlugin", 1, "CheckPermission user grant = ");
    PubAccountMailJsPlugin.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountMailJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */