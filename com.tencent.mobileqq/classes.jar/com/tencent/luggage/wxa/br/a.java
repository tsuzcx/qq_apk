package com.tencent.luggage.wxa.br;

import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.lx.k;
import java.util.Map;

public final class a
  extends k<c>
{
  protected Map<String, Object> a(c paramc)
  {
    Map localMap = super.a(paramc);
    int i = com.tencent.luggage.wxa.bw.a.a(paramc);
    if (i > 0) {
      localMap.put("statusBarHeight", Integer.valueOf(i));
    }
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.br.a
 * JD-Core Version:    0.7.0.1
 */