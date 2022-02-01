package com.tencent.luggage.wxa.og;

import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ix.b;
import java.util.HashMap;
import java.util.Map;

public class a
  extends com.tencent.luggage.wxa.oe.d
{
  public int a()
  {
    return 2;
  }
  
  public String a(i parami, com.tencent.luggage.wxa.oe.c paramc)
  {
    parami = paramc.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", Integer.valueOf(parami.q().al().a().ordinal()));
    return paramc.a(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.og.a
 * JD-Core Version:    0.7.0.1
 */