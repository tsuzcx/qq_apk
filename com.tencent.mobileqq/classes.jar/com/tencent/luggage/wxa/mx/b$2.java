package com.tencent.luggage.wxa.mx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.xweb.skia_canvas.resource_loader.IResourceLoader.ResourceLoadCallback;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

class b$2
  implements Runnable
{
  b$2(b paramb, String paramString, IResourceLoader.ResourceLoadCallback paramResourceLoadCallback) {}
  
  public void run()
  {
    Object localObject = this.c.a.getFileSystem().k(this.a);
    for (;;)
    {
      try
      {
        localObject = IOUtils.toByteArray((InputStream)localObject);
        if (localObject == null) {
          break label110;
        }
        bool = true;
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.WxaNativeImageLoader", "loadResource bytes:%b", new Object[] { Boolean.valueOf(bool) });
        if (this.b == null) {
          break label109;
        }
        this.b.onResourceLoaded((byte[])localObject);
        return;
      }
      catch (NullPointerException localNullPointerException) {}catch (IOException localIOException) {}
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.WxaNativeImageLoader", "loadResource sync fail: %s", new Object[] { localIOException.getMessage() });
      IResourceLoader.ResourceLoadCallback localResourceLoadCallback = this.b;
      if (localResourceLoadCallback != null) {
        localResourceLoadCallback.onResourceLoaded(null);
      }
      label109:
      return;
      label110:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mx.b.2
 * JD-Core Version:    0.7.0.1
 */