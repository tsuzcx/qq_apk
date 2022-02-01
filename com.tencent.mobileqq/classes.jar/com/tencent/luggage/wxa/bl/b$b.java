package com.tencent.luggage.wxa.bl;

import android.content.Context;
import android.text.TextUtils;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.d.d.a;
import com.tencent.luggage.wxa.lr.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

final class b$b
  implements com.tencent.luggage.wxa.d.d
{
  private int a = 60000;
  private int b = 60000;
  private final String c;
  private WeakReference<com.tencent.luggage.wxa.iu.d> d;
  
  public b$b(com.tencent.luggage.wxa.iu.d paramd)
  {
    this.d = new WeakReference(paramd);
    paramd = (com.tencent.luggage.wxa.nz.a)paramd.b(com.tencent.luggage.wxa.nz.a.class);
    a(paramd.f, paramd.f);
    this.c = paramd.u;
  }
  
  private ImageDecodeConfig.ReferrerPolicy a(c paramc)
  {
    if (paramc == null) {
      return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    }
    if (paramc == c.b) {
      return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
    }
    if (paramc == c.a) {
      return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
    }
    return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
  }
  
  private HttpURLConnection a(String paramString1, String paramString2, ImageDecodeConfig paramImageDecodeConfig, d.a parama)
  {
    int i = 0;
    for (;;)
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
      if ((paramImageDecodeConfig != null) && (!TextUtils.isEmpty(paramString2))) {
        localHttpURLConnection.addRequestProperty("Referer", paramString2);
      }
      localHttpURLConnection.setRequestProperty("User-Agent", this.c);
      localHttpURLConnection.setReadTimeout(this.b);
      localHttpURLConnection.setConnectTimeout(this.a);
      int j = localHttpURLConnection.getResponseCode();
      if ((j != 301) && (j != 302))
      {
        if ((j < 200) || (j >= 300)) {
          parama.b = String.format(r.a().getString(2131886940), new Object[] { Integer.valueOf(j) });
        }
        return localHttpURLConnection;
      }
      String str = localHttpURLConnection.getHeaderField("location");
      o.d("AppBrandImageHttpFetcher", "redirect from[%s] to[%s]", new Object[] { paramString1, str });
      localHttpURLConnection.disconnect();
      if (str == null) {
        return null;
      }
      if (i >= 3)
      {
        o.b("AppBrandImageHttpFetcher", "too much redirection!");
        parama.b = r.a().getString(2131886942);
        return null;
      }
      paramString1 = str;
      i += 1;
    }
  }
  
  public d.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    d.a locala = new d.a();
    com.tencent.luggage.wxa.iu.d locald = (com.tencent.luggage.wxa.iu.d)this.d.get();
    Object localObject3 = null;
    if (locald != null)
    {
      com.tencent.luggage.wxa.lr.a locala1 = (com.tencent.luggage.wxa.lr.a)e.a(com.tencent.luggage.wxa.lr.a.class);
      Object localObject2 = paramImageDecodeConfig.mReferrerPolicy;
      if (locala1 != null)
      {
        localObject1 = localObject2;
        if (localObject2 == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
          localObject1 = a(locala1.a(locald.ae()));
        }
        localObject2 = localObject1;
        if (localObject1 == ImageDecodeConfig.ReferrerPolicy.NOT_SET) {
          localObject2 = a(locala1.a());
        }
        if (localObject2 == ImageDecodeConfig.ReferrerPolicy.ORIGIN)
        {
          localObject1 = locala1.b(locald.ae());
          break label134;
        }
      }
      else
      {
        o.c("AppBrandImageHttpFetcher", "referrer helper is null");
      }
    }
    Object localObject1 = null;
    try
    {
      label134:
      localObject1 = a((String)paramObject, (String)localObject1, paramImageDecodeConfig, locala);
      paramImageDecodeConfig = localObject3;
      if (localObject1 != null)
      {
        paramImageDecodeConfig = localObject3;
        if (TextUtils.isEmpty(locala.b)) {
          paramImageDecodeConfig = new BufferedInputStream(((HttpURLConnection)localObject1).getInputStream());
        }
      }
    }
    catch (Exception paramImageDecodeConfig)
    {
      o.b("AppBrandImageHttpFetcher", "fetch error. path = [%s], error = [%s]", new Object[] { paramObject, paramImageDecodeConfig.toString() });
      locala.b = String.format(r.a().getString(2131886941), new Object[] { paramImageDecodeConfig.toString() });
      paramImageDecodeConfig = localObject3;
    }
    catch (SocketTimeoutException paramImageDecodeConfig)
    {
      o.b("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", new Object[] { paramObject, Integer.valueOf(this.a), Integer.valueOf(this.b), paramImageDecodeConfig.toString() });
      locala.b = r.a().getString(2131886943);
      paramImageDecodeConfig = localObject3;
    }
    locala.a = paramImageDecodeConfig;
    return locala;
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
      this.a = paramInt1;
      this.b = paramInt2;
      o.d("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
 * Qualified Name:     com.tencent.luggage.wxa.bl.b.b
 * JD-Core Version:    0.7.0.1
 */