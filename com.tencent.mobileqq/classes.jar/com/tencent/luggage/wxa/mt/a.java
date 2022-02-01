package com.tencent.luggage.wxa.mt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class a
{
  a.a a = null;
  a.b b = null;
  private com.tencent.luggage.wxa.ms.a c;
  private Context d;
  private Handler e = null;
  private WifiConfiguration f = null;
  private boolean g = false;
  private BroadcastReceiver h = null;
  private ConnectivityManager i;
  private int j = 0;
  private final int k = 13000;
  private String l;
  private String m;
  private boolean n = false;
  
  public a(com.tencent.luggage.wxa.ms.a parama, Context paramContext)
  {
    this.c = parama;
    this.d = paramContext;
    try
    {
      this.i = ((ConnectivityManager)this.d.getSystemService("connectivity"));
    }
    catch (Exception parama)
    {
      o.a("MicroMsg.WiFiConnector", parama, "can not retrieve ConnectivityManager", new Object[0]);
    }
    this.e = new a.1(this, paramContext.getMainLooper());
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "UnknowState";
          }
          return "STATE_FAIL";
        }
        return "STATE_CONNECTED";
      }
      return "STATE_CONNECTING";
    }
    return "STATE_NONE";
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finishConnectTask success:");
    ((StringBuilder)localObject).append(paramBoolean);
    o.d("MicroMsg.WiFiConnector", ((StringBuilder)localObject).toString());
    if (!a())
    {
      localObject = this.c;
      if (localObject != null)
      {
        String str1 = this.l;
        String str2 = this.m;
        if (paramBoolean) {
          paramString = "ok";
        }
        ((com.tencent.luggage.wxa.ms.a)localObject).a(str1, str2, paramString);
      }
      this.e.removeMessages(1);
      c();
      int i1;
      if (paramBoolean) {
        i1 = 2;
      } else {
        i1 = 3;
      }
      b(i1);
      if (!paramBoolean)
      {
        paramString = this.f;
        if (paramString != null) {
          b.a(paramString.networkId);
        }
      }
    }
  }
  
  private boolean a(WifiConfiguration paramWifiConfiguration)
  {
    if ((paramWifiConfiguration != null) && (paramWifiConfiguration.networkId != d.a))
    {
      if (this.i == null) {
        return false;
      }
      try
      {
        Class localClass1 = Class.forName("android.net.wifi.WifiManager");
        if (Build.VERSION.SDK_INT < 16)
        {
          localClass1.getMethod("asyncConnect", new Class[] { Context.class, Handler.class }).invoke(c.a(), new Object[] { this.d, this.e });
          localClass1.getMethod("connectNetwork", new Class[] { Integer.TYPE }).invoke(c.a(), new Object[] { Integer.valueOf(paramWifiConfiguration.networkId) });
          return true;
        }
        int i1 = Build.VERSION.SDK_INT;
        if (i1 == 16)
        {
          if (this.b == null) {
            this.b = new a.b(this);
          }
          localObject1 = a(this.a, "android.net.wifi.WifiManager$ChannelListener");
          localObject1 = localClass1.getMethod("initialize", new Class[] { Context.class, Looper.class, Class.forName("android.net.wifi.WifiManager$ChannelListener") }).invoke(c.a(), new Object[] { this.d, this.d.getMainLooper(), localObject1 });
          if (this.a == null) {
            this.a = new a.a(this, paramWifiConfiguration);
          }
          localObject2 = a(this.a, "android.net.wifi.WifiManager$ActionListener");
          Class localClass2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
          localClass1.getMethod("connect", new Class[] { Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, localClass2 }).invoke(c.a(), new Object[] { localObject1, Integer.valueOf(paramWifiConfiguration.networkId), localObject2 });
          return true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
          return b(paramWifiConfiguration);
        }
        if (this.a == null) {
          this.a = new a.a(this, paramWifiConfiguration);
        }
        localObject1 = a(this.a, "android.net.wifi.WifiManager$ActionListener");
        Object localObject2 = Class.forName("android.net.wifi.WifiManager$ActionListener");
        localClass1.getMethod("connect", new Class[] { Integer.TYPE, localObject2 }).invoke(c.a(), new Object[] { Integer.valueOf(paramWifiConfiguration.networkId), localObject1 });
        return true;
      }
      catch (Exception localException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("connectWifi fail since ");
        ((StringBuilder)localObject1).append(localException.toString());
        ((StringBuilder)localObject1).append(", try fallback");
        o.c("MicroMsg.WiFiConnector", ((StringBuilder)localObject1).toString());
        return b(paramWifiConfiguration);
      }
    }
    return false;
  }
  
  private void b()
  {
    if (!this.g)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.setPriority(2147483647);
      this.h = new a.2(this);
      this.d.registerReceiver(this.h, localIntentFilter);
      this.g = true;
      o.d("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
    }
  }
  
  private void b(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchState:");
      localStringBuilder.append(a(this.j));
      o.d("MicroMsg.WiFiConnector", localStringBuilder.toString());
    }
  }
  
  private boolean b(WifiConfiguration paramWifiConfiguration)
  {
    o.d("MicroMsg.WiFiConnector", "doConnectWifiFallbackLogic");
    return c.a(paramWifiConfiguration.networkId, true);
  }
  
  private void c()
  {
    if (this.g)
    {
      this.d.unregisterReceiver(this.h);
      this.g = false;
      o.d("MicroMsg.WiFiConnector", "stopMonitorWiFiEvent");
    }
  }
  
  Object a(a.a parama, String paramString)
  {
    paramString = Class.forName(paramString);
    return Proxy.newProxyInstance(paramString.getClassLoader(), new Class[] { paramString }, parama);
  }
  
  public void a(String paramString)
  {
    WifiConfiguration localWifiConfiguration = this.f;
    if (localWifiConfiguration != null)
    {
      b.a(localWifiConfiguration.networkId);
      a(false, paramString);
      paramString = new StringBuilder();
      paramString.append("cancelConnect, ");
      paramString.append(d.a(this.f.SSID));
      paramString.append(" networkId:");
      paramString.append(this.f.networkId);
      o.d("MicroMsg.wifi_event", paramString.toString());
      o.d("MicroMsg.WiFiConnector", "cancelConnect");
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ssid:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" bssid:");
    ((StringBuilder)localObject).append(paramString2);
    o.d("MicroMsg.WiFiConnector", ((StringBuilder)localObject).toString());
    this.l = paramString1;
    this.m = paramString2;
    int i1;
    if (TextUtils.isEmpty(paramString3)) {
      i1 = 0;
    } else {
      i1 = 2;
    }
    paramString3 = b.a(paramString1, i1, paramString3);
    localObject = b.b(paramString1, i1);
    o.d("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", new Object[] { paramString3, localObject });
    if (paramString3 != null)
    {
      paramString2 = paramString3;
      if (localObject != null)
      {
        paramString2 = paramString3;
        if (!b.c(paramString1, i1))
        {
          o.d("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
          paramString3.networkId = b.a(paramString3);
          paramString2 = paramString3;
          if (paramString3.networkId == d.a)
          {
            o.d("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
            this.n = true;
            paramString2 = (String)localObject;
          }
        }
      }
      if (paramString2.networkId == d.a) {
        paramString2.networkId = b.a(paramString2);
      }
      if (paramString2.networkId != d.a)
      {
        if (a(paramString2))
        {
          o.d("MicroMsg.wifi_event", "CONNECTING");
          b(1);
          this.f = paramString2;
          b();
          this.e.sendEmptyMessageDelayed(1, 13000L);
          return;
        }
        o.d("MicroMsg.WiFiConnector", "connect, connectWifi fail");
      }
      else
      {
        o.d("MicroMsg.WiFiConnector", "connect, addConfig fail");
      }
    }
    a(false, "fail to connect wifi:invalid network id");
    o.d("MicroMsg.wifi_event", "connect args wrong FAIL.");
  }
  
  public boolean a()
  {
    int i1 = this.j;
    return (i1 == 3) || (i1 == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mt.a
 * JD-Core Version:    0.7.0.1
 */