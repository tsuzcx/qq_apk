package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

class l$b
  extends ah
{
  private static final int CTRL_INDEX = 188;
  private static final String NAME = "onBLEConnectionStateChanged";
  private static b a = new b();
  private static JSONObject b = new JSONObject();
  
  public static void a(c paramc, String paramString, boolean paramBoolean)
  {
    if (paramc == null) {}
    try
    {
      o.b("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent dispatch fail, service is null");
      return;
    }
    finally
    {
      try
      {
        b.remove("deviceId");
        b.put("deviceId", paramString);
        b.remove("connected");
        b.put("connected", paramBoolean);
      }
      catch (JSONException paramString)
      {
        o.b("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[] { paramString });
        if (paramc != null) {
          break label94;
        }
        o.c("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
        return;
        a.b(paramc, paramc.getComponentId()).b(b.toString()).a();
        o.d("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLEConnectionStateChangedEvent %s", new Object[] { b.toString() });
        return;
      }
      paramc = finally;
    }
    label94:
    throw paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.l.b
 * JD-Core Version:    0.7.0.1
 */