package com.tencent.luggage.wxa.mt;

import android.net.wifi.WifiConfiguration;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class a$a
  implements InvocationHandler
{
  private final WifiConfiguration b;
  
  public a$a(a parama, @NonNull WifiConfiguration paramWifiConfiguration)
  {
    this.b = paramWifiConfiguration;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getName().compareTo("onSuccess") == 0)
    {
      o.d("MicroMsg.WiFiConnector", "connectWifi use ActionListener success");
      return null;
    }
    if (paramMethod.getName().compareTo("onFailure") == 0)
    {
      o.c("MicroMsg.WiFiConnector", "connectWifi use ActionListener fail, fallback to enableNetwork");
      c.a(this.b.networkId, true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.a.a
 * JD-Core Version:    0.7.0.1
 */