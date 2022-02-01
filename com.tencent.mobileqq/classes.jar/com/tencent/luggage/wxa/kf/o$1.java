package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.kl.j;
import java.util.HashMap;
import java.util.Map;

class o$1
  implements b
{
  o$1(o paramo, com.tencent.luggage.wxa.jx.c paramc, int paramInt) {}
  
  public void a(j paramj)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", new Object[] { paramj });
    if (paramj.u != 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.u));
      localHashMap.put("isDiscovering", Boolean.valueOf(false));
      this.a.a(this.b, this.c.a(paramj.v, localHashMap));
      com.tencent.luggage.wxa.ke.c.a(13);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    paramj.put("isDiscovering", Boolean.valueOf(true));
    this.a.a(this.b, this.c.a("ok", paramj));
    com.tencent.luggage.wxa.ke.c.a(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.o.1
 * JD-Core Version:    0.7.0.1
 */