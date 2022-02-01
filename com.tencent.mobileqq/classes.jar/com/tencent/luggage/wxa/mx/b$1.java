package com.tencent.luggage.wxa.mx;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jl.a.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader.ResourceLoadCallback;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

class b$1
  implements a.c
{
  b$1(b paramb, IResourceLoader.ResourceLoadCallback paramResourceLoadCallback) {}
  
  public void a(@Nullable InputStream paramInputStream)
  {
    if (paramInputStream == null) {}
    try
    {
      o.b("MicroMsg.WxaNativeImageLoader", "inputStream is null, error");
      if (this.a == null) {
        break label138;
      }
      this.a.onResourceLoaded(null);
      return;
    }
    catch (IOException paramInputStream)
    {
      o.b("MicroMsg.WxaNativeImageLoader", "loadResource Async fail: %s", new Object[] { paramInputStream.getMessage() });
      paramInputStream = this.a;
      if (paramInputStream == null) {
        break label137;
      }
      paramInputStream.onResourceLoaded(null);
    }
    paramInputStream = IOUtils.toByteArray(paramInputStream);
    boolean bool;
    if (paramInputStream != null) {
      bool = true;
    }
    for (;;)
    {
      o.d("MicroMsg.WxaNativeImageLoader", "loadResourceAsync bytes:%b", new Object[] { Boolean.valueOf(bool) });
      q localq = (q)this.b.a.getJsRuntime().a(q.class);
      if (localq != null)
      {
        localq.a(new b.1.1(this, paramInputStream));
        return;
      }
      label137:
      return;
      label138:
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.b.1
 * JD-Core Version:    0.7.0.1
 */