package com.tencent.biz.pubaccount.weishi_new.verticalvideo.report;

import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import uya;
import vdo;

public final class GdtAdWsVideoReport$1
  implements Runnable
{
  public GdtAdWsVideoReport$1(String paramString) {}
  
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
          uya.a(vdo.a(), "@getGdtInfo exporsure rspCode " + i + "， request thirdparty" + bool + " url =" + this.a);
          return;
        }
      }
      catch (Exception localException)
      {
        uya.a(vdo.a(), 2, localException.toString());
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport.1
 * JD-Core Version:    0.7.0.1
 */