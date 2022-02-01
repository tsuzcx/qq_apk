package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.text.TextUtils;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
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

class ReadInJoyAdReportUtil$ReportJob
  implements Runnable
{
  private final JSONObject a;
  
  public ReadInJoyAdReportUtil$ReportJob(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if ((this.a != null) && (!TextUtils.isEmpty(this.a.toString())))
        {
          localObject1 = new URL("https://c.mp.qq.com/api/union/report_new");
          bool = TextUtils.isEmpty("https://c.mp.qq.com/api/union/report_new");
          if (!bool)
          {
            localObject2 = (HttpsURLConnection)((URL)localObject1).openConnection();
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getSLLContext();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(" URLConnection_Ping_Runner https sslContext is not null :");
            if (localObject3 != null) {
              break label473;
            }
            bool = true;
            ((StringBuilder)localObject1).append(bool);
            QLog.d("ReadInJoyAdPingUrlUtil", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
            if (localObject3 != null)
            {
              localObject1 = ((SSLContext)localObject3).getSocketFactory();
              ((HttpsURLConnection)localObject2).setSSLSocketFactory((SSLSocketFactory)localObject1);
              localObject1 = localObject2;
            }
          }
          else
          {
            localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
          }
          if (localObject1 == null)
          {
            ReadInJoyAdReportUtil.a(" conn is null: ");
            return;
          }
          ((HttpURLConnection)localObject1).setConnectTimeout(5000);
          ((HttpURLConnection)localObject1).setReadTimeout(5000);
          ((HttpURLConnection)localObject1).setRequestMethod("POST");
          ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
          Object localObject3 = new StringBuilder();
          if (this.a.has("uin"))
          {
            ((StringBuilder)localObject3).append("sp-cuin=");
            ((StringBuilder)localObject3).append(this.a.get("uin").toString());
          }
          localObject2 = new GdtDeviceInfoHelper.Params();
          ((GdtDeviceInfoHelper.Params)localObject2).a = "ce2d9f";
          localObject2 = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject2);
          if (localObject2 != null) {
            localObject2 = ((GdtDeviceInfoHelper.Result)localObject2).a;
          } else {
            localObject2 = null;
          }
          if ((localObject2 != null) && (((qq_ad_get.QQAdGet.DeviceInfo)localObject2).client_ipv4.has()))
          {
            ((StringBuilder)localObject3).append(";sp-clientip-union=");
            ((StringBuilder)localObject3).append(((qq_ad_get.QQAdGet.DeviceInfo)localObject2).client_ipv4.get());
          }
          else if (this.a.has("client_ip"))
          {
            ((StringBuilder)localObject3).append(";sp-clientip-union=");
            ((StringBuilder)localObject3).append(this.a.get("client_ip").toString());
          }
          ((HttpURLConnection)localObject1).setRequestProperty("Cookie", ((StringBuilder)localObject3).toString());
          localObject2 = ((HttpURLConnection)localObject1).getOutputStream();
          localObject3 = new OutputStreamWriter((OutputStream)localObject2, "UTF-8");
          ((OutputStreamWriter)localObject3).write(this.a.toString());
          ((OutputStreamWriter)localObject3).flush();
          ((OutputStreamWriter)localObject3).close();
          ((OutputStream)localObject2).close();
          if (((HttpURLConnection)localObject1).getResponseCode() == 200) {
            QLog.d("ReadInJoyAdPingUrlUtil", 2, " URLConnection_Ping_Runner change type 25 sso to cgi success");
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" URLConnection_Ping_Runner input requestJsonBody is null: ");
          ((StringBuilder)localObject1).append(this.a);
          ReadInJoyAdReportUtil.a(((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Exception while ping");
        ((StringBuilder)localObject2).append(localException);
        ReadInJoyAdReportUtil.a(((StringBuilder)localObject2).toString());
      }
      return;
      label473:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdReportUtil.ReportJob
 * JD-Core Version:    0.7.0.1
 */