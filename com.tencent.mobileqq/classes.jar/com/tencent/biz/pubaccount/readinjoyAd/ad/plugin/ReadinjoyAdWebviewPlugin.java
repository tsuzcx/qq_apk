package com.tencent.biz.pubaccount.readinjoyAd.ad.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadinjoyAdWebviewPlugin
  extends WebViewPlugin
{
  public ReadinjoyAdWebviewPlugin()
  {
    this.mPluginNameSpace = "ReadinjoyAdJs";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      if (QLog.isColorLevel())
      {
        paramJsBridgeListener = new StringBuilder();
        paramJsBridgeListener.append(" method:");
        paramJsBridgeListener.append(paramString3);
        QLog.d("PublicAccountWebviewPlugin", 2, paramJsBridgeListener.toString());
      }
      if ("setGameSubscribe".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("ret");
          paramJsBridgeListener.optString("appid");
          paramJsBridgeListener = paramJsBridgeListener.optString("pkgname");
          if (("1".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
          {
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append(" method:pkgname=");
              paramString1.append(paramJsBridgeListener);
              QLog.d("PublicAccountWebviewPlugin", 2, paramString1.toString());
            }
            paramString1 = new Bundle();
            paramString1.putBoolean("isSuccess", true);
            paramString1.putString("pkgname", paramJsBridgeListener);
            TroopMemberApiClient.a().a(132, paramString1);
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PublicAccountWebviewPlugin", 2, paramJsBridgeListener.getMessage());
          }
        }
      }
      if ("setGameLoadState".equals(paramString3))
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("adid");
          long l1 = ParseUtil.a(paramString1.optString("navigationStart"), 0L);
          long l2 = ParseUtil.a(paramString1.optString("htmlLoaded"), 0L);
          paramString1 = paramString1.optString("domComplete");
          try
          {
            long l3 = ParseUtil.a(paramString1, 0L);
            if ((l1 <= 0L) && (l2 <= 0L) && (l3 <= 0L)) {
              break label368;
            }
            paramString1 = new Bundle();
            paramString1.putString("adid", paramJsBridgeListener);
            paramString1.putLong("navigationStart", l1);
            paramString1.putLong("htmlLoaded", l2);
            paramString1.putLong("domComplete", l3);
            TroopMemberApiClient.a().a(139, paramString1);
            return true;
          }
          catch (Exception paramJsBridgeListener) {}
          if (!QLog.isColorLevel()) {
            break label368;
          }
        }
        catch (Exception paramJsBridgeListener) {}
        QLog.e("PublicAccountWebviewPlugin", 2, paramJsBridgeListener.getMessage());
      }
      label368:
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountWebviewPlugin", 2, " method null or args == null");
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    return super.handleSchemaRequest(paramString1, paramString2);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.plugin.ReadinjoyAdWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */