package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.d.e;
import org.json.JSONException;

public class c
{
  private Context a;
  private GrsBaseInfo b;
  private com.huawei.hms.framework.network.grs.a.a c;
  
  public c(Context paramContext, com.huawei.hms.framework.network.grs.a.a parama, GrsBaseInfo paramGrsBaseInfo)
  {
    this.a = paramContext;
    this.b = paramGrsBaseInfo;
    this.c = parama;
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject3 = com.huawei.hms.framework.network.grs.a.a(this.c.a().a("geoipCountryCode", ""), "geoip.countrycode", "ROOT");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("geoIpCountry is: ");
    ((StringBuilder)localObject1).append((String)localObject3);
    Logger.i("GeoipCountry", ((StringBuilder)localObject1).toString());
    localObject1 = this.c.a().a("geoipCountryCodetime", "0");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    long l2 = 0L;
    long l1 = l2;
    if (!bool)
    {
      l1 = l2;
      if (((String)localObject1).matches("\\d+")) {
        try
        {
          l1 = Long.parseLong((String)localObject1);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", localNumberFormatException);
          l1 = l2;
        }
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject3)) || (e.a(Long.valueOf(l1))))
    {
      Object localObject4 = new com.huawei.hms.framework.network.grs.c.b.c(this.b, this.a);
      ((com.huawei.hms.framework.network.grs.c.b.c)localObject4).a("geoip.countrycode");
      com.huawei.hms.framework.network.grs.a.c localc = this.c.c();
      Object localObject2;
      if (localc != null)
      {
        String str = localc.a("services", "");
        try
        {
          str = n.a(str, ((com.huawei.hms.framework.network.grs.c.b.c)localObject4).c());
        }
        catch (JSONException localJSONException)
        {
          Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException.", localJSONException);
          localObject2 = null;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localc.b("services", (String)localObject2);
        }
      }
      if (paramBoolean)
      {
        localObject4 = this.c.b().a((com.huawei.hms.framework.network.grs.c.b.c)localObject4, "geoip.countrycode", localc);
        localObject2 = localObject3;
        if (localObject4 != null) {
          localObject2 = com.huawei.hms.framework.network.grs.a.a(((f)localObject4).i(), "geoip.countrycode", "ROOT");
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("sync request to query geoip.countrycode is:");
        ((StringBuilder)localObject3).append((String)localObject2);
        Logger.i("GeoipCountry", ((StringBuilder)localObject3).toString());
        return localObject2;
      }
      Logger.i("GeoipCountry", "async request to query geoip.countrycode");
      this.c.b().a((com.huawei.hms.framework.network.grs.c.b.c)localObject4, null, "geoip.countrycode", localc);
    }
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.c
 * JD-Core Version:    0.7.0.1
 */