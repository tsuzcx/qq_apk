package com.tencent.luggage.wxa.mr;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.ms.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class c
  extends a
{
  public static final int CTRL_INDEX = 317;
  public static final String NAME = "getWifiList";
  
  private void a(com.tencent.luggage.wxa.jx.c paramc, int paramInt, Context paramContext, com.tencent.luggage.wxa.ms.d paramd)
  {
    Object localObject = Integer.valueOf(12010);
    if ((paramd == null) && (paramd.b == null))
    {
      o.b("MicroMsg.JsApiGetWifiList", "WiFiListResult is null");
      paramContext = new HashMap();
      paramContext.put("errCode", localObject);
      paramc.a(paramInt, a("fail:can't gain wifi list", paramContext));
      return;
    }
    if (paramd.a.equals("ok")) {
      try
      {
        o.d("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", new Object[] { Integer.valueOf(paramd.b.size()) });
        if (paramd.b.size() == 0)
        {
          if ((Build.VERSION.SDK_INT >= 23) && (!((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps")))
          {
            paramContext = new HashMap();
            paramContext.put("errCode", Integer.valueOf(12006));
            paramc.a(paramInt, a("fail:may be not open GPS", paramContext));
            o.b("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
            return;
          }
          boolean bool = j.a((Activity)paramContext, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
          o.d("MicroMsg.JsApiGetWifiList", "checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
          if (!bool)
          {
            paramContext = new HashMap();
            paramContext.put("errCode", Integer.valueOf(12012));
            paramc.a(paramInt, a("fail:may be not obtain GPS Perrmission", paramContext));
            o.b("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
            return;
          }
        }
        paramContext = new HashMap();
        paramContext.put("errCode", Integer.valueOf(0));
        paramc.a(paramInt, a("ok", paramContext));
        o.e("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", new Object[] { paramd });
        paramContext = new c.a();
        HashMap localHashMap = new HashMap();
        localHashMap.put("wifiList", paramd.a());
        paramContext.b(paramc, 0).b(localHashMap).a();
        return;
      }
      catch (JSONException paramContext)
      {
        o.a("MicroMsg.JsApiGetWifiList", paramContext, "", new Object[0]);
        paramContext = new HashMap();
        paramContext.put("errCode", localObject);
        paramc.a(paramInt, a("fail:parse json err", paramContext));
        return;
      }
    }
    o.b("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", new Object[] { paramd.a });
    paramContext = new HashMap();
    paramContext.put("errCode", localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fail:");
    ((StringBuilder)localObject).append(paramd.a);
    paramc.a(paramInt, a(((StringBuilder)localObject).toString(), paramContext));
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!d.a)
    {
      o.b("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.a(paramInt, a("fail:not invoke startWifi", paramJSONObject));
      return;
    }
    Context localContext = paramc.getContext();
    if (localContext == null)
    {
      o.b("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12010));
      paramc.a(paramInt, a("fail:context is null", paramJSONObject));
      return;
    }
    e.a(localContext);
    if (!com.tencent.luggage.wxa.mt.c.g())
    {
      o.b("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12005));
      paramc.a(paramInt, a("fail:wifi is disable", paramJSONObject));
      return;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new c.1(this, localAtomicBoolean, paramc, paramInt, localContext);
    localObject = new v(Looper.getMainLooper(), (v.a)localObject, false);
    e.a(new c.2(this, (v)localObject, localAtomicBoolean, paramc, paramInt, localContext));
    long l = 10000L;
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("timeout", 10000L);
    }
    paramc = new StringBuilder();
    paramc.append("invoke, getWifiListAsyncTimeoutMills: ");
    paramc.append(l);
    o.d("MicroMsg.JsApiGetWifiList", paramc.toString());
    ((v)localObject).a(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.c
 * JD-Core Version:    0.7.0.1
 */