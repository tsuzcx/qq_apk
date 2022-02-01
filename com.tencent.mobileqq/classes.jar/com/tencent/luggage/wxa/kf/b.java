package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

@TargetApi(18)
public class b
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 174;
  private static final String NAME = "closeBluetoothAdapter";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(116);
    paramJSONObject = paramc.getAppId();
    o.d("MicroMsg.JsApiCloseBluetoothAdapter", "appId:%s closeBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = com.tencent.luggage.wxa.ke.a.b(paramJSONObject);
    o.d("MicroMsg.JsApiCloseBluetoothAdapter", "result:%s", new Object[] { paramJSONObject });
    if (paramJSONObject.u != 0)
    {
      paramc.a(paramInt, b(paramJSONObject.v));
      com.tencent.luggage.wxa.ke.c.a(118);
      return;
    }
    paramc.a(paramInt, b("ok"));
    com.tencent.luggage.wxa.ke.c.a(117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.b
 * JD-Core Version:    0.7.0.1
 */