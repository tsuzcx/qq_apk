package com.tencent.luggage.wxa.og;

import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oe.b;
import com.tencent.luggage.wxa.oe.c;
import com.tencent.luggage.wxa.oo.a;
import com.tencent.luggage.wxa.oo.d;
import java.util.HashMap;
import java.util.Map;

public class g
  extends b
{
  private void a(c paramc, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", Integer.valueOf(paramInt));
    paramc.a(localHashMap);
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(i parami, c paramc)
  {
    parami = parami.optString("apiName");
    h localh = paramc.a();
    if (a.a(localh.getAppId(), parami))
    {
      a(paramc, 1);
      return;
    }
    a.a(new d(localh, parami), new g.1(this, paramc, parami));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.og.g
 * JD-Core Version:    0.7.0.1
 */