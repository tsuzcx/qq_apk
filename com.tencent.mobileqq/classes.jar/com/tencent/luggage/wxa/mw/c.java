package com.tencent.luggage.wxa.mw;

import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kp.f;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class c
  extends a
{
  private static final int CTRL_INDEX = 808;
  public static final String NAME = "removeXWebCamera";
  
  public boolean a(com.tencent.luggage.wxa.jx.c paramc, f paramf, JSONObject paramJSONObject)
  {
    o.d("MicroMsg.JsApiRemoveXWebCamera", "remove xweb camera view");
    if (paramf == null)
    {
      o.c("MicroMsg.JsApiRemoveXWebCamera", "the camera view is null");
      return false;
    }
    if ((paramc instanceof e))
    {
      paramc = (e)paramc;
      paramc.b(paramf);
      paramc.b(paramf);
      paramc.b(paramf);
    }
    paramf.g();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mw.c
 * JD-Core Version:    0.7.0.1
 */