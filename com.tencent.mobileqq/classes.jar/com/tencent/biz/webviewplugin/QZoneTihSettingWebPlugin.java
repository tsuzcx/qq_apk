package com.tencent.biz.webviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QZoneTihSettingWebPlugin
  extends WebViewPlugin
{
  public QZoneTihSettingWebPlugin()
  {
    this.mPluginNameSpace = "qztodayinhistory";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest url: ");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append("pkgName:");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append("method:");
      paramJsBridgeListener.append(paramString3);
      QLog.d("QZoneTihSettingWebPlugin", 2, paramJsBridgeListener.toString());
    }
    if (!paramString2.equals("qztodayinhistory")) {
      return false;
    }
    if (paramString3.equals("settihnome"))
    {
      paramJsBridgeListener = new Intent("aciton_switch_tih_setting");
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("actionString: ");
        paramString1.append(paramJsBridgeListener.getAction());
        QLog.d("QZoneTihSettingWebPlugin", 2, paramString1.toString());
      }
      BaseApplication.getContext().sendBroadcast(paramJsBridgeListener);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.QZoneTihSettingWebPlugin
 * JD-Core Version:    0.7.0.1
 */