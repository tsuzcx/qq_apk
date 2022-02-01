package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class l$c
  extends ah
{
  private static final int CTRL_INDEX = 189;
  private static final String NAME = "onBluetoothAdapterStateChange";
  private static c a = new c();
  private static JSONObject b = new JSONObject();
  
  public static void a(c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramc == null) {}
    try
    {
      o.b("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
      return;
    }
    finally
    {
      try
      {
        b.remove("available");
        b.put("available", paramBoolean1);
        b.remove("discovering");
        b.put("discovering", paramBoolean2);
      }
      catch (JSONException localJSONException)
      {
        o.b("MicroMsg.JsApiOpenBluetoothAdapter", "put JSON data error : %s", new Object[] { localJSONException });
        if (paramc != null) {
          break label94;
        }
        o.c("MicroMsg.JsApiOpenBluetoothAdapter", "service is null, fail");
        return;
        a.b(paramc, paramc.getComponentId()).b(b.toString()).a();
        o.d("MicroMsg.JsApiOpenBluetoothAdapter", "OnBluetoothAdapterStateChange %s", new Object[] { b.toString() });
        return;
      }
      paramc = finally;
    }
    label94:
    throw paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.l.c
 * JD-Core Version:    0.7.0.1
 */