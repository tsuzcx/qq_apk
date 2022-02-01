package com.tencent.luggage.wxa.dg;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.luggage.wxa.rr.g;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "productId", "", "deviceId", "", "kotlin.jvm.PlatformType", "username", "token", "hostAppId", "extraData", "callback"}, k=3, mv={1, 1, 16})
final class d$a$1
  implements b.a
{
  d$a$1(b paramb) {}
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("productId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", deviceId:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" token:");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(" hostAppId:");
    localStringBuilder.append(paramString4);
    localStringBuilder.append(" userName:");
    localStringBuilder.append(paramString2);
    o.e("WxaDeviceLogic", localStringBuilder.toString());
    if (d.a(d.a, Integer.valueOf(paramInt), paramString1, paramString2, paramString3))
    {
      this.a.a(new Object[] { g.a(Integer.valueOf(paramInt), paramString1, paramString2, paramString3, paramString4, paramString5) });
      return;
    }
    d.a.j();
    this.a.a("activate device fail: obtain token fail by ilink");
    paramString2 = new StringBuilder();
    paramString2.append("activate device [");
    paramString2.append(paramInt);
    paramString2.append("] [");
    paramString2.append(paramString1);
    paramString2.append("] fail: obtain token:[");
    paramString2.append(paramString3);
    paramString2.append("] fail by ilink");
    o.b("WxaDeviceLogic", paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dg.d.a.1
 * JD-Core Version:    0.7.0.1
 */