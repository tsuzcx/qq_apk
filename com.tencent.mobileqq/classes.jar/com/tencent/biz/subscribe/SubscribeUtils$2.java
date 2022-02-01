package com.tencent.biz.subscribe;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import cooperation.qzone.util.QZLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class SubscribeUtils$2
  implements Runnable
{
  SubscribeUtils$2(String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(this.a)) {
          return;
        }
        URL localURL = new URL(this.a);
        localObject = (HttpURLConnection)localURL.openConnection();
        ((HttpURLConnection)localObject).setRequestMethod("GET");
        ((HttpURLConnection)localObject).setConnectTimeout(10000);
        ((HttpURLConnection)localObject).setReadTimeout(10000);
        ((HttpURLConnection)localObject).setUseCaches(false);
        ((HttpURLConnection)localObject).connect();
        int i = ((HttpURLConnection)localObject).getResponseCode();
        if (i == 200)
        {
          bool = true;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("report rspCode ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("， request thirdparty");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(" url =");
          ((StringBuilder)localObject).append(localURL);
          SLog.c("SubscribeUtils", ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report exception");
        ((StringBuilder)localObject).append(localException.toString());
        SLog.c("SubscribeUtils", ((StringBuilder)localObject).toString());
        if (QZLog.isColorLevel()) {
          QZLog.w("SubscribeUtils", 2, new Object[] { localException.toString() });
        }
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeUtils.2
 * JD-Core Version:    0.7.0.1
 */