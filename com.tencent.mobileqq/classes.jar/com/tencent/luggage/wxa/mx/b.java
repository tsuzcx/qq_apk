package com.tencent.luggage.wxa.mx;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.lr.c;
import com.tencent.luggage.wxa.lr.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader.ResourceLoadCallback;
import java.io.IOException;
import java.util.Map;
import org.apache.commons.io.IOUtils;

public class b
  implements IResourceLoader
{
  h a;
  com.tencent.luggage.wxa.jl.b b;
  com.tencent.luggage.wxa.jl.a c;
  
  public b(com.tencent.luggage.wxa.jl.b paramb, com.tencent.luggage.wxa.jl.a parama, h paramh)
  {
    this.b = paramb;
    this.c = parama;
    this.a = paramh;
  }
  
  @Nullable
  private Map<String, String> a(String paramString)
  {
    com.tencent.luggage.wxa.lr.a locala = (com.tencent.luggage.wxa.lr.a)e.a(com.tencent.luggage.wxa.lr.a.class);
    if (locala == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerHelper is null");
      return null;
    }
    if (paramString == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxaNativeImageLoader", "buildHeaders, referrerPolicyStr is null");
      return null;
    }
    Object localObject = locala.a(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramString = this.a;
      if (paramString != null)
      {
        paramString = locala.a(paramString);
      }
      else
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
        paramString = (String)localObject;
      }
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = locala.a();
    }
    if (c.b == localObject) {
      return null;
    }
    paramString = this.a;
    if (paramString == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.WxaNativeImageLoader", "buildHeaders, mAppBrandService is null");
      return null;
    }
    paramString = locala.b(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("buildHeaders, referrer: ");
    ((StringBuilder)localObject).append(paramString);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxaNativeImageLoader", ((StringBuilder)localObject).toString());
    return d.a(paramString);
  }
  
  public byte[] loadResource(String paramString1, String paramString2)
  {
    if ((this.c != null) && (this.b != null))
    {
      paramString2 = this.a;
      if (paramString2 != null) {
        paramString1 = paramString2.getFileSystem().k(paramString1);
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = IOUtils.toByteArray(paramString1);
        if (paramString1 == null) {
          break label101;
        }
        bool = true;
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxaNativeImageLoader", "loadResource bytes:%b", new Object[] { Boolean.valueOf(bool) });
        return paramString1;
      }
      catch (IOException paramString1)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.WxaNativeImageLoader", "loadResource sync fail: %s", new Object[] { paramString1.getMessage() });
        return null;
      }
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder is null, return");
      return null;
      label101:
      boolean bool = false;
    }
  }
  
  public void loadResourceAsync(String paramString1, String paramString2, IResourceLoader.ResourceLoadCallback paramResourceLoadCallback)
  {
    if ((this.c != null) && (this.b != null) && (this.a != null) && (!af.c(paramString1)))
    {
      if ((!paramString1.startsWith("http")) && (!paramString1.startsWith("https")))
      {
        paramString2 = (q)this.a.getJsRuntime().a(q.class);
        if (paramString2 != null) {
          paramString2.a(new b.2(this, paramString1, paramResourceLoadCallback));
        }
      }
      else
      {
        paramString1 = this.b.b(this.a, paramString1);
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxaNativeImageLoader", "finalUrl : %s", new Object[] { paramString1 });
        this.c.a(paramString1, a(paramString2), new b.1(this, paramResourceLoadCallback));
      }
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.WxaNativeImageLoader", "mImageLoader or mUrlBuilder or path:%s is null, return", new Object[] { paramString1 });
    paramResourceLoadCallback.onResourceLoaded(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.b
 * JD-Core Version:    0.7.0.1
 */