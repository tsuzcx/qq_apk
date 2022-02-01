package com.tencent.luggage.wxa.ex;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import java.util.List;

class a$2
  implements TencentLocationListener
{
  a$2(a parama) {}
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (t.a())
    {
      f.a.a(new a.2.1(this, this, paramTencentLocation, paramInt, paramString), "MicroMsg.DefaultTencentLocationManager");
      return;
    }
    o.f("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (paramInt != 0) {
      o.b("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    }
    a locala;
    if ((a.a(this.a) != null) && (a.a(this.a).size() > 0))
    {
      locala = this.a;
      a.a(locala, a.a(locala), paramInt, paramString, a.a(this.a, paramTencentLocation, false));
      a.a(this.a).clear();
    }
    if ((a.b(this.a) != null) && (a.b(this.a).size() > 0))
    {
      locala = this.a;
      a.a(locala, a.b(locala), paramInt, paramString, a.a(this.a, paramTencentLocation, true));
      a.b(this.a).clear();
    }
    if ((a.c(this.a) != null) && (a.c(this.a).size() > 0))
    {
      locala = this.a;
      a.a(locala, a.c(locala), paramInt, paramString, a.a(this.a, paramTencentLocation, false));
    }
    if ((a.d(this.a) != null) && (a.d(this.a).size() > 0))
    {
      locala = this.a;
      a.a(locala, a.d(locala), paramInt, paramString, a.a(this.a, paramTencentLocation, true));
    }
    a.e(this.a);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    o.d("MicroMsg.DefaultTencentLocationManager", "[mlocationListener]name:%s, status:%d, desc:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ex.a.2
 * JD-Core Version:    0.7.0.1
 */