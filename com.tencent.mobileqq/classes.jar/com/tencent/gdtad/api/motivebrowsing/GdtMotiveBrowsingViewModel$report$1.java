package com.tencent.gdtad.api.motivebrowsing;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class GdtMotiveBrowsingViewModel$report$1
  implements Runnable
{
  public GdtMotiveBrowsingViewModel$report$1(String paramString) {}
  
  public final void run()
  {
    URLConnection localURLConnection = new URL(this.a).openConnection();
    if ((localURLConnection instanceof HttpURLConnection))
    {
      ((HttpURLConnection)localURLConnection).setRequestMethod("GET");
      ((HttpURLConnection)localURLConnection).setConnectTimeout(10000);
      ((HttpURLConnection)localURLConnection).setReadTimeout(10000);
      ((HttpURLConnection)localURLConnection).setUseCaches(false);
      localURLConnection.connect();
      int i = ((HttpURLConnection)localURLConnection).getResponseCode();
      if (QLog.isColorLevel()) {
        QLog.d("GdtMotiveBrowsingViewModel", 2, "reportBannerAd rspCode" + i);
      }
      ((HttpURLConnection)localURLConnection).disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingViewModel.report.1
 * JD-Core Version:    0.7.0.1
 */