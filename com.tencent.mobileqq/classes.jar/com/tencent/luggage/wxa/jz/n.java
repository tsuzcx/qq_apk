package com.tencent.luggage.wxa.jz;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.t;

public class n
  extends m
{
  @Nullable
  public v.a a(c paramc, String paramString)
  {
    try
    {
      if ((paramc.getFileSystem() instanceof t))
      {
        paramc = ((t)paramc.getFileSystem()).a(IWxaFileSystemWithModularizing.class);
        paramc.getClass();
        paramc = ((IWxaFileSystemWithModularizing)paramc).openReadPartialInfo(paramString);
        return paramc;
      }
    }
    catch (Exception paramc)
    {
      o.b("MicroMsg.JsApiSetAudioStateWxaApp", "getPkgPath with audioSrc(%s), e=%s", new Object[] { paramString, paramc });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.n
 * JD-Core Version:    0.7.0.1
 */