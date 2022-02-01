package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.appcommon.AppClient;

public class OpenAppDetailPlugin
  extends WebViewPlugin
{
  public OpenAppDetailPlugin()
  {
    this.mPluginNameSpace = "openToAppDetail";
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.mRuntime.b().getCurrentAccountUin());
    localBundle.putString("sid", this.mRuntime.d().getIntent().getStringExtra("vkey"));
    localBundle.putString("via", "ANDROIDQQ.STORE.APPDETAIL.SHARE2QQ");
    if ((paramString2 != null) && (paramString2.equals("true"))) {
      localBundle.putBoolean("autoDownload", true);
    }
    if (paramString3 != null) {
      localBundle.putString("packageName", paramString3);
    }
    AppClient.a(this.mRuntime.d(), paramString1, 2470, localBundle);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"openToAppDetail".equals(paramString2)) {
      return false;
    }
    if ("openAppDetailPage".equals(paramString3))
    {
      if (paramVarArgs.length == 2)
      {
        a(paramVarArgs[0], paramVarArgs[1]);
        return true;
      }
      if (paramVarArgs.length == 3)
      {
        a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OpenAppDetailPlugin
 * JD-Core Version:    0.7.0.1
 */