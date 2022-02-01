package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 175;
  private static final String NAME = "getBluetoothAdapterState";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(126);
    o.d("MicroMsg.JsApiGetBluetoothAdapterState", "appId:%s getBluetoothAdapterState", new Object[] { paramc.getAppId() });
    paramJSONObject = com.tencent.luggage.wxa.ke.a.a(paramc.getAppId());
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiGetBluetoothAdapterState", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(128, 130);
      return;
    }
    boolean bool1 = paramJSONObject.j();
    boolean bool2 = paramJSONObject.k();
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("availableState : ");
    paramJSONObject.append(bool1);
    paramJSONObject.append(",discoveringState : ");
    paramJSONObject.append(bool2);
    o.d("MicroMsg.JsApiGetBluetoothAdapterState", paramJSONObject.toString());
    paramJSONObject = new HashMap();
    paramJSONObject.put("available", Boolean.valueOf(bool1));
    paramJSONObject.put("discovering", Boolean.valueOf(bool2));
    paramc.a(paramInt, a("ok", paramJSONObject));
    com.tencent.luggage.wxa.ke.c.a(127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.g
 * JD-Core Version:    0.7.0.1
 */