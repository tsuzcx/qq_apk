package com.tencent.mobileqq.activity.qwallet;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

class QWalletGdtAdManager$4
  implements Runnable
{
  QWalletGdtAdManager$4(QWalletGdtAdManager paramQWalletGdtAdManager, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager.4
 * JD-Core Version:    0.7.0.1
 */