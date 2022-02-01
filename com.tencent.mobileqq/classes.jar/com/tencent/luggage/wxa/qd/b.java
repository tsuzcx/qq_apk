package com.tencent.luggage.wxa.qd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
  extends com.tencent.luggage.wxa.gr.a
{
  protected com.tencent.luggage.wxa.gv.c b(com.tencent.luggage.wxa.if.b paramb)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (paramb.w != null) {
      localConcurrentHashMap.put(paramb.b, paramb.w);
    }
    return new c(new com.tencent.luggage.wxa.qp.a(localConcurrentHashMap), paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.b
 * JD-Core Version:    0.7.0.1
 */