package com.tencent.luggage.wxa.mr;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.ms.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends a
{
  public static final int CTRL_INDEX = 318;
  public static final String NAME = "getConnectedWifi";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!d.a)
    {
      o.b("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.a(paramInt, a("fail:not invoke startWifi", paramJSONObject));
      return;
    }
    Object localObject = paramc.getContext();
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:context is null", paramJSONObject));
      return;
    }
    e.a((Context)localObject);
    if (!com.tencent.luggage.wxa.mt.c.g())
    {
      o.b("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.a(paramInt, a("fail:wifi is disable", paramJSONObject));
      return;
    }
    paramJSONObject = e.a();
    if (paramJSONObject == null)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.luggage.wxa.re.c.a()) && (!((LocationManager)((Context)localObject).getSystemService("location")).isProviderEnabled("gps")))
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12006));
        paramc.a(paramInt, a("fail:may be not open GPS", paramJSONObject));
        o.b("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
        return;
      }
      boolean bool = j.a((Activity)localObject, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      o.d("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12012));
        paramc.a(paramInt, a("fail:may be not obtain GPS Perrmission", paramJSONObject));
        o.b("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
        return;
      }
      o.b("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:currentWifi is null", paramJSONObject));
      return;
    }
    localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:connectivityManager is null", paramJSONObject));
      return;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null)
    {
      o.b("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:netInfo is null", paramJSONObject));
      return;
    }
    if (((NetworkInfo)localObject).getDetailedState() != NetworkInfo.DetailedState.CONNECTED)
    {
      o.b("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", new Object[] { ((NetworkInfo)localObject).getDetailedState() });
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:detailState is not connected", paramJSONObject));
      return;
    }
    o.d("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", new Object[] { paramJSONObject });
    try
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("wifi", paramJSONObject.a());
      ((HashMap)localObject).put("errCode", Integer.valueOf(0));
      paramc.a(paramInt, a("ok", (Map)localObject));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      o.a("MicroMsg.JsApiGetConnectedWifi", paramJSONObject, "", new Object[0]);
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:parse json err", paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.b
 * JD-Core Version:    0.7.0.1
 */