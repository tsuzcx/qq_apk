package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

class ShareApiPlugin$1
  implements BusinessObserver
{
  ShareApiPlugin$1(ShareApiPlugin paramShareApiPlugin, WebUiUtils.WebShareInterface paramWebShareInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive, getUrlInfo, isSuccess=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("ShareApiPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Bundle();
    if (paramBoolean)
    {
      Object localObject2;
      if ((TextUtils.isEmpty(this.b.c)) || (this.b.c.startsWith("http://")) || (this.b.c.startsWith("https://")))
      {
        localObject2 = paramBundle.getString("extra_summary");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.b.c = ((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "Use share summary parsed by server");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ShareApiPlugin", 2, "Server can't resolve summary");
        }
      }
      if (TextUtils.isEmpty(this.b.d))
      {
        localObject2 = paramBundle.getStringArrayList("extra_images");
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          this.b.d = ((String)((ArrayList)localObject2).get(0));
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "Use share thumb parsed by server");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ShareApiPlugin", 2, "Server can't resolve thumb");
        }
      }
      if (TextUtils.isEmpty(this.b.b))
      {
        localObject2 = paramBundle.getString("extra_title");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.b.b = ((String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "Use share title parsed by server");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ShareApiPlugin", 2, "Server can't resolve title");
        }
      }
      if (TextUtils.isEmpty(this.b.a))
      {
        paramBundle = paramBundle.getString("extra_url");
        if (!TextUtils.isEmpty(paramBundle))
        {
          this.b.a = paramBundle;
          if (QLog.isColorLevel()) {
            QLog.d("ShareApiPlugin", 2, "Use share url parsed by server");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ShareApiPlugin", 2, "Server can't resolve url");
        }
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Share info after QZone rich: title=");
        paramBundle.append(this.b.b);
        paramBundle.append(", summary=");
        paramBundle.append(this.b.c);
        paramBundle.append(", thumb=");
        paramBundle.append(this.b.d);
        paramBundle.append(", shareURL=");
        paramBundle.append(this.b.a);
        QLog.e("shareWebPage", 2, paramBundle.toString());
      }
      ((Bundle)localObject1).putInt("extra_url_info_from", 5);
    }
    else
    {
      ((Bundle)localObject1).putInt("extra_url_info_from", 3);
    }
    this.a.setSummary(this.b.b, this.b.c, this.b.a, this.b.d, (Bundle)localObject1);
    paramBoolean = TextUtils.isEmpty(this.b.d);
    int j = 1;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    paramInt = i;
    if (TextUtils.isEmpty(this.b.c)) {
      paramInt = i | 0x2;
    }
    int i = paramInt;
    if (TextUtils.isEmpty(this.b.b)) {
      i = paramInt | 0x4;
    }
    paramBundle = new Bundle();
    paramBundle.putString("report_type", "102");
    paramBundle.putString("act_type", "91");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    paramInt = j;
    if (i == 0) {
      paramInt = 0;
    }
    ((StringBuilder)localObject1).append(paramInt);
    paramBundle.putString("intext_1", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(i);
    paramBundle.putString("intext_2", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(this.b.a);
    paramBundle.putString("stringext_1", ((StringBuilder)localObject1).toString());
    ReportCenter.a().a(paramBundle, "", this.b.mRuntime.b().getAccount(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ShareApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */