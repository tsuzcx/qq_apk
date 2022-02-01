package com.tencent.luggage.wxa.mr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.ms.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends a
{
  public static final int CTRL_INDEX = 314;
  public static final String NAME = "startWifi";
  public static boolean a = false;
  public static BroadcastReceiver b;
  
  private void a(com.tencent.luggage.wxa.jx.c paramc)
  {
    try
    {
      a.a locala = new a.a();
      HashMap localHashMap = new HashMap();
      localHashMap.put("wifi", new com.tencent.luggage.wxa.ms.c().a());
      locala.b(paramc, 0).b(localHashMap).a();
      return;
    }
    catch (JSONException paramc)
    {
      o.b("MicroMsg.JsApiStartWifi", "mWiFiEventReceiver is error");
      o.a("MicroMsg.JsApiStartWifi", paramc, "", new Object[0]);
    }
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiStartWifi", "invoke startWifi");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:context is null", paramJSONObject));
      return;
    }
    e.a(paramJSONObject);
    if (!a)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(2147483647);
      b = new d.1(this, paramc);
      paramJSONObject.registerReceiver(b, localIntentFilter);
      a = true;
    }
    paramJSONObject = new d.2(this, paramJSONObject, paramc);
    com.tencent.luggage.wxa.iu.c.a(paramc.getAppId(), paramJSONObject);
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    paramc.a(paramInt, a("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.d
 * JD-Core Version:    0.7.0.1
 */