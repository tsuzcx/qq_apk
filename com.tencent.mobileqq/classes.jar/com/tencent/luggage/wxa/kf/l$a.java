package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

class l$a
  extends ah
{
  private static final int CTRL_INDEX = 187;
  private static final String NAME = "onBLECharacteristicValueChange";
  private static a a = new a();
  private static JSONObject b = new JSONObject();
  
  public static void a(c paramc, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramc == null) {}
    try
    {
      o.b("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent dispatch fail, service is null");
      return;
    }
    finally
    {
      try
      {
        b.remove("value");
        b.put("value", paramString4);
        b.remove("deviceId");
        b.put("deviceId", paramString1);
        b.remove("serviceId");
        b.put("serviceId", paramString2);
        b.remove("characteristicId");
        b.put("characteristicId", paramString3);
      }
      catch (JSONException paramString1)
      {
        o.b("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[] { paramString1 });
        if (paramc != null) {
          break label133;
        }
        o.c("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
        return;
        a.b(paramc, paramc.getComponentId()).b(b.toString()).a();
        o.d("MicroMsg.JsApiOpenBluetoothAdapter", "OnBLECharacteristicValueChangeEvent %s", new Object[] { b.toString() });
        return;
      }
      paramc = finally;
    }
    label133:
    throw paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.l.a
 * JD-Core Version:    0.7.0.1
 */