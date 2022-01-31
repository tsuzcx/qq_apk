package com.tencent.biz.pubaccount.readinjoy.ad.utils;

import ajoi;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import yys;
import yyt;
import yyu;

class ReadInJoyAdPingUrlUtil$URLConnection_Ping_Runner
  implements Runnable
{
  private final JSONObject a;
  
  public ReadInJoyAdPingUrlUtil$URLConnection_Ping_Runner(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
  }
  
  public void run()
  {
    label202:
    label207:
    HttpURLConnection localHttpURLConnection;
    for (;;)
    {
      try
      {
        if ((this.a == null) || (TextUtils.isEmpty(this.a.toString())))
        {
          if (!QLog.isColorLevel()) {
            break label473;
          }
          QLog.e("ReadInJoyAdPingUrlUtil", 2, " URLConnection_Ping_Runner input requestJsonBody is null: " + this.a);
          return;
        }
        localObject1 = new URL("https://c.mp.qq.com/api/union/report_new");
        if ((TextUtils.isEmpty("https://c.mp.qq.com/api/union/report_new")) || (!"https://c.mp.qq.com/api/union/report_new".contains("https"))) {
          break label207;
        }
        localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection();
        localObject2 = ajoi.a();
        localObject3 = new StringBuilder().append(" URLConnection_Ping_Runner https sslContext is not null :");
        if (localObject2 != null) {
          break label202;
        }
        bool = true;
        QLog.d("ReadInJoyAdPingUrlUtil", 2, bool);
        if (localObject2 == null) {
          break label474;
        }
        localObject2 = ((SSLContext)localObject2).getSocketFactory();
        ((HttpsURLConnection)localObject1).setSSLSocketFactory((SSLSocketFactory)localObject2);
      }
      catch (Exception localException)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          break label473;
        }
      }
      if (localObject1 != null) {
        break;
      }
      if (!QLog.isColorLevel()) {
        break label473;
      }
      QLog.e("ReadInJoyAdPingUrlUtil", 2, " conn is null: ");
      return;
      QLog.e("ReadInJoyAdPingUrlUtil", 2, "Exception while ping" + localException);
      return;
      boolean bool = false;
      continue;
      localHttpURLConnection = (HttpURLConnection)localException.openConnection();
    }
    localHttpURLConnection.setConnectTimeout(5000);
    localHttpURLConnection.setReadTimeout(5000);
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    Object localObject3 = new StringBuilder();
    if (this.a.has("uin"))
    {
      ((StringBuilder)localObject3).append("sp-cuin=");
      ((StringBuilder)localObject3).append(this.a.get("uin").toString());
    }
    Object localObject2 = new yyt();
    ((yyt)localObject2).a = "ce2d9f";
    localObject2 = yys.a(BaseApplication.getContext(), (yyt)localObject2);
    if (localObject2 != null) {}
    for (localObject2 = ((yyu)localObject2).a;; localObject2 = null)
    {
      if ((localObject2 != null) && (((qq_ad_get.QQAdGet.DeviceInfo)localObject2).client_ipv4.has()))
      {
        ((StringBuilder)localObject3).append(";sp-clientip-union=");
        ((StringBuilder)localObject3).append(((qq_ad_get.QQAdGet.DeviceInfo)localObject2).client_ipv4.get());
      }
      for (;;)
      {
        localHttpURLConnection.setRequestProperty("Cookie", ((StringBuilder)localObject3).toString());
        localObject2 = localHttpURLConnection.getOutputStream();
        localObject3 = new OutputStreamWriter((OutputStream)localObject2, "UTF-8");
        ((OutputStreamWriter)localObject3).write(this.a.toString());
        ((OutputStreamWriter)localObject3).flush();
        ((OutputStreamWriter)localObject3).close();
        ((OutputStream)localObject2).close();
        if (localHttpURLConnection.getResponseCode() != 200) {
          break;
        }
        QLog.d("ReadInJoyAdPingUrlUtil", 2, " URLConnection_Ping_Runner change type 25 sso to cgi success");
        return;
        if (this.a.has("client_ip"))
        {
          ((StringBuilder)localObject3).append(";sp-clientip-union=");
          ((StringBuilder)localObject3).append(this.a.get("client_ip").toString());
        }
      }
      label473:
      return;
      label474:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdPingUrlUtil.URLConnection_Ping_Runner
 * JD-Core Version:    0.7.0.1
 */