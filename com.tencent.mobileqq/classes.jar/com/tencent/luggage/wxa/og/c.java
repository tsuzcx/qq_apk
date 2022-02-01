package com.tencent.luggage.wxa.og;

import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.nz.j;
import com.tencent.luggage.wxa.oe.d;
import java.util.HashMap;
import java.util.Map;

public class c
  extends d
{
  public int a()
  {
    return 6;
  }
  
  protected String a(i parami, com.tencent.luggage.wxa.oe.c paramc)
  {
    parami = (String)j.a(parami.optString("url")).get("host");
    HashMap localHashMap = new HashMap();
    boolean bool;
    if (j.b(parami) == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localHashMap.put("isLANIp", Boolean.valueOf(bool));
    return paramc.a(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.og.c
 * JD-Core Version:    0.7.0.1
 */