package com.tencent.biz.pubaccount.weishi_new.verticalvideo.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class GdtAdWsVideoReport$2
  implements Runnable
{
  GdtAdWsVideoReport$2(String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(this.a)) {
          return;
        }
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setReadTimeout(10000);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.connect();
        int i = localHttpURLConnection.getResponseCode();
        if (i == 200)
        {
          bool = true;
          WSLog.a(GdtAdWsVideoReport.a(), "@getGdtInfo exporsure rspCode " + i + "， request thirdparty" + bool + " url =" + this.a);
          return;
        }
      }
      catch (Exception localException)
      {
        WSLog.a(GdtAdWsVideoReport.a(), 2, localException.toString());
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport.2
 * JD-Core Version:    0.7.0.1
 */