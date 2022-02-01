package com.tencent.biz.subscribe;

import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.net.HttpURLConnection;
import java.net.URL;
import yuk;

public final class SubscribeUtils$2
  implements Runnable
{
  public SubscribeUtils$2(String paramString) {}
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.a)) {
        return;
      }
      localURL = new URL(this.a);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.connect();
      i = localHttpURLConnection.getResponseCode();
      if (i != 200) {
        break label176;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        URL localURL;
        int i;
        yuk.c("SubscribeUtils", "report exception" + localException.toString());
        if (!QZLog.isColorLevel()) {
          break;
        }
        QZLog.w("SubscribeUtils", 2, new Object[] { localException.toString() });
        return;
        label176:
        boolean bool = false;
      }
    }
    yuk.c("SubscribeUtils", "report rspCode " + i + "， request thirdparty" + bool + " url =" + localURL);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.2
 * JD-Core Version:    0.7.0.1
 */