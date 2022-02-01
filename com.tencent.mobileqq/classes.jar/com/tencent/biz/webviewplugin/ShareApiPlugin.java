package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.WebShareServlet;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class ShareApiPlugin
  extends VasWebviewJsPlugin
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  
  public ShareApiPlugin()
  {
    this.mPluginNameSpace = "share";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramString2 != null) && ("share".equals(paramString2))) {
      if ((paramString3 == null) || (!"setShare".equals(paramString3)) || (paramVarArgs.length != 1)) {}
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if ("share".equals(paramJsBridgeListener.optString("type")))
        {
          this.d = paramJsBridgeListener.optString("image");
          this.b = paramJsBridgeListener.optString("title");
          this.c = paramJsBridgeListener.optString("summary");
          this.a = paramJsBridgeListener.optString("shareURL");
          if (QLog.isColorLevel())
          {
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("Share info after JS capture: title=");
            paramJsBridgeListener.append(this.b);
            paramJsBridgeListener.append(", summary=");
            paramJsBridgeListener.append(this.c);
            paramJsBridgeListener.append(", thumb=");
            paramJsBridgeListener.append(this.d);
            paramJsBridgeListener.append(", shareURL=");
            paramJsBridgeListener.append(this.a);
            QLog.e("shareWebPage", 2, paramJsBridgeListener.toString());
          }
          if (!TextUtils.isEmpty(this.d)) {
            break label752;
          }
          j = 1;
          i = j;
          if (TextUtils.isEmpty(this.c)) {
            i = j | 0x2;
          }
          j = i;
          if (TextUtils.isEmpty(this.b)) {
            j = i | 0x4;
          }
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putString("report_type", "102");
          paramJsBridgeListener.putString("act_type", "90");
          paramString1 = new StringBuilder();
          paramString1.append("");
          if (j != 0) {
            break label758;
          }
          i = 0;
          paramString1.append(i);
          paramJsBridgeListener.putString("intext_1", paramString1.toString());
          paramString1 = new StringBuilder();
          paramString1.append("");
          paramString1.append(j);
          paramJsBridgeListener.putString("intext_2", paramString1.toString());
          paramString1 = new StringBuilder();
          paramString1.append("");
          paramString1.append(this.a);
          paramJsBridgeListener.putString("stringext_1", paramString1.toString());
          ReportCenter.a().a(paramJsBridgeListener, "", this.mRuntime.b().getAccount(), false);
        }
        paramJsBridgeListener = this.mRuntime.a(this.mRuntime.d());
        paramString1 = (SwiftBrowserShareMenuHandler)getBrowserComponent(4);
        if ((paramString1 != null) && ((paramJsBridgeListener instanceof WebUiUtils.WebShareInterface)))
        {
          paramJsBridgeListener = (WebUiUtils.WebShareInterface)paramJsBridgeListener;
          paramString2 = (Share)paramJsBridgeListener.getShare();
          if (paramString2 != null)
          {
            if (paramString2.A == null)
            {
              paramString2.A = this.mRuntime.a();
              QLog.w("ShareApiPlugin", 2, "webview from runtime is null");
            }
            if (paramString1.b(paramString2.getShareUrl()))
            {
              if (QLog.isColorLevel())
              {
                QLog.d("ShareApiPlugin", 2, "is not need load share js");
                return true;
              }
            }
            else
            {
              if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.a)) && (!this.c.startsWith("http://")) && (!this.c.startsWith("https://")))
              {
                paramString1 = new Bundle();
                paramString1.putInt("extra_url_info_from", 3);
                paramJsBridgeListener.setSummary(this.b, this.c, this.a, this.d, paramString1);
                return true;
              }
              if (QLog.isColorLevel()) {
                QLog.d("ShareApiPlugin", 2, "Share info imperfect, request from svr");
              }
              paramString1 = new NewIntent(this.mRuntime.b().getApplication(), WebShareServlet.class);
              paramString1.putExtra("extra_cmd", "SQQzoneSvc.getUrlInfo");
              paramString1.putExtra("extra_current_uin", this.mRuntime.b().getAccount());
              paramString1.putExtra("extra_url", paramString2.getShareUrl());
              paramString1.setObserver(new ShareApiPlugin.1(this, paramJsBridgeListener));
              this.mRuntime.b().startServlet(paramString1);
              return true;
            }
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("exception =");
          paramString1.append(paramJsBridgeListener);
          QLog.d("ShareApiPlugin", 2, paramString1.toString());
        }
      }
      return true;
      return false;
      label752:
      int j = 0;
      continue;
      label758:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ShareApiPlugin
 * JD-Core Version:    0.7.0.1
 */