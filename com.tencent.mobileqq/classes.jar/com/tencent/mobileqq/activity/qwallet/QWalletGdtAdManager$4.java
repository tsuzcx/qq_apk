package com.tencent.mobileqq.activity.qwallet;

import akmh;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

public class QWalletGdtAdManager$4
  implements Runnable
{
  public QWalletGdtAdManager$4(akmh paramakmh, String paramString) {}
  
  public void run()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setInstanceFollowRedirects(true);
      localHttpURLConnection.connect();
      int i = localHttpURLConnection.getResponseCode();
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 1, "reportUrlByHttpGet rspCode" + i + ",reportUrl:" + this.a);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QWalletGdtAdManager", 2, "reportUrlByHttpGet error, url = " + this.a, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.4
 * JD-Core Version:    0.7.0.1
 */