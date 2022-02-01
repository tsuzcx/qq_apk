package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class AccountReleasePlugin
  extends WebViewPlugin
{
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountRelease", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if (!"accountRelease".equals(paramString2)) {
      return false;
    }
    if ("onReleaseSuccess".equals(paramString3))
    {
      paramJsBridgeListener = this.mRuntime.a();
      if (paramJsBridgeListener != null)
      {
        paramJsBridgeListener.setResult(-1, null);
        paramJsBridgeListener.finish();
        return false;
      }
      QLog.d("AccountRelease", 1, "release success, activity == null");
      return false;
    }
    if ("getToken".equals(paramString3))
    {
      paramJsBridgeListener = this.mRuntime.a();
      paramString1 = this.mRuntime.a();
      boolean bool;
      if (paramString1 != null)
      {
        bool = paramString1.getIntent().getBooleanExtra("is_release_account", false);
      }
      else
      {
        QLog.d("AccountRelease", 1, "getToken, activity == null");
        bool = false;
      }
      if ((bool) && (paramJsBridgeListener != null))
      {
        paramString1 = (TicketManager)paramJsBridgeListener.getManager(2);
        paramJsBridgeListener = paramJsBridgeListener.getCurrentAccountUin();
        paramString1 = paramString1.getA2(paramJsBridgeListener);
        if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString1)))
        {
          paramString1 = HexUtil.hexStr2Bytes(paramString1);
          long l = Long.valueOf(paramJsBridgeListener).longValue();
          paramJsBridgeListener = new byte[76];
          paramJsBridgeListener[3] = ((byte)(int)(l & 0xFF));
          paramJsBridgeListener[2] = ((byte)(int)(l >>> 8 & 0xFF));
          paramJsBridgeListener[1] = ((byte)(int)(l >>> 16 & 0xFF));
          paramJsBridgeListener[0] = ((byte)(int)(l >>> 24 & 0xFF));
          int i = 0;
          while (i < paramString1.length)
          {
            paramJsBridgeListener[(i + 4)] = paramString1[i];
            i += 1;
          }
          paramJsBridgeListener = MD5Utils.encodeHexStr(paramJsBridgeListener);
          break label389;
        }
        paramString2 = new StringBuilder();
        paramString2.append("uin or a2 is empty, uin:");
        paramString2.append(paramJsBridgeListener);
        paramString2.append(",a2:");
        paramString2.append(paramString1);
        QLog.d("AccountRelease", 1, paramString2.toString());
      }
      else
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append("getToken, app == null or flag: ");
        paramJsBridgeListener.append(bool);
        QLog.d("AccountRelease", 1, paramJsBridgeListener.toString());
      }
      paramJsBridgeListener = "";
      label389:
      if (QLog.isColorLevel()) {
        QLog.d("AccountRelease", 2, String.format("getToken: %s", new Object[] { paramJsBridgeListener }));
      }
      paramString1 = new JSONObject();
      try
      {
        bool = TextUtils.isEmpty(paramJsBridgeListener);
        if (bool) {
          paramString1.put("token", "");
        } else {
          paramString1.put("token", paramJsBridgeListener);
        }
        callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { paramString1.toString() });
        return false;
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.AccountReleasePlugin
 * JD-Core Version:    0.7.0.1
 */