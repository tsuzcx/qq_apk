package com.tencent.luggage.wxa.ms;

import android.net.wifi.WifiConfiguration;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.mt.d;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONObject;

public class c
{
  public String a = "";
  public String b = "";
  public int c;
  public boolean d = false;
  public int e;
  public boolean f = false;
  public boolean g = false;
  
  @Nullable
  public static c a(@Nullable String paramString1, @Nullable String paramString2, @Nullable WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration == null) {
      return null;
    }
    c localc = new c();
    localc.a = af.a(paramString1, "");
    localc.b = af.a(paramString2, "");
    boolean bool;
    if (2 == d.a(paramWifiConfiguration)) {
      bool = true;
    } else {
      bool = false;
    }
    localc.d = bool;
    localc.c = d.b(paramString2);
    return localc;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("SSID", this.a);
    localJSONObject.put("BSSID", this.b);
    localJSONObject.put("secure", this.d);
    localJSONObject.put("signalStrength", this.c);
    localJSONObject.put("frequency", this.e);
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WiFiItem{mSsid='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBssid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSignalStrength=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mSecurity=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", frequency=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ms.c
 * JD-Core Version:    0.7.0.1
 */