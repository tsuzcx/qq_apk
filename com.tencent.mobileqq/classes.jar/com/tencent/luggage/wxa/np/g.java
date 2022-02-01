package com.tencent.luggage.wxa.np;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.wxa.bd.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.luggage.wxa.jl.a.c;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.page.r;

public class g
  extends a
  implements com.tencent.luggage.wxa.jl.b
{
  private final d a;
  
  g(d paramd)
  {
    this.a = paramd;
  }
  
  private Pair<String, String> b(String paramString)
  {
    paramString = Uri.parse(paramString);
    return Pair.create(paramString.getQueryParameter("appId"), paramString.getQueryParameter("path"));
  }
  
  public Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    if (!a(paramString)) {
      return null;
    }
    paramString = (String)b(paramString).second;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramb = r.a(this.a, Uri.decode(paramString));
    paramString = paramb;
    if (paramRect != null) {
      paramString = new com.tencent.luggage.wxa.no.b(paramRect.left, paramRect.top, paramRect.width(), paramRect.height()).a(paramb);
    }
    return paramString;
  }
  
  public String a()
  {
    return "WxaPkgImageReader";
  }
  
  public void a(String paramString, a.c paramc)
  {
    if (paramc == null) {
      return;
    }
    paramString = (String)b(paramString).second;
    if (TextUtils.isEmpty(paramString))
    {
      paramc.a(null);
      return;
    }
    paramc.a(ad.c(this.a, paramString));
  }
  
  public boolean a(c paramc, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramc != null)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return false;
        }
        bool1 = bool2;
        if (!paramString.startsWith("wxapkg://"))
        {
          bool1 = bool2;
          if (!paramString.startsWith("http://"))
          {
            bool1 = bool2;
            if (!paramString.startsWith("https://"))
            {
              bool1 = bool2;
              if (!paramString.startsWith("wxfile://"))
              {
                bool1 = bool2;
                if (!paramString.contains("://")) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("wxapkg://"));
  }
  
  public String b(c paramc, String paramString)
  {
    if (!a(paramc, paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wxapkg://");
    localStringBuilder.append("icon?");
    localStringBuilder.append("appId=");
    localStringBuilder.append(paramc.getAppId());
    localStringBuilder.append("&");
    localStringBuilder.append("path=");
    localStringBuilder.append(Uri.encode(paramString));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.np.g
 * JD-Core Version:    0.7.0.1
 */