package com.tencent.luggage.wxa.fy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;

public final class e
{
  private static d a(c paramc)
  {
    if ((paramc instanceof u)) {
      return ((u)paramc).q();
    }
    if ((paramc instanceof h)) {
      return ((h)paramc).q();
    }
    return null;
  }
  
  @Nullable
  public static com.tencent.luggage.wxa.mu.a a(@NonNull com.tencent.luggage.wxa.fx.a parama)
  {
    o.e("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
    d locald = a(parama.g());
    if (locald == null)
    {
      o.c("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
      return null;
    }
    com.tencent.luggage.wxa.mu.a locala = (com.tencent.luggage.wxa.mu.a)locald.c(com.tencent.luggage.wxa.mu.a.class);
    parama = locala;
    if (locala == null)
    {
      o.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
      parama = new com.tencent.luggage.wxa.mu.a(locald);
      locald.a(parama);
    }
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.e
 * JD-Core Version:    0.7.0.1
 */