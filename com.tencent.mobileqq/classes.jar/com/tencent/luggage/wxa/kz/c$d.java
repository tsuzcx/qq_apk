package com.tencent.luggage.wxa.kz;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.io.InputStream;

class c$d
  implements c.c
{
  public c.a a(c paramc, String paramString, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.appstorage.o localo;
    InputStream localInputStream;
    Object localObject1;
    if ((paramc != null) && ((paramc instanceof h)))
    {
      localo = paramc.getFileSystem();
      if (localo == null)
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
        return new c.a(false, "fail:runtime fileSystem is null");
      }
      localInputStream = ad.c(((h)paramc).q(), paramString);
      if (localInputStream == null)
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        return new c.a(false, "fail:file doesn't exist");
      }
      localObject1 = null;
      paramString = (String)localObject1;
    }
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        paramString = (String)localObject1;
        Bitmap localBitmap = b.a.a((b)paramc.a(b.class)).a(localInputStream, null, localOptions);
        if (localBitmap == null)
        {
          paramString = (String)localObject1;
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          paramString = (String)localObject1;
          return new c.a(false, "fail:decode image fail");
        }
        paramString = (String)localObject1;
        if (!com.tencent.luggage.wxa.bx.a.a(localOptions)) {
          break label532;
        }
        paramc = "jpg";
        paramString = (String)localObject1;
        Object localObject2 = new StringBuilder();
        paramString = (String)localObject1;
        ((StringBuilder)localObject2).append(com.tencent.luggage.wxa.hz.a.f());
        paramString = (String)localObject1;
        ((StringBuilder)localObject2).append("microMsg.tmp.");
        paramString = (String)localObject1;
        ((StringBuilder)localObject2).append(System.currentTimeMillis());
        paramString = (String)localObject1;
        ((StringBuilder)localObject2).append(".");
        paramString = (String)localObject1;
        ((StringBuilder)localObject2).append(paramc);
        paramString = (String)localObject1;
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString = (String)localObject2;
        if (com.tencent.luggage.wxa.bx.a.a(localOptions))
        {
          paramString = (String)localObject2;
          localObject1 = Bitmap.CompressFormat.JPEG;
        }
        else
        {
          paramString = (String)localObject2;
          localObject1 = Bitmap.CompressFormat.PNG;
        }
        paramString = (String)localObject2;
        com.tencent.luggage.wxa.qz.b.a(localBitmap, paramInt, (Bitmap.CompressFormat)localObject1, (String)localObject2, true);
        paramString = (String)localObject2;
        if (com.tencent.luggage.wxa.bx.a.a(localOptions))
        {
          paramString = (String)localObject2;
          com.tencent.luggage.wxa.jw.b.a(localInputStream, (String)localObject2);
        }
        paramString = (String)localObject2;
        localObject1 = new com.tencent.luggage.wxa.pc.i();
        paramString = (String)localObject2;
        if (localo.a(new com.tencent.luggage.wxa.rt.i((String)localObject2), paramc, false, (com.tencent.luggage.wxa.pc.i)localObject1) != j.a)
        {
          paramString = (String)localObject2;
          com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
          paramString = (String)localObject2;
          return new c.a(false, "fail:create tmp file fail");
        }
        paramString = (String)localObject2;
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { localObject2, ((com.tencent.luggage.wxa.pc.i)localObject1).a });
        paramString = (String)localObject2;
        paramc = new c.a(true, (String)((com.tencent.luggage.wxa.pc.i)localObject1).a);
        return paramc;
      }
      catch (Exception paramc)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramc });
        k.i(paramString);
        return new c.a(false, "fail:compress image exception");
      }
      catch (NullPointerException paramc)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramc });
        return new c.a(false, "fail:compress image NPE");
      }
      catch (OutOfMemoryError paramc)
      {
        com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramc });
        return new c.a(false, "fail:compress image OOM");
      }
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
      return new c.a(false, "fail:internal error invalid js component");
      label532:
      paramc = "png";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.c.d
 * JD-Core Version:    0.7.0.1
 */