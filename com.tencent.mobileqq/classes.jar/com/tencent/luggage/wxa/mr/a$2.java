package com.tencent.luggage.wxa.mr;

import android.content.Context;
import com.tencent.luggage.wxa.ms.e;
import com.tencent.luggage.wxa.mt.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

class a$2
  implements com.tencent.luggage.wxa.ms.a
{
  a$2(a parama, i parami, com.tencent.luggage.wxa.bg.a parama1, Context paramContext, com.tencent.luggage.wxa.jx.c paramc, int paramInt) {}
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    e.a(null);
    t.a(new a.2.1(this));
    if (paramString3.equals("ok"))
    {
      localObject = e.a();
      paramString3 = (String)localObject;
      if (localObject == null)
      {
        o.d("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback] currentWiFi is null, use WifiConfiguration");
        paramString3 = b.a(paramString2);
        if (paramString3 == null) {
          o.c("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback] curWifiConfig is null");
        }
        paramString3 = com.tencent.luggage.wxa.ms.c.a(paramString1, paramString2, paramString3);
      }
      o.d("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", new Object[] { paramString3 });
      if (paramString3 == null)
      {
        o.b("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWIfi is null");
        paramString1 = new HashMap();
        paramString2 = a.a(this.f, this.c, paramString1, "fail:can't gain current wifi");
        this.d.a(this.e, this.f.a(paramString2, paramString1));
        return;
      }
      try
      {
        paramString1 = new HashMap();
        paramString1.put("wifi", paramString3.a());
        paramString1.put("errCode", Integer.valueOf(0));
        this.d.a(this.e, this.f.a("ok", paramString1));
        return;
      }
      catch (JSONException paramString1)
      {
        o.b("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
        o.a("MicroMsg.JsApiConenctWifi", paramString1, "", new Object[0]);
        paramString1 = new HashMap();
        paramString1.put("errCode", Integer.valueOf(12010));
        this.d.a(this.e, this.f.a("fail:parse json err", paramString1));
        return;
      }
    }
    paramString1 = new HashMap();
    if (paramString3.equals("duplicated request")) {
      paramString1.put("errCode", Integer.valueOf(12004));
    } else if (paramString3.equals("password error")) {
      paramString1.put("errCode", Integer.valueOf(12002));
    } else if (paramString3.equals("wifi config may be expired")) {
      paramString1.put("errCode", Integer.valueOf(12013));
    } else if (paramString3.equals("fail to connect wifi:time out")) {
      paramString1.put("errCode", Integer.valueOf(12003));
    } else {
      paramString3 = a.a(this.f, this.c, paramString1, paramString3);
    }
    o.b("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errCode:%d, errMsg:%s", new Object[] { paramString1.get("errCode"), paramString3 });
    paramString2 = this.d;
    int i = this.e;
    Object localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramString3);
    paramString2.a(i, ((a)localObject).a(localStringBuilder.toString(), paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.a.2
 * JD-Core Version:    0.7.0.1
 */