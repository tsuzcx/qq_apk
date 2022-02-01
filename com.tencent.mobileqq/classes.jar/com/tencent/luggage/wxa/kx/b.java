package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pg.a.a;
import com.tencent.luggage.wxa.pg.a.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class b
  extends ah
  implements a.b
{
  private static final int CTRL_INDEX = 341;
  private static final String NAME = "onLocationChange";
  private final c a;
  
  b(c paramc)
  {
    this.a = paramc;
  }
  
  public void a(int paramInt, String paramString, a.a parama)
  {
    if (paramInt == -1)
    {
      o.b("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", new Object[] { Integer.valueOf(paramInt), paramString });
      return;
    }
    paramString = new HashMap(7);
    paramString.put("longitude", Double.valueOf(parama.b));
    paramString.put("latitude", Double.valueOf(parama.a));
    paramString.put("speed", Double.valueOf(parama.d));
    paramString.put("accuracy", Double.valueOf(parama.e));
    paramString.put("altitude", Double.valueOf(parama.f));
    paramString.put("verticalAccuracy", Float.valueOf(0.0F));
    paramString.put("horizontalAccuracy", Double.valueOf(parama.e));
    if (!af.c(parama.g))
    {
      paramString.put("buildingId", parama.g);
      paramString.put("floorName", parama.h);
    }
    paramString.put("provider", parama.c);
    paramString.put("indoorLocationType", Integer.valueOf(parama.j));
    paramString.put("direction", Float.valueOf(parama.k));
    paramString.put("steps", Double.valueOf(parama.l));
    paramString = new JSONObject(paramString).toString();
    o.f("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", new Object[] { this.a.getAppId(), parama.c, paramString });
    try
    {
      b(this.a).b(paramString).a();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.b
 * JD-Core Version:    0.7.0.1
 */