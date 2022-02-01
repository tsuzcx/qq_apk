package com.tencent.luggage.wxa.kz;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

public class c
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramc == null)
    {
      o.b("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      return;
    }
    if (paramJSONObject == null)
    {
      o.c("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    String str = paramJSONObject.optString("src");
    if (af.c(str))
    {
      o.c("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      paramc.a(paramInt, b("fail:data src is null"));
      return;
    }
    if (paramc.getFileSystem() == null)
    {
      o.c("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
      paramc.a(paramInt, b("fail:runtime fileSystem is null"));
      return;
    }
    int j = paramJSONObject.optInt("quality", 80);
    int i;
    if (j >= 1)
    {
      i = j;
      if (j <= 100) {}
    }
    else
    {
      o.c("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
      i = 80;
    }
    o.d("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", new Object[] { Integer.valueOf(i), str });
    com.tencent.luggage.wxa.rd.a.a(new c.1(this, str, paramc, i, new WeakReference(paramc), paramInt), String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[] { str, Integer.valueOf(i) }), 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.c
 * JD-Core Version:    0.7.0.1
 */