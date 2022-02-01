package com.tencent.luggage.wxa.jz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.gz.e.a;
import com.tencent.luggage.wxa.nr.b;
import com.tencent.luggage.wxa.qy.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class o$a$2
  extends c<com.tencent.luggage.wxa.gz.e>
{
  o$a$2(o.a parama) {}
  
  public boolean a(com.tencent.luggage.wxa.gz.e parame)
  {
    o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", new Object[] { Integer.valueOf(parame.a.a) });
    HashMap localHashMap = new HashMap();
    String str1 = parame.a.e;
    if (parame.a.a == 10)
    {
      localObject = parame.a.h;
      if (((String)localObject).equals(this.a.g))
      {
        o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
        return false;
      }
      o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", new Object[] { localObject, this.a.g });
      localHashMap.put("state", str1);
      this.a.h = new JSONObject(localHashMap).toString();
      this.a.i = parame.a.a;
      o.a.a(this.a);
      return true;
    }
    Object localObject = parame.a.b;
    if (localObject == null)
    {
      o.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
      return false;
    }
    if (!parame.a.f)
    {
      o.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
      return false;
    }
    int i;
    if ((parame.a.a == 2) && (parame.a.g)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      o.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
      return false;
    }
    String str2 = b.b().c();
    if (!this.a.g.equals(str2))
    {
      o.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", new Object[] { this.a.g, str2 });
      return false;
    }
    localHashMap.put("src", ((com.tencent.luggage.wxa.ig.e)localObject).i);
    localHashMap.put("state", str1);
    localHashMap.put("errCode", Integer.valueOf(parame.a.i));
    if (!TextUtils.isEmpty(parame.a.j)) {
      str1 = parame.a.j;
    } else {
      str1 = "";
    }
    localHashMap.put("errMsg", str1);
    this.a.h = new JSONObject(localHashMap).toString();
    this.a.i = parame.a.a;
    o.a.b(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.o.a.2
 * JD-Core Version:    0.7.0.1
 */