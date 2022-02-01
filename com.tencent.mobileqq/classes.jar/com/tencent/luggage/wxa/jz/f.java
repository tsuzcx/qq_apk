package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstanceAsync";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(paramc, paramJSONObject, paramInt, paramc.getJsRuntime());
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
    new f.1(this, paramc, paramo, paramInt).b();
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.f
 * JD-Core Version:    0.7.0.1
 */