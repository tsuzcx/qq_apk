package com.tencent.luggage.wxa.kf;

import android.annotation.TargetApi;
import com.tencent.luggage.wxa.ke.b;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public class p
  extends com.tencent.luggage.wxa.jx.a
{
  private static final int CTRL_INDEX = 177;
  private static final String NAME = "stopBluetoothDevicesDiscovery";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.ke.c.a(101);
    String str = paramc.getAppId();
    Boolean localBoolean = Boolean.valueOf(false);
    Object localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = "";
    }
    o.d("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "appId:%s stopBluetoothDevicesDiscovery data:%s", new Object[] { str, localObject });
    paramJSONObject = com.tencent.luggage.wxa.ke.a.a(str);
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramc.a(paramInt, a("fail:not init", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(103, 106);
      return;
    }
    if (!paramJSONObject.j())
    {
      o.b("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramc.a(paramInt, a("fail:not available", paramJSONObject));
      com.tencent.luggage.wxa.ke.c.a(103, 108);
      return;
    }
    paramJSONObject = paramJSONObject.i();
    o.d("MicroMsg.JsApiStopBluetoothDevicesDiscovery", "stopBleScan result:%s", new Object[] { paramJSONObject });
    localObject = new HashMap();
    if (paramJSONObject.u != 0)
    {
      ((Map)localObject).put("isDiscovering", localBoolean);
      paramc.a(paramInt, a("fail", (Map)localObject));
      com.tencent.luggage.wxa.ke.c.a(103);
      return;
    }
    ((Map)localObject).put("isDiscovering", localBoolean);
    paramc.a(paramInt, a("ok", (Map)localObject));
    com.tencent.luggage.wxa.ke.c.a(102);
    l.c.a(paramc, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.p
 * JD-Core Version:    0.7.0.1
 */