package com.tencent.luggage.wxa.a;

import java.util.HashMap;
import java.util.Map;

class l$c
{
  private static final Map<String, h.p> a = new HashMap(9);
  
  static
  {
    a.put("xx-small", new h.p(0.694F, h.bd.g));
    a.put("x-small", new h.p(0.833F, h.bd.g));
    a.put("small", new h.p(10.0F, h.bd.g));
    a.put("medium", new h.p(12.0F, h.bd.g));
    a.put("large", new h.p(14.4F, h.bd.g));
    a.put("x-large", new h.p(17.299999F, h.bd.g));
    a.put("xx-large", new h.p(20.700001F, h.bd.g));
    a.put("smaller", new h.p(83.330002F, h.bd.i));
    a.put("larger", new h.p(120.0F, h.bd.i));
  }
  
  static h.p a(String paramString)
  {
    return (h.p)a.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.c
 * JD-Core Version:    0.7.0.1
 */