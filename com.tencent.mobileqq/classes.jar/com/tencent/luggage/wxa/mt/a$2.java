package com.tencent.luggage.wxa.mt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;

class a$2
  extends BroadcastReceiver
{
  a$2(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramContext = paramIntent.getAction();
    if (TextUtils.isEmpty(paramContext)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMonitorWiFiEvent, action: ");
    localStringBuilder.append(paramContext);
    o.d("MicroMsg.WiFiConnector", localStringBuilder.toString());
    if ((!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext)) && (!"android.net.wifi.STATE_CHANGE".equals(paramContext)))
    {
      if ("android.net.wifi.supplicant.STATE_CHANGE".equals(paramContext))
      {
        int i = -1;
        try
        {
          int j = paramIntent.getIntExtra("supplicantError", -1);
          i = j;
        }
        catch (Exception paramContext)
        {
          o.b("MicroMsg.WiFiConnector", paramContext.getMessage());
        }
        if (i == 1)
        {
          o.b("MicroMsg.WiFiConnector", "ERROR_AUTHENTICATING");
          o.d("MicroMsg.wifi_event", "ERROR_AUTHENTICATING FAIL.");
          paramIntent = this.a;
          if (a.c(paramIntent)) {
            paramContext = "wifi config may be expired";
          } else {
            paramContext = "password error";
          }
          a.a(paramIntent, false, paramContext);
        }
      }
    }
    else
    {
      paramContext = a.a(this.a).getActiveNetworkInfo();
      paramIntent = c.d();
      if ((paramContext != null) && (paramIntent != null) && (paramContext.getType() == 1) && (paramContext.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) && (paramIntent.getNetworkId() == a.b(this.a).networkId))
      {
        a.a(this.a, true, "");
        o.d("MicroMsg.wifi_event", "CONNECTIVITY_ACTION CONNECTED.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.a.2
 * JD-Core Version:    0.7.0.1
 */