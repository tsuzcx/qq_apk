package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.e;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public final class b
  extends a<h>
{
  public static final int CTRL_INDEX = 395;
  public static final String NAME = "setDeviceOrientation";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    try
    {
      e locale = paramh.y().getOrientationHandler();
      if (locale != null)
      {
        paramJSONObject = e.b.a(paramJSONObject.optString("value", null));
        if (paramJSONObject == null)
        {
          paramh.a(paramInt, b("fail:invalid data"));
          return;
        }
        if ((paramh.q() != null) && (paramh.q().ah() != null))
        {
          locale.a(paramJSONObject, new b.1(this, paramh, paramInt));
          return;
        }
        paramh.a(paramInt, b("fail"));
        return;
      }
      throw new NullPointerException();
    }
    catch (NullPointerException paramJSONObject)
    {
      o.a("MicroMsg.JsApiSetDeviceOrientation", paramJSONObject, "require WindowOrientationHandler NPE", new Object[0]);
      paramh.a(paramInt, b("fail:internal error"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bn.b
 * JD-Core Version:    0.7.0.1
 */