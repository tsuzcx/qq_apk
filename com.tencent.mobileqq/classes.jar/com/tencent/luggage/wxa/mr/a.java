package com.tencent.luggage.wxa.mr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 316;
  public static final String NAME = "connectWifi";
  
  @NonNull
  private String a(@NonNull Context paramContext, @NonNull Map<String, Object> paramMap, @NonNull String paramString)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (!((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps")))
    {
      paramMap.put("errCode", Integer.valueOf(12006));
      o.b("MicroMsg.JsApiConenctWifi", "fixErrInfo, may be not open GPS");
      return "fail:may be not open GPS";
    }
    boolean bool = j.a((Activity)paramContext, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
    o.d("MicroMsg.JsApiConenctWifi", "fixErrInfo, checkLocation:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      paramMap.put("errCode", Integer.valueOf(12012));
      o.b("MicroMsg.JsApiConenctWifi", "fixErrInfo, may be not obtain GPS Perrmission");
      return "fail:may be not obtain GPS Perrmission";
    }
    paramMap.put("errCode", Integer.valueOf(12010));
    return paramString;
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!d.a)
    {
      o.b("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(12000));
      paramc.a(paramInt, a("fail:not invoke startWifi", paramJSONObject));
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("SSID")))
    {
      Object localObject1 = paramc.getContext();
      if (localObject1 == null)
      {
        o.b("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12010));
        paramc.a(paramInt, a("fail:context is null", paramJSONObject));
        return;
      }
      com.tencent.luggage.wxa.ms.e.a((Context)localObject1);
      if (!com.tencent.luggage.wxa.mt.c.g())
      {
        o.b("MicroMsg.JsApiConenctWifi", "wifi is disable");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12005));
        paramc.a(paramInt, a("fail:wifi is disable", paramJSONObject));
        return;
      }
      if (paramc.getAppState() != b.a)
      {
        o.b("MicroMsg.JsApiConenctWifi", "current state :%s isn't foreground", new Object[] { paramc.getAppState() });
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12011));
        paramc.a(paramInt, a("fail:weapp in background", paramJSONObject));
        return;
      }
      if (paramJSONObject.optBoolean("maunal", false))
      {
        localObject2 = new Intent("android.settings.WIFI_SETTINGS");
        if (af.a((Context)localObject1, (Intent)localObject2))
        {
          o.d("MicroMsg.JsApiConenctWifi", "use manual");
          ((Context)localObject1).startActivity((Intent)localObject2);
          paramJSONObject = new HashMap();
          paramJSONObject.put("errCode", Integer.valueOf(0));
          paramc.a(paramInt, a("ok", paramJSONObject));
          return;
        }
        o.c("MicroMsg.JsApiConenctWifi", "jump2SysWifiSettingsIntent is unavailable");
      }
      Object localObject2 = (com.tencent.luggage.wxa.bg.a)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.bg.a.class);
      i locali = ((com.tencent.luggage.wxa.bg.a)localObject2).a((Context)localObject1);
      t.a(new a.1(this, paramc, locali));
      com.tencent.luggage.wxa.ms.e.a(new a.2(this, locali, (com.tencent.luggage.wxa.bg.a)localObject2, (Context)localObject1, paramc, paramInt));
      localObject1 = new a.3(this, paramc);
      com.tencent.luggage.wxa.iu.c.a(paramc.getAppId(), (c.c)localObject1);
      localObject1 = paramJSONObject.optString("SSID");
      localObject2 = paramJSONObject.optString("BSSID");
      paramJSONObject = paramJSONObject.optString("password");
      if (((String)localObject1).equals(""))
      {
        o.b("MicroMsg.JsApiConenctWifi", "params is invalid");
        paramJSONObject = new HashMap();
        paramJSONObject.put("errCode", Integer.valueOf(12008));
        paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
        return;
      }
      o.d("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", new Object[] { localObject1, localObject2 });
      com.tencent.luggage.wxa.ms.e.a((String)localObject1, (String)localObject2, paramJSONObject);
      return;
    }
    o.b("MicroMsg.JsApiConenctWifi", "params is invalid");
    paramJSONObject = new HashMap();
    paramJSONObject.put("errCode", Integer.valueOf(12010));
    paramc.a(paramInt, a("fail:invalid data", paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.a
 * JD-Core Version:    0.7.0.1
 */