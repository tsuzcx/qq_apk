package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.gz.c.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class m$a$1
  extends com.tencent.luggage.wxa.qy.c<com.tencent.luggage.wxa.gz.c>
{
  m$a$1(m.a parama) {}
  
  public boolean a(com.tencent.luggage.wxa.gz.c paramc)
  {
    Object localObject = paramc.a.e;
    if (!this.a.b.equals(localObject))
    {
      o.d("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", new Object[] { this.a.b, localObject, Integer.valueOf(paramc.a.a) });
      return false;
    }
    localObject = new HashMap();
    String str = paramc.a.d;
    m.a.a(this.a, paramc.a.c);
    o.e("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d， audioId:%s, state:%s", new Object[] { Integer.valueOf(paramc.a.a), m.a.a(this.a), str });
    ((Map)localObject).put("state", str);
    ((Map)localObject).put("audioId", m.a.a(this.a));
    this.a.d = paramc.a.a;
    if (this.a.d == 4)
    {
      ((Map)localObject).put("errMsg", paramc.a.g);
      ((Map)localObject).put("errCode", Integer.valueOf(paramc.a.f));
    }
    this.a.c = new JSONObject((Map)localObject).toString();
    this.a.c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.m.a.1
 * JD-Core Version:    0.7.0.1
 */