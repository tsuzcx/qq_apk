package com.tencent.biz;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListRequset;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

class AuthorizeConfig$2
  implements Runnable
{
  AuthorizeConfig$2(AuthorizeConfig paramAuthorizeConfig, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {}
    try
    {
      Thread.sleep(5000L);
    }
    catch (InterruptedException localInterruptedException)
    {
      label16:
      Object localObject1;
      Object localObject3;
      Object localObject4;
      String str;
      Object localObject2;
      break label16;
    }
    this.this$0.c.set(0);
    return;
    localObject1 = this.this$0.w;
    localObject3 = null;
    localObject1 = ((SharedPreferences)localObject1).getString("qqVersion", null);
    localObject4 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject4 != null)
    {
      str = this.this$0.w.getString("lastVersion", null);
      localObject3 = new mobileqq_mp.WebviewWhiteListRequset();
      if ((!TextUtils.isEmpty(str)) && ("2013 8.8.17".equals(localObject1)))
      {
        ((mobileqq_mp.WebviewWhiteListRequset)localObject3).version.set(str);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Local white list version=");
          ((StringBuilder)localObject1).append(str);
          QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        if (TextUtils.isEmpty(str)) {
          localObject1 = "Local white list may not exist";
        } else {
          localObject1 = "QQ version changed so ignore version of local white list";
        }
        QLog.d("AuthorizeConfig", 2, (String)localObject1);
      }
      ((mobileqq_mp.WebviewWhiteListRequset)localObject3).qqversion.set("8.8.17");
      ((mobileqq_mp.WebviewWhiteListRequset)localObject3).gziped.set(true);
      ((mobileqq_mp.WebviewWhiteListRequset)localObject3).implat.set(109);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("send whitelist request， lastversion: ");
        ((StringBuilder)localObject1).append(((mobileqq_mp.WebviewWhiteListRequset)localObject3).version.get());
        ((StringBuilder)localObject1).append(", qq version: ");
        ((StringBuilder)localObject1).append(((mobileqq_mp.WebviewWhiteListRequset)localObject3).qqversion.get());
        ((StringBuilder)localObject1).append(", isGzip: ");
        ((StringBuilder)localObject1).append(((mobileqq_mp.WebviewWhiteListRequset)localObject3).gziped.get());
        QLog.i("AuthorizeConfig", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new NewIntent(this.this$0.v, AuthorizeConfigServlet.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("cmd", "JsApiSvr.webview.whitelist");
      try
      {
        ((NewIntent)localObject1).putExtra("data", ((mobileqq_mp.WebviewWhiteListRequset)localObject3).toByteArray());
        AuthorizeConfig.a(this.this$0, (NewIntent)localObject1);
        ((AppRuntime)localObject4).startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception localException1)
      {
        QLog.d("AuthorizeConfig", 1, "toByteArray failed", localException1);
        this.this$0.c.set(0);
        return;
      }
    }
    localObject4 = this.this$0.w.getString("lastMod", null);
    if ((localObject4 != null) && (((String)localObject4).length() > 0) && ("2013 8.8.17".equals(localException1)))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("If-Modified-Since", (String)localObject4);
    }
    else
    {
      localObject2 = null;
    }
    localObject4 = Uri.parse("https://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json").getHost();
    str = MsfSdkUtils.insertMtype("qb_offline", "https://pub.idqqimg.com/qqmobile/config/webview_whitelist2.json");
    try
    {
      localObject4 = HttpUtil.openRequest(this.this$0.v, str, (String)localObject4, "GET", null, (Bundle)localObject2);
      if (localObject4 != null)
      {
        int i = ((HttpResponse)localObject4).getStatusLine().getStatusCode();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("status code: ");
          ((StringBuilder)localObject2).append(String.valueOf(i));
          QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject2).toString());
        }
        if (i == 200)
        {
          localObject2 = ((HttpResponse)localObject4).getFirstHeader("Last-Modified");
          if (localObject2 == null) {
            localObject2 = localObject3;
          } else {
            localObject2 = ((Header)localObject2).getValue();
          }
          localObject3 = HttpUtil.readHttpResponse((HttpResponse)localObject4);
          this.this$0.a((String)localObject3, (String)localObject2, "lastMod");
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_success", 1, 1, 0, "", "", "", "");
          return;
        }
        if (i == 304)
        {
          this.this$0.c.set(2);
          this.this$0.w.edit().putLong("lastUpdate", System.currentTimeMillis()).commit();
          ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_not_modify", 1, 1, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("update error: ");
        ((StringBuilder)localObject3).append(localException2);
        QLog.d("AuthorizeConfig", 2, ((StringBuilder)localObject3).toString());
      }
      this.this$0.c.set(0);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 1, 1, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.2
 * JD-Core Version:    0.7.0.1
 */