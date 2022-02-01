package com.tencent.luggage.wxa.hd;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;

final class c$7
  extends c.b
{
  c$7(c.a parama)
  {
    super(parama);
  }
  
  String a()
  {
    Object localObject = (WifiManager)r.a().getApplicationContext().getSystemService("wifi");
    String str = null;
    if (localObject != null) {
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      str = ((WifiInfo)localObject).getMacAddress();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.7
 * JD-Core Version:    0.7.0.1
 */