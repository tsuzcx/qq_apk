package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

class Share$1
  implements Runnable
{
  Share$1(Share paramShare, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QConnect rich START. title=");
      ((StringBuilder)localObject1).append(this.this$0.e);
      ((StringBuilder)localObject1).append(", desc=");
      ((StringBuilder)localObject1).append(this.this$0.h);
      ((StringBuilder)localObject1).append(", thumb=");
      ((StringBuilder)localObject1).append(this.this$0.i);
      ((StringBuilder)localObject1).append(", shareURL=");
      ((StringBuilder)localObject1).append(this.a);
      QLog.e("shareWebPage", 2, ((StringBuilder)localObject1).toString());
    }
    int j;
    if (TextUtils.isEmpty(this.this$0.i)) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (TextUtils.isEmpty(this.this$0.h)) {
      i = j | 0x2;
    }
    int n = i;
    if (TextUtils.isEmpty(this.this$0.e)) {
      n = i | 0x4;
    }
    long l2 = System.currentTimeMillis();
    label1484:
    label1491:
    for (;;)
    {
      long l1;
      try
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("report_type", "102");
        ((Bundle)localObject1).putString("act_type", "53");
        ((Bundle)localObject1).putString("intext_3", "1");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(n);
        ((Bundle)localObject1).putString("intext_2", ((StringBuilder)localObject3).toString());
        ((Bundle)localObject1).putString("stringext_1", this.a);
        localObject3 = ReportCenter.a();
        String str2 = this.this$0.G.getAccount();
        l1 = l2;
        try
        {
          ((ReportCenter)localObject3).a((Bundle)localObject1, "", str2, false);
          l1 = l2;
          localObject1 = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { this.this$0.G.getAccount(), URLEncoder.encode(this.a) });
          l1 = l2;
          l2 = System.currentTimeMillis();
          l1 = l2;
          localObject1 = HttpUtil.openRequest(this.this$0.y, (String)localObject1, null, "GET", null, null, 5000, 5000);
          l1 = l2;
          l2 = System.currentTimeMillis() - l2;
          if (localObject1 == null) {
            break label1484;
          }
          l1 = l2;
          if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200) {
            break label1484;
          }
          l1 = l2;
          localObject1 = HttpUtil.readHttpResponse((HttpResponse)localObject1);
          l1 = l2;
          localObject1 = new JSONObject((String)localObject1);
          l1 = l2;
          k = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
          i = k;
          if (i == 0) {
            try
            {
              this.this$0.w = 0;
              try
              {
                localObject3 = ((JSONObject)localObject1).getString("title");
                boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
                if (!bool) {
                  try
                  {
                    if (TextUtils.isEmpty(this.this$0.e)) {
                      this.this$0.e = ((String)localObject3);
                    }
                    j = 4;
                  }
                  catch (Exception localException1)
                  {
                    j = 0;
                    k = 4;
                    l1 = l2;
                    break label753;
                  }
                } else {
                  j = 0;
                }
                try
                {
                  localObject3 = localException1.getString("abstract");
                  bool = TextUtils.isEmpty((CharSequence)localObject3);
                  if (bool) {
                    break label1491;
                  }
                  m = j | 0x2;
                  j = m;
                  i = m;
                  try
                  {
                    if (TextUtils.isEmpty(this.this$0.h))
                    {
                      i = m;
                      this.this$0.h = ((String)localObject3);
                      j = m;
                    }
                    i = j;
                    String str1 = localException1.getString("thumbUrl");
                    m = j;
                    i = j;
                    if (!TextUtils.isEmpty(str1))
                    {
                      j |= 0x1;
                      m = j;
                      i = j;
                      if (TextUtils.isEmpty(this.this$0.i))
                      {
                        i = j;
                        this.this$0.i = str1;
                        i = j;
                        this.this$0.p = false;
                        i = j;
                        this.this$0.q = 0;
                        m = j;
                      }
                    }
                    i = 0;
                  }
                  catch (Exception localException2)
                  {
                    m = k;
                    k = i;
                  }
                  j = 0;
                }
                catch (Exception localException3)
                {
                  k = j;
                  m = i;
                }
                i = m;
                l1 = l2;
              }
              catch (Exception localException4)
              {
                j = 0;
                l1 = l2;
                break label751;
              }
              i = 1;
            }
            catch (Exception localException5)
            {
              j = 1;
              l1 = l2;
            }
          }
          m = 0;
          l1 = l2;
        }
        catch (Exception localException6) {}
        j = 1;
      }
      catch (Exception localException7)
      {
        l1 = l2;
      }
      i = 0;
      label751:
      int k = 0;
      label753:
      localException7.printStackTrace();
      int m = k;
      k = i;
      i = j;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("QConnect rich END. title=");
        ((StringBuilder)localObject2).append(this.this$0.e);
        ((StringBuilder)localObject2).append(", desc=");
        ((StringBuilder)localObject2).append(this.this$0.h);
        ((StringBuilder)localObject2).append(", thumb=");
        ((StringBuilder)localObject2).append(this.this$0.i);
        ((StringBuilder)localObject2).append(", shareURL=");
        ((StringBuilder)localObject2).append(this.a);
        QLog.e("shareWebPage", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "13");
      ((Bundle)localObject2).putString("intext_3", "1");
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(i);
      ((Bundle)localObject2).putString("intext_1", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(k);
      ((Bundle)localObject2).putString("stringext_2", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(l1);
      ((Bundle)localObject2).putString("intext_5", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(n);
      ((Bundle)localObject2).putString("intext_2", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(m);
      ((Bundle)localObject2).putString("intext_4", ((StringBuilder)localObject3).toString());
      if (i > 0) {
        ((Bundle)localObject2).putString("stringext_1", this.a);
      }
      ReportCenter.a().a((Bundle)localObject2, "", this.this$0.G.getAccount(), false);
      localObject2 = new Bundle();
      if (TextUtils.isEmpty(this.this$0.i)) {
        j = 1;
      } else {
        j = 0;
      }
      i = j;
      if (TextUtils.isEmpty(this.this$0.h)) {
        i = j | 0x2;
      }
      j = i;
      if (TextUtils.isEmpty(this.this$0.e)) {
        j = i | 0x4;
      }
      ((Bundle)localObject2).putString("report_type", "102");
      ((Bundle)localObject2).putString("act_type", "92");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      if (j == 0) {
        i = 0;
      } else {
        i = 1;
      }
      ((StringBuilder)localObject3).append(i);
      ((Bundle)localObject2).putString("intext_1", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(k);
      ((Bundle)localObject2).putString("intext_4", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(ReportDef.RepUtil.b(this.b));
      ((Bundle)localObject2).putString("intext_3", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(j);
      ((Bundle)localObject2).putString("intext_2", ((StringBuilder)localObject3).toString());
      ((Bundle)localObject2).putString("stringext_1", this.a);
      ReportCenter.a().a((Bundle)localObject2, "", this.this$0.G.getAccount(), false);
      localObject2 = Share.a(this.this$0, this.a, this.b);
      if ((TextUtils.isEmpty(this.this$0.i)) && (localObject2 != null))
      {
        ThreadManager.getUIHandler().post(new Share.1.1(this, (SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)localObject2));
        return;
      }
      Share.a(this.this$0, this.a, this.b, this.c);
      return;
      localObject2 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.1
 * JD-Core Version:    0.7.0.1
 */