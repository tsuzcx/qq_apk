package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class i
  extends u
{
  public static final int CTRL_INDEX = 159;
  public static final String NAME = "getBackgroundAudioState";
  
  public String a(c paramc, JSONObject paramJSONObject)
  {
    paramc = paramc.getAppId();
    i.a locala = new i.a();
    locala.a = paramc;
    if (!locala.f())
    {
      o.b("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
      return b("fail");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", Double.valueOf(locala.b));
    localHashMap.put("currentTime", Double.valueOf(locala.c));
    boolean bool;
    if (locala.d == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localHashMap.put("paused", Boolean.valueOf(bool));
    localHashMap.put("buffered", Double.valueOf(locala.e));
    localHashMap.put("src", locala.f);
    localHashMap.put("title", locala.g);
    localHashMap.put("epname", locala.h);
    localHashMap.put("singer", locala.i);
    localHashMap.put("coverImgUrl", locala.j);
    localHashMap.put("webUrl", locala.k);
    paramc = locala.l;
    paramJSONObject = "";
    if (paramc == null) {
      paramc = "";
    } else {
      paramc = locala.l;
    }
    localHashMap.put("protocol", paramc);
    localHashMap.put("startTime", Integer.valueOf(locala.m / 1000));
    localHashMap.put("songLyric", locala.n);
    localHashMap.put("playbackRate", Double.valueOf(locala.o));
    localHashMap.put("referrerPolicy", locala.p);
    if (TextUtils.isEmpty(locala.r)) {
      paramc = paramJSONObject;
    } else {
      paramc = locala.r;
    }
    if (locala.q)
    {
      o.b("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[] { paramc });
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("fail:");
      paramJSONObject.append(paramc);
      return b(paramJSONObject.toString());
    }
    o.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
    return a("ok", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.i
 * JD-Core Version:    0.7.0.1
 */