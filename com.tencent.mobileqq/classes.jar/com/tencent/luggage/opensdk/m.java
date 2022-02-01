package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import org.json.JSONObject;

final class m
{
  static <CONTEXT extends b> com.tencent.luggage.wxa.ro.d<String> a(CONTEXT paramCONTEXT, f<CONTEXT> paramf, JSONObject paramJSONObject, int paramInt)
  {
    return h.a().d(new m.6(paramCONTEXT, paramf, paramJSONObject)).b(new m.5(paramf, paramCONTEXT, paramJSONObject, paramInt)).b(new m.4(paramCONTEXT, paramf)).b(new m.3(paramf, paramCONTEXT)).a(new m.2(paramCONTEXT, paramf)).d(new m.1(paramCONTEXT));
  }
  
  private static l b(b paramb)
  {
    if (paramb.q() == null) {
      return null;
    }
    return paramb.q().ap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.m
 * JD-Core Version:    0.7.0.1
 */