package com.tencent.luggage.wxa.np;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.luggage.wxa.jl.a.c;
import com.tencent.luggage.wxa.jl.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.plugin.appbrand.appstorage.o;

public class a
  extends com.tencent.luggage.wxa.bd.a
  implements b
{
  private final d a;
  
  a(d paramd)
  {
    this.a = paramd;
  }
  
  private Pair<String, String> b(String paramString)
  {
    if (af.c(paramString)) {
      return Pair.create(null, null);
    }
    int i = paramString.lastIndexOf("wxblob://");
    if (i < 0) {
      return Pair.create(null, null);
    }
    return Pair.create(paramString.substring(0, i), paramString.substring(i));
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
    paramString = ((o)localObject).d((String)b(paramString).second);
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
    return "WxBlobImageReader";
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
        if (!paramString.startsWith("wxblob://"))
        {
          bool1 = bool2;
          if (!af.b((String)b(paramString).second).startsWith("wxblob://")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("wxblob://"));
  }
  
  public String b(c paramc, String paramString)
  {
    if (!a(paramc, paramString)) {
      return paramString;
    }
    return af.b((String)b(paramString).second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.np.a
 * JD-Core Version:    0.7.0.1
 */