package com.tencent.biz.webviewplugin;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.ScreenShotCallback;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

class Share$1$1$1
  implements SwiftBrowserMiscHandler.ScreenShotCallback
{
  Share$1$1$1(Share.1.1 param1) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WebView screenshot CALLBACK. imgUrl=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("shareWebPage", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = "intext_3";
    if (!bool) {}
    try
    {
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      localObject1 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
      this.a.b.this$0.x = new SoftReference(localObject1);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label104:
      Object localObject4;
      Object localObject3;
      Object localObject2;
      long l2;
      Object localObject5;
      long l1;
      Object localObject6;
      int i;
      HashMap localHashMap;
      int j;
      int k;
      break label104;
    }
    if (QLog.isColorLevel()) {
      QLog.e("shareWebPage", 2, "WebView screenshot OutOfMemoryError.");
    }
    localObject4 = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    localObject3 = this.a.b.this$0.G.getAccount();
    localObject2 = ((TicketManager)localObject4).getSkey((String)localObject3);
    l2 = System.currentTimeMillis();
    localObject1 = null;
    localObject5 = new File(paramString);
    if (((File)localObject5).exists()) {
      l1 = ((File)localObject5).length();
    } else {
      l1 = 0L;
    }
    localObject5 = FileUtils.calcMd5(paramString);
    if ((l1 > 0L) && (!TextUtils.isEmpty((CharSequence)localObject5))) {
      localObject1 = HttpUtil.queryImageByIP(NetworkUtil.a(String.format(Locale.getDefault(), "https://cgi.connect.qq.com/qqconnectopen/query_share_image?key=%s&size=%d&short_url=0", new Object[] { localObject5, Long.valueOf(l1) }), 1007), (String)localObject3, (String)localObject2);
    }
    l1 = System.currentTimeMillis() - l2;
    if (localObject1 == null) {
      localObject1 = new Pair(Integer.valueOf(-1), "");
    }
    if (QLog.isColorLevel())
    {
      localObject5 = Share.a;
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("queryImage, ret=");
      ((StringBuilder)localObject6).append(((Pair)localObject1).first);
      ((StringBuilder)localObject6).append(",cost=");
      ((StringBuilder)localObject6).append(l1);
      ((StringBuilder)localObject6).append(",url=");
      ((StringBuilder)localObject6).append((String)((Pair)localObject1).second);
      QLog.d((String)localObject5, 2, ((StringBuilder)localObject6).toString());
    }
    localObject5 = new Bundle();
    ((Bundle)localObject5).putString("report_type", "102");
    ((Bundle)localObject5).putString("act_type", "16");
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("");
    ((StringBuilder)localObject6).append(((Pair)localObject1).first);
    ((Bundle)localObject5).putString("intext_1", ((StringBuilder)localObject6).toString());
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("");
    if (((Integer)((Pair)localObject1).first).intValue() == -1) {
      i = 0;
    } else {
      i = ((Integer)((Pair)localObject1).first).intValue();
    }
    ((StringBuilder)localObject6).append(i);
    ((Bundle)localObject5).putString("intext_2", ((StringBuilder)localObject6).toString());
    localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("");
    ((StringBuilder)localObject6).append(l1);
    ((Bundle)localObject5).putString("intext_5", ((StringBuilder)localObject6).toString());
    ReportCenter.a().a((Bundle)localObject5, "", (String)localObject3, false);
    if (!TextUtils.isEmpty((CharSequence)((Pair)localObject1).second))
    {
      this.a.b.this$0.i = ((String)((Pair)localObject1).second);
      this.a.b.this$0.p = false;
      this.a.b.this$0.q = 0;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WebView screenshot UPLOAD. length=");
        ((StringBuilder)localObject1).append(new File(paramString).length());
        QLog.e("shareWebPage", 2, ((StringBuilder)localObject1).toString());
      }
      localObject6 = new HashMap();
      ((Map)localObject6).put("Connection", "keep-alive");
      ((Map)localObject6).put("Referer", "https://www.qq.com");
      ((Map)localObject6).put("Host", "cgi.connect.qq.com");
      localObject1 = ((TicketManager)localObject4).getPskey((String)localObject3, "cgi.connect.qq.com");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("p_uin=");
        ((StringBuilder)localObject4).append((String)localObject3);
        ((StringBuilder)localObject4).append(";p_skey=");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((Map)localObject6).put("Cookie", ((StringBuilder)localObject4).toString());
      }
      localHashMap = new HashMap();
      localHashMap.put("share_image", paramString);
      paramString = new Bundle();
      paramString.putString("report_type", "102");
      paramString.putString("act_type", "51");
      localObject5 = "intext_3";
      paramString.putString((String)localObject5, "1");
      localObject1 = this.a.b.a;
      localObject4 = "stringext_1";
      paramString.putString((String)localObject4, (String)localObject1);
      ReportCenter.a().a(paramString, "", (String)localObject3, false);
      l1 = System.currentTimeMillis();
      localObject1 = HttpUtil.uploadImageWithHttps(NetworkUtil.a("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", 1007), "cgi.connect.qq.com", (String)localObject3, (String)localObject2, null, localHashMap, (Map)localObject6, false);
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = HttpUtil.uploadImageWithHttps("https://cgi.connect.qq.com/qqconnectopen/upload_share_image", "cgi.connect.qq.com", (String)localObject3, (String)localObject2, null, localHashMap, (Map)localObject6, true);
      }
      if (paramString != null)
      {
        try
        {
          paramString = new JSONObject(paramString);
          j = paramString.getInt("retcode");
          i = j;
          if (j != 0) {
            break label1118;
          }
          i = j;
          try
          {
            if (!paramString.has("result")) {
              break label1118;
            }
            paramString = paramString.getJSONObject("result").getString("url");
            i = j;
            if (TextUtils.isEmpty(paramString)) {
              break label1118;
            }
            this.a.b.this$0.i = paramString;
            this.a.b.this$0.p = false;
            this.a.b.this$0.q = 0;
            k = 0;
            i = j;
          }
          catch (JSONException paramString) {}
          i = j;
        }
        catch (JSONException paramString)
        {
          j = 0;
        }
        if (QLog.isColorLevel())
        {
          QLog.d(Share.a, 2, paramString.getMessage());
          i = j;
        }
        label1118:
        k = 1;
      }
      else
      {
        k = 1;
        i = 0;
      }
      l2 = System.currentTimeMillis();
      paramString = new Bundle();
      paramString.putString("report_type", "102");
      paramString.putString("act_type", "11");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(k);
      paramString.putString("intext_1", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(i);
      paramString.putString("intext_2", ((StringBuilder)localObject1).toString());
      paramString.putString((String)localObject5, "1");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(l2 - l1);
      paramString.putString("intext_5", ((StringBuilder)localObject1).toString());
      if (k == 1) {
        paramString.putString((String)localObject4, this.a.b.a);
      }
      ReportCenter.a().a(paramString, "", (String)localObject3, false);
    }
    localObject3 = "stringext_1";
    localObject2 = "intext_3";
    localObject1 = localObject2;
    paramString = (String)localObject3;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("Share info after WebView screenshot: title=");
      paramString.append(this.a.b.this$0.e);
      paramString.append(", summary=");
      paramString.append(this.a.b.this$0.h);
      paramString.append(", thumb=");
      paramString.append(this.a.b.this$0.i);
      paramString.append(", shareURL=");
      paramString.append(this.a.b.a);
      QLog.e("shareWebPage", 2, paramString.toString());
      localObject1 = localObject2;
      paramString = (String)localObject3;
      break label1467;
      paramString = "stringext_1";
    }
    label1467:
    k = 1;
    localObject2 = new Bundle();
    if (TextUtils.isEmpty(this.a.b.this$0.i)) {
      j = 1;
    } else {
      j = 0;
    }
    i = j;
    if (TextUtils.isEmpty(this.a.b.this$0.h)) {
      i = j | 0x2;
    }
    j = i;
    if (TextUtils.isEmpty(this.a.b.this$0.e)) {
      j = i | 0x4;
    }
    ((Bundle)localObject2).putString("report_type", "102");
    ((Bundle)localObject2).putString("act_type", "93");
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    i = k;
    if (j == 0) {
      i = 0;
    }
    ((StringBuilder)localObject3).append(i);
    ((Bundle)localObject2).putString("intext_1", ((StringBuilder)localObject3).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(ReportDef.RepUtil.b(this.a.b.b));
    ((Bundle)localObject2).putString((String)localObject1, ((StringBuilder)localObject3).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(j);
    ((Bundle)localObject2).putString("intext_2", ((StringBuilder)localObject1).toString());
    ((Bundle)localObject2).putString(paramString, this.a.b.a);
    ReportCenter.a().a((Bundle)localObject2, "", this.a.b.this$0.G.getAccount(), false);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("WebView screenshot END. thumb=");
      paramString.append(this.a.b.this$0.i);
      QLog.e("shareWebPage", 2, paramString.toString());
    }
    Share.a(this.a.b.this$0, this.a.b.a, this.a.b.b, this.a.b.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.1.1.1
 * JD-Core Version:    0.7.0.1
 */