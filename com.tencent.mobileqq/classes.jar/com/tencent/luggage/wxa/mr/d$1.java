package com.tencent.luggage.wxa.mr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.ms.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

class d$1
  extends BroadcastReceiver
{
  d$1(d paramd, com.tencent.luggage.wxa.jx.c paramc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    o.d("MicroMsg.JsApiStartWifi", "actiong:%s", new Object[] { paramContext });
    int i;
    Object localObject;
    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext))
    {
      i = paramIntent.getIntExtra("wifi_state", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("wifiState");
      ((StringBuilder)localObject).append(i);
      o.d("MicroMsg.JsApiStartWifi", ((StringBuilder)localObject).toString());
      if (i != 0) {
        if (i != 1)
        {
          if ((i == 2) || (i == 3)) {}
        }
        else {
          d.a(this.b, this.a);
        }
      }
    }
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      paramContext = paramIntent.getParcelableExtra("networkInfo");
      if (paramContext != null)
      {
        paramContext = (NetworkInfo)paramContext;
        if (paramContext.getState() == NetworkInfo.State.CONNECTED) {
          i = 1;
        } else {
          i = 0;
        }
        int j;
        if (paramContext.getType() == 1) {
          j = 1;
        } else {
          j = 0;
        }
        if ((i != 0) && (j != 0))
        {
          paramContext = e.a();
          o.d("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", new Object[] { paramContext });
          if (paramContext == null)
          {
            o.b("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
            return;
          }
          try
          {
            paramIntent = new a.a();
            localObject = new HashMap();
            ((HashMap)localObject).put("wifi", paramContext.a());
            paramIntent.b(this.a, 0).b((Map)localObject).a();
            return;
          }
          catch (JSONException paramContext)
          {
            o.b("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
            o.a("MicroMsg.JsApiStartWifi", paramContext, "", new Object[0]);
            return;
          }
        }
        d.a(this.b, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mr.d.1
 * JD-Core Version:    0.7.0.1
 */