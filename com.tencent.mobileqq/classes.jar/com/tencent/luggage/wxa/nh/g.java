package com.tencent.luggage.wxa.nh;

import com.tencent.luggage.wxa.fy.e;
import com.tencent.luggage.wxa.gd.d;
import com.tencent.luggage.wxa.ju.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public final class g
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 819;
  public static final String NAME = "operateXWebVideoBackground";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new b(paramInt, paramJSONObject, paramc, this);
    Object localObject = e.a(paramJSONObject);
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
      paramc.a(paramInt, b("fail:audioOfVideoBackgroundPlayManager is null"));
      return;
    }
    localObject = ((com.tencent.luggage.wxa.mu.a)localObject).b();
    if (localObject == null)
    {
      o.c("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
      paramc.a(paramInt, b("fail:videoPlayer is null"));
      return;
    }
    if (!(localObject instanceof d))
    {
      o.c("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
      paramc.a(paramInt, b("fail:videoPlayer is not for XwebVideo"));
      return;
    }
    ((d)localObject).b(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nh.g
 * JD-Core Version:    0.7.0.1
 */