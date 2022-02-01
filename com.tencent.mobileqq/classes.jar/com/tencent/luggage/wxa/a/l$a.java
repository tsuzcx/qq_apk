package com.tencent.luggage.wxa.a;

import java.util.HashMap;
import java.util.Map;

class l$a
{
  private static final Map<String, f.a> a = new HashMap(10);
  
  static
  {
    a.put("none", f.a.a);
    a.put("xMinYMin", f.a.b);
    a.put("xMidYMin", f.a.c);
    a.put("xMaxYMin", f.a.d);
    a.put("xMinYMid", f.a.e);
    a.put("xMidYMid", f.a.f);
    a.put("xMaxYMid", f.a.g);
    a.put("xMinYMax", f.a.h);
    a.put("xMidYMax", f.a.i);
    a.put("xMaxYMax", f.a.j);
  }
  
  static f.a a(String paramString)
  {
    return (f.a)a.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.a.l.a
 * JD-Core Version:    0.7.0.1
 */