package com.tencent.luggage.wxa.np;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.luggage.wxa.jl.a.c;
import com.tencent.luggage.wxa.jl.b;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.plugin.appbrand.appstorage.o;

public class c
  extends com.tencent.luggage.wxa.bd.a
  implements b
{
  private final d a;
  
  public c(d paramd)
  {
    this.a = paramd;
  }
  
  private Pair<String, String> b(String paramString)
  {
    int i = paramString.lastIndexOf("?appId=");
    String str = paramString.substring(0, i);
    return Pair.create(paramString.substring(i + 7), str);
  }
  
  public Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    boolean bool = a(paramString);
    paramb = null;
    if (!bool) {
      return null;
    }
    Object localObject = this.a.z();
    if (localObject == null) {
      return null;
    }
    paramString = ((o)localObject).g((String)b(paramString).second);
    if (paramString != null)
    {
      if (!paramString.j()) {
        return null;
      }
      localObject = paramString.l();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("file://"))
      {
        paramString = new StringBuilder();
        paramString.append("file://");
        paramString.append((String)localObject);
        paramString = paramString.toString();
      }
      if (paramRect != null) {
        paramb = new com.tencent.luggage.wxa.no.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
      }
      return AppBrandSimpleImageLoader.instance().findCachedLocal(paramString, paramb);
    }
    return null;
  }
  
  public String a()
  {
    return "WxFileImageReader";
  }
  
  public void a(String paramString, a.c paramc)
  {
    if (paramc == null) {
      return;
    }
    o localo = this.a.z();
    if (localo == null)
    {
      paramc.a(null);
      return;
    }
    paramc.a(localo.k((String)b(paramString).second));
  }
  
  public boolean a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
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
        if (paramString.startsWith("wxfile://"))
        {
          bool1 = bool2;
          if (!paramString.startsWith("wxfile://ad")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("wxfile://")) && (!paramString.startsWith("wxfile://ad"));
  }
  
  public String b(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    if (!a(paramc, paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("?appId=");
    localStringBuilder.append(paramc.getAppId());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.np.c
 * JD-Core Version:    0.7.0.1
 */