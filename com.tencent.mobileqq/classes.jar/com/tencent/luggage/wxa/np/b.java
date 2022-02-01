package com.tencent.luggage.wxa.np;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.iv.d;
import com.tencent.luggage.wxa.jl.a.b;
import com.tencent.luggage.wxa.jl.a.c;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;

public class b
  extends com.tencent.luggage.wxa.bd.a
  implements com.tencent.luggage.wxa.jl.b
{
  public Bitmap a(String paramString, Rect paramRect, a.b paramb)
  {
    boolean bool = a(paramString);
    Object localObject = null;
    if (!bool)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", new Object[] { paramString });
      return null;
    }
    paramb = (d)e.a(d.class);
    if (paramb == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxFileAdImageReader", "read, no ad service");
      return null;
    }
    paramb = paramb.a();
    if (paramb == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxFileAdImageReader", "read, no ad file system");
      return null;
    }
    paramb = paramb.g(paramString);
    if ((paramb != null) && (paramb.j()))
    {
      String str = paramb.l();
      paramb = str;
      if (!str.startsWith("file://"))
      {
        paramb = new StringBuilder();
        paramb.append("file://");
        paramb.append(str);
        paramb = paramb.toString();
      }
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", new Object[] { paramString, paramb });
      paramString = localObject;
      if (paramRect != null) {
        paramString = new com.tencent.luggage.wxa.no.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
      }
      return AppBrandSimpleImageLoader.instance().findCachedLocal(paramb, paramString);
    }
    com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", new Object[] { paramString });
    return null;
  }
  
  public String a()
  {
    return "WxFileAdImageReader";
  }
  
  public void a(String paramString, a.c paramc)
  {
    if (!a(paramString))
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", new Object[] { paramString });
      return;
    }
    if (paramc == null) {
      return;
    }
    Object localObject = (d)e.a(d.class);
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
      return;
    }
    localObject = ((d)localObject).a();
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
      return;
    }
    paramc.a(((com.tencent.mm.plugin.appbrand.appstorage.o)localObject).k(paramString));
  }
  
  public boolean a(c paramc, String paramString)
  {
    if ((paramc != null) && (paramString != null) && (paramString.length() != 0)) {
      return paramString.startsWith("wxfile://ad");
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("wxfile://ad"));
  }
  
  public String b(c paramc, String paramString)
  {
    if (!a(paramc, paramString)) {}
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.np.b
 * JD-Core Version:    0.7.0.1
 */