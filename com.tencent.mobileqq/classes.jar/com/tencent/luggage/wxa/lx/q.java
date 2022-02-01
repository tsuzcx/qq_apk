package com.tencent.luggage.wxa.lx;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class q
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 534;
  public static final String NAME = "setVolume";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
    if (paramc == null)
    {
      o.b("MicroMsg.JsApiSetVolume", "fail:component is null");
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiSetVolume", "fail:context is null");
      paramc.a(paramInt, b("fail:context is null"));
      return;
    }
    if (!(localObject instanceof Activity))
    {
      o.b("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
      paramc.a(paramInt, b("fail:context is not Activity"));
      return;
    }
    localObject = (AudioManager)((Context)localObject).getSystemService("audio");
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiSetVolume", "fail:manager is null");
      paramc.a(paramInt, b("fail:manager is null"));
      return;
    }
    int m = ((AudioManager)localObject).getStreamVolume(3);
    int j = ((AudioManager)localObject).getStreamMaxVolume(3);
    int k = paramJSONObject.optInt("value", m);
    o.d("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
    int i;
    if (k < 0)
    {
      i = 0;
    }
    else
    {
      i = k;
      if (k > j) {
        i = j;
      }
    }
    if (i != m)
    {
      com.tencent.luggage.wxa.hc.a.a((AudioManager)localObject, 3, i, 0);
      paramc.a(paramInt, b("ok"));
      return;
    }
    paramc.a(paramInt, b("fail:volume does not change"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.q
 * JD-Core Version:    0.7.0.1
 */