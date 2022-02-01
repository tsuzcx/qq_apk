package com.tencent.luggage.wxa.lx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.SignalStrength;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 39;
  public static final String NAME = "getNetworkType";
  private final AtomicBoolean a = new AtomicBoolean(false);
  private Method b = null;
  private volatile int c = 2147483647;
  private final AtomicBoolean d = new AtomicBoolean(false);
  private final f.b e = new f.b(this, null);
  
  private int a(@NonNull SignalStrength paramSignalStrength)
  {
    Method localMethod = c();
    if (localMethod == null) {
      return b(paramSignalStrength);
    }
    try
    {
      int i = ((Integer)localMethod.invoke(paramSignalStrength, new Object[0])).intValue();
      return i;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDbm, reflect getDbm fail since ");
      localStringBuilder.append(localException);
      o.c("MicroMsg.JsApiGetNetworkType", localStringBuilder.toString());
    }
    return b(paramSignalStrength);
  }
  
  @NonNull
  public static f.c a(@NonNull Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return f.c.g;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnected()))
      {
        if (paramContext.getType() == 1) {
          return f.c.f;
        }
        if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1) && (paramContext.getSubtype() != 4))
        {
          if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13)) {
            return f.c.c;
          }
          if ((paramContext.getSubtype() >= 13) && (paramContext.getSubtype() < 20)) {
            return f.c.d;
          }
          if (paramContext.getSubtype() >= 20) {
            return f.c.e;
          }
        }
        else
        {
          return f.c.b;
        }
      }
      else
      {
        paramContext = f.c.a;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      o.a("MicroMsg.JsApiGetNetworkType", paramContext, "", new Object[0]);
    }
    return f.c.g;
  }
  
  private void a(@NonNull c paramc, @NonNull f.a parama)
  {
    if (!this.d.getAndSet(true)) {
      com.tencent.luggage.wxa.rz.f.a.a(new f.3(this, paramc));
    }
    if (this.e.b())
    {
      parama.a(this.c);
      return;
    }
    this.e.a(parama);
  }
  
  private int b(@NonNull SignalStrength paramSignalStrength)
  {
    int i;
    if (paramSignalStrength.isGsm()) {
      i = c(paramSignalStrength);
    } else {
      i = paramSignalStrength.getCdmaDbm();
    }
    paramSignalStrength = new StringBuilder();
    paramSignalStrength.append("getDbmFallback, dBm: ");
    paramSignalStrength.append(i);
    o.d("MicroMsg.JsApiGetNetworkType", paramSignalStrength.toString());
    return i;
  }
  
  private void b(@NonNull c paramc, @NonNull f.a parama)
  {
    paramc = NetworkMonitor.getConnectionInfo((WifiManager)paramc.getContext().getApplicationContext().getSystemService("wifi"));
    if ((paramc != null) && (paramc.getBSSID() != null))
    {
      parama.a(paramc.getRssi());
      return;
    }
    o.c("MicroMsg.JsApiGetNetworkType", "getWifiSignalStrength, getConnectionInfo is invalid");
    parama.a(2147483647);
  }
  
  private int c(@NonNull SignalStrength paramSignalStrength)
  {
    int k = paramSignalStrength.getGsmSignalStrength();
    int j = -1;
    int i = k;
    if (k == 99) {
      i = -1;
    }
    if (i != -1) {
      j = i * 2 - 113;
    }
    return j;
  }
  
  private Method c()
  {
    if (!this.a.getAndSet(true)) {
      try
      {
        this.b = SignalStrength.class.getMethod("getDbm", new Class[0]);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGetDbmMethod, reflect getDbm fail since ");
        localStringBuilder.append(localException);
        o.c("MicroMsg.JsApiGetNetworkType", localStringBuilder.toString());
        this.b = null;
      }
    }
    return this.b;
  }
  
  protected f.c a(@NonNull c paramc)
  {
    return a(paramc.getContext());
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = new HashMap();
    f.c localc = a(paramc);
    o.d("MicroMsg.JsApiGetNetworkType", "invoke appId:%s, networkType:%s", new Object[] { paramc.getAppId(), localc });
    paramJSONObject.put("networkType", localc.h);
    switch (f.4.a[localc.ordinal()])
    {
    default: 
      return;
    case 6: 
    case 7: 
      paramc.a(paramInt, a("ok", paramJSONObject));
      return;
    case 5: 
      b(paramc, new f.2(this, paramJSONObject, paramc, paramInt));
      return;
    }
    a(paramc, new f.1(this, paramJSONObject, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.f
 * JD-Core Version:    0.7.0.1
 */