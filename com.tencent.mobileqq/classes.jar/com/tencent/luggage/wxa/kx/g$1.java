package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pg.a.a;
import com.tencent.luggage.wxa.pg.a.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class g$1
  implements a.b
{
  g$1(g paramg, c paramc, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void a(int paramInt, String paramString, a.a parama)
  {
    o.d("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", new Object[] { Integer.valueOf(paramInt), paramString, parama });
    this.e.a(this.a, paramInt, paramString, parama);
    if (paramInt == 0)
    {
      paramString = new HashMap(4);
      paramString.put("type", this.b);
      paramString.put("latitude", Double.valueOf(parama.a));
      paramString.put("longitude", Double.valueOf(parama.b));
      paramString.put("speed", Double.valueOf(parama.d));
      paramString.put("accuracy", Double.valueOf(parama.e));
      if (this.c) {
        paramString.put("altitude", Double.valueOf(parama.f));
      }
      paramString.put("provider", parama.c);
      paramString.put("verticalAccuracy", Integer.valueOf(0));
      paramString.put("horizontalAccuracy", Double.valueOf(parama.e));
      if (!af.c(parama.g))
      {
        paramString.put("buildingId", parama.g);
        paramString.put("floorName", parama.h);
      }
      paramString.put("indoorLocationType", Integer.valueOf(parama.j));
      paramString.put("direction", Float.valueOf(parama.k));
      paramString.put("steps", Double.valueOf(parama.l));
      this.a.a(this.d, this.e.a("ok", paramString));
      return;
    }
    parama = new HashMap(1);
    parama.put("errCode", Integer.valueOf(paramInt));
    c localc = this.a;
    paramInt = this.d;
    g localg = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramString);
    localc.a(paramInt, localg.a(localStringBuilder.toString(), parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.g.1
 * JD-Core Version:    0.7.0.1
 */