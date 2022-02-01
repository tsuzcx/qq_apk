package com.huawei.hms.framework.network.grs.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.b.c;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class a
{
  public static HttpsURLConnection a(String paramString1, Context paramContext, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramString1 = new URL(paramString1).openConnection();
    if ((paramString1 instanceof HttpsURLConnection))
    {
      paramString1 = (HttpsURLConnection)paramString1;
      try
      {
        paramString1.setSSLSocketFactory(com.huawei.hms.framework.network.grs.c.b.a.a(paramContext));
        paramString1.setHostnameVerifier(c.b);
        paramString1.setConnectTimeout(10000);
        paramString1.setReadTimeout(10000);
        paramContext = com.huawei.hms.framework.network.grs.c.a.b(paramContext, "NetworkKit-grs", paramString2);
        Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is:" + paramContext);
        paramString1.setRequestProperty("User-Agent", paramContext);
        return paramString1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Logger.w("URLConnectionHelper", "init https ssl socket failed.");
        }
      }
    }
    Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.a.a
 * JD-Core Version:    0.7.0.1
 */