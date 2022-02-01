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
    try
    {
      if (TextUtils.isEmpty(this.a)) {
        return;
      }
      Object localObject = (HttpURLConnection)new URL(this.a).openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("POST");
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      boolean bool = false;
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).connect();
      int i = ((HttpURLConnection)localObject).getResponseCode();
      if (i == 200) {
        bool = true;
      }
      localObject = GdtAdWsVideoReport.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("@getGdtInfo exposure rspCode ");
      localStringBuilder.append(i);
      localStringBuilder.append("， request third party");
      localStringBuilder.append(bool);
      localStringBuilder.append(" url =");
      localStringBuilder.append(this.a);
      WSLog.a((String)localObject, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      WSLog.a(GdtAdWsVideoReport.a(), 2, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.GdtAdWsVideoReport.2
 * JD-Core Version:    0.7.0.1
 */