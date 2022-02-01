package com.tencent.luggage.wxa.d;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.c.b;
import java.io.BufferedInputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

public class c
  implements d
{
  private static final String a = "NativeImageHttpFetcher";
  private static final int b = 60000;
  private int c = 60000;
  private int d = 60000;
  
  public d.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    paramImageDecodeConfig = new d.a();
    try
    {
      URLConnection localURLConnection = new URL((String)paramObject).openConnection();
      localURLConnection.setReadTimeout(this.d);
      localURLConnection.setConnectTimeout(this.c);
      paramImageDecodeConfig.a = new BufferedInputStream(localURLConnection.getInputStream());
      return paramImageDecodeConfig;
    }
    catch (Exception localException)
    {
      paramImageDecodeConfig.b = "http请求出现错误";
      b.d("NativeImageHttpFetcher", "fetch error. path = [%s], error = [%s]", new Object[] { paramObject, localException.toString() });
      return paramImageDecodeConfig;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      paramImageDecodeConfig.b = "http请求超时";
      b.d("NativeImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.c), Integer.valueOf(this.d), localSocketTimeoutException.toString() });
    }
    return paramImageDecodeConfig;
  }
  
  public String a()
  {
    return "http";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      this.c = paramInt1;
      this.d = paramInt2;
      b.b("NativeImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
  }
  
  public boolean a(Object paramObject)
  {
    boolean bool2 = paramObject instanceof String;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramObject = (String)paramObject;
    if ((paramObject.startsWith("http://")) || (paramObject.startsWith("https://"))) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.d.c
 * JD-Core Version:    0.7.0.1
 */