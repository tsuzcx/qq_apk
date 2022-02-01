package com.tencent.luggage.wxa.ms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.wxa.qz.o;

class e$a
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    o.d("MicroMsg.WiFiManagerWrapper", "onReceive");
    if ((paramIntent != null) && ("android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
    {
      paramContext = e.d();
      if (paramContext == null)
      {
        o.d("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
        return;
      }
      paramContext.a(e.a(false));
      return;
    }
    o.c("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ms.e.a
 * JD-Core Version:    0.7.0.1
 */