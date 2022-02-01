package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.kl.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class o$a
  extends ah
{
  private static final int CTRL_INDEX = 190;
  private static final String NAME = "onBluetoothDeviceFound";
  private static a a = new a();
  private static JSONObject b = new JSONObject();
  
  public static void a(c paramc, d paramd)
  {
    if (paramc == null) {}
    try
    {
      o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
      return;
    }
    finally {}
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(paramd.a());
    }
    catch (JSONException paramd)
    {
      o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { paramd });
    }
    try
    {
      b.remove("devices");
      b.put("devices", localJSONArray);
    }
    catch (JSONException paramd)
    {
      o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { paramd });
    }
    if (paramc == null)
    {
      o.c("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
      return;
    }
    a.b(paramc, paramc.getComponentId()).b(b.toString()).a();
    o.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[] { b.toString() });
  }
  
  public static void a(c paramc, List<d> paramList)
  {
    if (paramc == null) {}
    try
    {
      o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
      return;
    }
    finally
    {
      JSONArray localJSONArray;
      break label194;
    }
    localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      try
      {
        localJSONArray.put(locald.a());
      }
      catch (JSONException localJSONException)
      {
        o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
      }
    }
    try
    {
      b.remove("devices");
      b.put("devices", localJSONArray);
    }
    catch (JSONException paramList)
    {
      o.b("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { paramList });
    }
    if (paramc == null)
    {
      o.c("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
      return;
    }
    a.b(paramc, paramc.getComponentId()).b(b.toString()).a();
    o.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[] { b.toString() });
    return;
    label194:
    for (;;)
    {
      throw paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.o.a
 * JD-Core Version:    0.7.0.1
 */