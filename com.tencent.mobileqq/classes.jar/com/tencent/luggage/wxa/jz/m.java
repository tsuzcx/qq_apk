package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.nq.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import org.json.JSONObject;

public class m
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 292;
  public static final String NAME = "setAudioState";
  private m.a a;
  
  @NonNull
  private Pair<String, String> a(@NonNull com.tencent.luggage.wxa.jx.c paramc, @NonNull JSONObject paramJSONObject)
  {
    com.tencent.luggage.wxa.lr.a locala = (com.tencent.luggage.wxa.lr.a)e.a(com.tencent.luggage.wxa.lr.a.class);
    Object localObject = null;
    if (locala == null) {
      return new Pair(null, "invalidReferrer");
    }
    String str = locala.a(paramJSONObject);
    if (str != null)
    {
      com.tencent.luggage.wxa.lr.c localc = locala.a(str);
      paramJSONObject = localc;
      if (localc == null) {
        paramJSONObject = locala.a(paramc);
      }
      if (com.tencent.luggage.wxa.lr.c.b == paramJSONObject)
      {
        paramc = localObject;
        break label105;
      }
      if (com.tencent.luggage.wxa.lr.c.a == paramJSONObject)
      {
        paramc = locala.b(paramc);
        break label105;
      }
    }
    paramc = "invalidReferrer";
    label105:
    return new Pair(str, paramc);
  }
  
  @Nullable
  public v.a a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    return null;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!com.tencent.luggage.wxa.nq.a.e(paramc.getAppId()))
    {
      o.b("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
      paramc.a(paramInt, b("fail:App is paused or background"));
      return;
    }
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
      paramc.a(paramInt, b("fail:data is null"));
      return;
    }
    o.d("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", new Object[] { paramJSONObject.toString() });
    String str1 = paramJSONObject.optString("audioId");
    int i = paramJSONObject.optInt("startTime", 0);
    String str2 = g.a(paramc, paramJSONObject.optString("src"));
    boolean bool1 = paramJSONObject.optBoolean("autoplay", false);
    boolean bool2 = paramJSONObject.optBoolean("loop", false);
    double d3 = paramJSONObject.optDouble("volume", 1.0D);
    double d2 = paramJSONObject.optDouble("playbackRate", 1.0D);
    double d1;
    if (d2 >= 0.5D)
    {
      d1 = d2;
      if (d2 <= 2.0D) {}
    }
    else
    {
      d1 = 1.0D;
    }
    Long localLong3 = Long.valueOf(paramJSONObject.optLong("timestamp", 0L));
    Object localObject2 = Long.valueOf(0L);
    Long localLong2 = Long.valueOf(System.currentTimeMillis());
    Object localObject1;
    Long localLong1;
    if (bool1)
    {
      localObject1 = localObject2;
      localLong1 = localLong2;
      if (localLong3.longValue() > 0L)
      {
        localObject1 = localObject2;
        localLong1 = localLong2;
        if (localLong3.longValue() <= localLong2.longValue())
        {
          localObject1 = Long.valueOf(localLong2.longValue() - localLong3.longValue());
          localLong1 = localLong2;
        }
      }
    }
    else
    {
      localLong1 = Long.valueOf(0L);
      localObject1 = localObject2;
    }
    if (TextUtils.isEmpty(str1))
    {
      o.b("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
      paramc.a(paramInt, b("fail:audioId is empty"));
      return;
    }
    if (TextUtils.isEmpty(str2))
    {
      o.b("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
      paramc.a(paramInt, b("fail:src is empty"));
      return;
    }
    if (this.a == null) {
      this.a = new m.a(paramc);
    }
    this.a.b = paramc.getAppId();
    this.a.a();
    localObject2 = new m.c(this, paramc, paramInt);
    ((m.c)localObject2).c = paramc.getAppId();
    ((m.c)localObject2).d = str1;
    ((m.c)localObject2).e = str2;
    ((m.c)localObject2).f = i;
    ((m.c)localObject2).g = bool1;
    ((m.c)localObject2).h = bool2;
    ((m.c)localObject2).i = a(paramc, str2);
    ((m.c)localObject2).k = d3;
    ((m.c)localObject2).l = d1;
    ((m.c)localObject2).j = r.c();
    ((m.c)localObject2).m = ((Long)localObject1).longValue();
    ((m.c)localObject2).n = localLong1.longValue();
    paramc = a(paramc, paramJSONObject);
    ((m.c)localObject2).o = ((String)paramc.first);
    ((m.c)localObject2).p = ((String)paramc.second);
    ((m.c)localObject2).a();
    paramc = new com.tencent.luggage.wxa.nq.c();
    paramc.a = ((m.c)localObject2).i;
    paramc.b = paramJSONObject.toString();
    paramc.c = str2;
    com.tencent.luggage.wxa.nq.a.a(str1, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.m
 * JD-Core Version:    0.7.0.1
 */