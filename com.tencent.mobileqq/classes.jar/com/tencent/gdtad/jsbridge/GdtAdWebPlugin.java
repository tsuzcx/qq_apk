package com.tencent.gdtad.jsbridge;

import android.os.Bundle;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import org.json.JSONObject;

public class GdtAdWebPlugin
  extends VasWebviewJsPlugin
{
  public GdtAdWebPlugin()
  {
    this.mPluginNameSpace = "qq_gdt_ad";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    GdtJsCallHandler localGdtJsCallHandler = null;
    try
    {
      String str = new JSONObject(paramVarArgs[0]).optString("callback");
      if ("loadAd".equals(paramString3))
      {
        localGdtJsCallHandler = GdtAdPluginFactory.a().a(5);
        if (localGdtJsCallHandler != null) {
          localGdtJsCallHandler.a(this, str, paramVarArgs);
        }
        return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        GdtLog.d("GdtAdWebPlugin", "GdtAdWebPlugin handleJsCallRequest error ", localException);
        Object localObject = null;
        continue;
        if ("doAdReport".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(3);
        } else if ("doAppJump".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(1);
        } else if ("showVideoCeiling".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(2);
        } else if ("getLocation".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(4);
        } else if ("showCanvas".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(6);
        } else if ("getDeviceId".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(7);
        } else if ("getMacAddress".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(8);
        } else if ("getCarrier".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(9);
        } else if ("getNetType".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(10);
        } else if ("getOSVersion".equals(paramString3)) {
          localGdtJsCallHandler = GdtAdPluginFactory.a().a(11);
        }
      }
    }
  }
  
  protected void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtAdWebPlugin
 * JD-Core Version:    0.7.0.1
 */