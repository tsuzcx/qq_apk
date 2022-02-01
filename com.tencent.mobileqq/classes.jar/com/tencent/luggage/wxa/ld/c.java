package com.tencent.luggage.wxa.ld;

import com.tencent.luggage.wxa.kd.h;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c
  extends com.tencent.luggage.wxa.jx.a<com.tencent.luggage.wxa.jx.c>
  implements h
{
  private com.tencent.luggage.wxa.kd.a a = new com.tencent.luggage.wxa.kd.a();
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!com.tencent.luggage.wxa.qz.c.a)
    {
      a(paramc, paramJSONObject, paramInt, paramc.getJsRuntime());
      return;
    }
    throw new RuntimeException("Should call 3 params version!");
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    String str = x_();
    HashMap localHashMap = new HashMap();
    localHashMap.put(y_(), str);
    this.a.a(str, paramo);
    paramc.a(paramInt, a("ok", localHashMap));
    a(paramc, paramJSONObject, str);
  }
  
  protected com.tencent.luggage.wxa.kd.a c()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.c
 * JD-Core Version:    0.7.0.1
 */