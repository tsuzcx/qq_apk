package com.tencent.luggage.wxa.cb;

import com.tencent.luggage.wxa.gz.e.a;
import com.tencent.luggage.wxa.qy.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class a$d$6
  extends c<com.tencent.luggage.wxa.gz.e>
{
  a$d$6(a.d paramd) {}
  
  public boolean a(com.tencent.luggage.wxa.gz.e parame)
  {
    o.d("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", new Object[] { Integer.valueOf(parame.a.a) });
    Object localObject = parame.a.b;
    if (localObject == null) {
      return false;
    }
    localObject = ((com.tencent.luggage.wxa.ig.e)localObject).i;
    HashMap localHashMap = new HashMap();
    localHashMap.put("dataUrl", localObject);
    this.a.f = new JSONObject(localHashMap).toString();
    this.a.g = parame.a.a;
    a.d.h(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cb.a.d.6
 * JD-Core Version:    0.7.0.1
 */