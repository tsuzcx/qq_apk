package com.tencent.luggage.wxa.ld;

import android.os.Handler;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.kd.a;
import com.tencent.luggage.wxa.kd.h;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class b
  extends u<com.tencent.luggage.wxa.jx.c>
  implements h
{
  private a a = new a();
  
  public String a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject)
  {
    if (!com.tencent.luggage.wxa.qz.c.a) {
      return a(paramc, paramJSONObject, paramc.getJsRuntime());
    }
    throw new RuntimeException("Should call 3 params version!");
  }
  
  public String a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, o paramo)
  {
    String str = x_();
    HashMap localHashMap = new HashMap();
    localHashMap.put(y_(), str);
    this.a.a(str, paramo);
    paramc.getAsyncHandler().post(new b.1(this, paramc, paramJSONObject, str));
    return a("ok", localHashMap);
  }
  
  protected a c()
  {
    return this.a;
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.b
 * JD-Core Version:    0.7.0.1
 */