package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

public class SecurityVerifyPlugin
  extends WebViewPlugin
{
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if (!"userVerify".equals(paramString2)) {
      return false;
    }
    paramJsBridgeListener = this.mRuntime.d();
    if (paramJsBridgeListener == null) {
      return false;
    }
    if ("setTicket".equals(paramString3)) {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]).optString("ticket");
        int i = paramJsBridgeListener.getIntent().getIntExtra("verify_type", -1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.security_verify", 2, String.format("verifyTicket: %s, verifyType: %s", new Object[] { paramString1, Integer.valueOf(i) }));
        }
        paramString2 = new Intent();
        paramString2.putExtra("ticket", paramString1);
        paramJsBridgeListener.setResult(-1, paramString2);
        paramJsBridgeListener.finish();
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        QLog.d("Q.security_verify", 1, "handleJsRequest", paramJsBridgeListener);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SecurityVerifyPlugin
 * JD-Core Version:    0.7.0.1
 */