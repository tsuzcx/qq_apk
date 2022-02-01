package com.tencent.luggage.wxa.mr;

import android.content.Context;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e
  extends a
{
  public static final int CTRL_INDEX = 315;
  public static final String NAME = "stopWifi";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.d("MicroMsg.JsApiStopWifi", "invoke registerHotspotHelper");
    paramJSONObject = paramc.getContext();
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.JsApiStopWifi", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:context is null", paramJSONObject));
      return;
    }
    if (!d.a)
    {
      o.b("MicroMsg.JsApiStopWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.a(paramInt, a("fail:not invoke startWifi", paramJSONObject));
      return;
    }
    if (d.b != null)
    {
      o.d("MicroMsg.JsApiStopWifi", "unregisterReceiver");
      try
      {
        paramJSONObject.unregisterReceiver(d.b);
      }
      catch (Exception paramJSONObject)
      {
        o.b("MicroMsg.JsApiStopWifi", "unregisterReceiver:%s fail", new Object[] { paramJSONObject });
      }
      d.a = false;
      d.b = null;
    }
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(0));
    paramc.a(paramInt, a("ok", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.e
 * JD-Core Version:    0.7.0.1
 */