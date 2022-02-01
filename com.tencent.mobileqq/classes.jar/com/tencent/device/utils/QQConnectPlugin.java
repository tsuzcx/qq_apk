package com.tencent.device.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QQConnectPlugin
  extends WebViewPlugin
{
  public QQConnectPlugin()
  {
    this.mPluginNameSpace = "QQConnect";
  }
  
  private HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    paramString = URLDecoder.decode(paramString).split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"QQConnect".equals(paramString2)) {
      return false;
    }
    if ("goShare".equals(paramString3)) {
      LogUtility.c(this.mTAG, "goshare");
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      paramString3 = paramJsBridgeListener.getString("din");
      paramString2 = a(paramJsBridgeListener.getString("args"));
      paramVarArgs = (String)paramString2.get("uin");
      String str1 = (String)paramString2.get("sn");
      String str2 = (String)paramString2.get("pid");
      int i = paramJsBridgeListener.optInt("public_device", 0);
      if ((i != 0) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))))
      {
        ToastUtil.a().a(this.mRuntime.d().getString(2131917821));
        return true;
      }
      paramString2 = this.mRuntime.d();
      paramJsBridgeListener = paramString2;
      if ((paramString2 instanceof BasePluginActivity)) {
        paramJsBridgeListener = ((BasePluginActivity)paramString2).getOutActivity();
      }
      paramJsBridgeListener = new Intent(paramJsBridgeListener, DevicePluginDownloadActivity.class);
      if (i != 0)
      {
        paramJsBridgeListener.putExtra("DevicePID", str2);
        paramJsBridgeListener.putExtra("DeviceSN", str1);
        paramJsBridgeListener.putExtra("DeviceToken", "");
        paramJsBridgeListener.putExtra("public_device", i);
      }
      else
      {
        paramJsBridgeListener.putExtra("troop_uin", paramString3);
        paramJsBridgeListener.putExtra("uin", paramVarArgs);
        paramJsBridgeListener.putExtra("url", paramString1);
      }
      paramJsBridgeListener.putExtra("from", "share");
      this.mRuntime.d().startActivity(paramJsBridgeListener);
      this.mRuntime.d().finish();
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      label282:
      break label282;
    }
    ToastUtil.a().a(this.mRuntime.d().getString(2131887127));
    return true;
    if ("doReport".equals(paramString3)) {}
    try
    {
      LogUtility.c(this.mTAG, "doReport");
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      SmartDeviceReport.a(null, paramJsBridgeListener.optString("actionName"), paramJsBridgeListener.optInt("fromType"), paramJsBridgeListener.optInt("actionResult"), paramJsBridgeListener.optInt("ext2"));
      return true;
    }
    catch (JSONException paramJsBridgeListener)
    {
      boolean bool;
      return false;
    }
    if ("goBind".equals(paramString3))
    {
      LogUtility.c(this.mTAG, "qrUrl");
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("url");
      bool = TextUtils.isEmpty(paramJsBridgeListener);
      if (bool) {}
    }
    try
    {
      paramJsBridgeListener = new String(Base64Util.decode(paramJsBridgeListener, 0));
    }
    catch (Exception paramJsBridgeListener)
    {
      label426:
      break label426;
    }
    paramJsBridgeListener = null;
    if (!TextUtils.isEmpty(paramJsBridgeListener))
    {
      paramString2 = this.mRuntime.d();
      paramString1 = paramString2;
      if ((paramString2 instanceof BasePluginActivity)) {
        paramString1 = ((BasePluginActivity)paramString2).getOutActivity();
      }
      paramString1 = new Intent(paramString1, DevicePluginDownloadActivity.class);
      paramString1.putExtra("qrurl", paramJsBridgeListener);
      paramString1.putExtra("entrance", 1);
      paramString1.putExtra("from", "connect");
      this.mRuntime.d().startActivity(paramString1);
    }
    this.mRuntime.d().finish();
    return true;
    if ("jumpPublicDevice".equals(paramString3))
    {
      LogUtility.c(this.mTAG, "METHOD_JUMP_PUBLICDEVICE");
      paramString2 = new JSONObject(paramVarArgs[0]).optString("actionUrl");
      if (TextUtils.isEmpty(paramString2)) {
        return true;
      }
      paramString1 = this.mRuntime.d();
      paramJsBridgeListener = paramString1;
      if ((paramString1 instanceof BasePluginActivity)) {
        paramJsBridgeListener = ((BasePluginActivity)paramString1).getOutActivity();
      }
      paramJsBridgeListener = new Intent(paramJsBridgeListener, DevicePluginDownloadActivity.class);
      paramJsBridgeListener.putExtra("url", paramString2);
      paramJsBridgeListener.putExtra("jumpPublicDevice", true);
      paramJsBridgeListener.putExtra("from", "share");
      this.mRuntime.d().startActivity(paramJsBridgeListener);
      this.mRuntime.d().finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.QQConnectPlugin
 * JD-Core Version:    0.7.0.1
 */