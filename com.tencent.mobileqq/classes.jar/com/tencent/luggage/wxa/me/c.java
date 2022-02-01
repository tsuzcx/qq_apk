package com.tencent.luggage.wxa.me;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.ma.k;
import com.tencent.luggage.wxa.mf.b;
import com.tencent.luggage.wxa.mf.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class c
{
  private static AtomicInteger c = new AtomicInteger(10000);
  private static AtomicInteger d = new AtomicInteger(10000);
  private int a;
  private boolean b;
  private com.tencent.luggage.wxa.md.a e;
  private int f;
  private final ExecutorService g;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://127.0.0.1:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
  
  public String a(String paramString)
  {
    return a(paramString, true, true, "video/mp4", 90);
  }
  
  public String a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, int paramInt)
  {
    String str;
    StringBuilder localStringBuilder;
    if ((com.tencent.luggage.wxa.mc.a.a().d()) && (this.a <= 3) && (!this.g.isShutdown()) && (!this.g.isTerminated()))
    {
      str = paramString1;
      boolean bool = paramBoolean2;
      if (!URLUtil.isHttpUrl(paramString1))
      {
        str = paramString1;
        bool = paramBoolean2;
        if (!URLUtil.isHttpsUrl(paramString1))
        {
          str = b.c(paramString1);
          if (b.d(str)) {
            paramString1 = str;
          }
          while (b.e(str))
          {
            bool = false;
            str = paramString1;
            break;
          }
          return str;
        }
      }
      localObject = paramString2;
      if (k.a(str))
      {
        if (!com.tencent.luggage.wxa.mc.a.a().e())
        {
          b.a(4, "VideoProxy", "getUrl, hls proxy disabled");
          return str;
        }
        localObject = "application/vnd.apple.mpegurl";
        bool = false;
      }
      try
      {
        paramString1 = URLEncoder.encode(str, "UTF-8");
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("invalid url ");
        paramString2.append(b.a(paramString1));
        b.a(6, "VideoProxy", paramString2.toString());
        paramString1 = "";
      }
      if (TextUtils.isEmpty(paramString1))
      {
        paramString2 = new StringBuilder();
        paramString2.append("url is empty ");
        paramString2.append(paramString1);
        b.a(6, "VideoProxy", paramString2.toString());
        return str;
      }
      paramString2 = Uri.parse(str).getLastPathSegment();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("?");
      localStringBuilder.append("url");
      localStringBuilder.append("=");
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      paramString2 = paramString1;
      if (bool)
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&enableCache=1");
        paramString2 = paramString2.toString();
      }
      if ((paramInt != 90) && (paramInt != 10))
      {
        paramString1 = paramString2;
        if (paramInt != -1) {}
      }
      else
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("&priority=");
        paramString1.append(paramInt);
        paramString1 = paramString1.toString();
      }
      paramBoolean2 = TextUtils.isEmpty((CharSequence)localObject);
      localStringBuilder = null;
      paramString2 = paramString1;
      if (paramBoolean2) {}
    }
    try
    {
      paramString2 = URLEncoder.encode((String)localObject, "UTF-8");
      localObject = paramString2;
    }
    catch (UnsupportedEncodingException paramString2)
    {
      label459:
      break label459;
    }
    paramString2 = new StringBuilder();
    paramString2.append("unable to encode contentType ");
    paramString2.append((String)localObject);
    b.a(6, "VideoProxy", paramString2.toString());
    Object localObject = null;
    paramString2 = paramString1;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("&contentType=");
      paramString2.append((String)localObject);
      paramString2 = paramString2.toString();
    }
    localObject = localStringBuilder;
    if (paramBoolean1)
    {
      paramString1 = new StringBuilder();
      paramString1.append(System.currentTimeMillis());
      paramString1.append("");
      paramString1.append(c.getAndIncrement());
      localObject = paramString1.toString();
    }
    paramString1 = paramString2;
    if (localObject != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("&id=");
      paramString1.append((String)localObject);
      paramString1 = paramString1.toString();
    }
    paramString2 = paramString1;
    if (this.b) {
      try
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&secret=");
        paramString2.append(d.a("des", d.a(), b.a(str)));
        paramString2 = paramString2.toString();
      }
      catch (Exception paramString2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("encode failed:");
        ((StringBuilder)localObject).append(b.a(paramString2));
        b.a(6, "VideoProxy", ((StringBuilder)localObject).toString());
        this.b = false;
        paramString2 = paramString1;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("getUrl, url:");
    paramString1.append(str);
    paramString1.append(", proxyUrl:");
    paramString1.append(paramString2);
    b.a(4, "VideoProxy", paramString1.toString());
    return paramString2;
    b.a(4, "VideoProxy", "getUrl, proxy disabled or server shutdown");
    com.tencent.luggage.wxa.mc.a.a().f().a();
    return b.c(paramString1);
  }
  
  public long b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.e != null))
    {
      paramString = b.a(paramString);
      return this.e.a(paramString);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.me.c
 * JD-Core Version:    0.7.0.1
 */