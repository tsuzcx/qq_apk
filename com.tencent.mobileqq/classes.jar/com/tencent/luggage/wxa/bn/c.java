package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.bq.f;
import com.tencent.luggage.wxa.jx.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class c
{
  public Map<String, m> a()
  {
    Object localObject = new HashSet();
    ((HashSet)localObject).add(new com.tencent.luggage.wxa.bq.e());
    ((HashSet)localObject).add(new f());
    ((HashSet)localObject).add(new com.tencent.luggage.wxa.bq.d());
    ((HashSet)localObject).add(new a());
    ((HashSet)localObject).add(new b());
    ((HashSet)localObject).add(new d());
    ((HashSet)localObject).add(new e());
    ((HashSet)localObject).add(new com.tencent.luggage.wxa.br.a());
    ((HashSet)localObject).add(new com.tencent.luggage.wxa.ld.e(com.tencent.luggage.wxa.ld.e.b, new c.1(this)));
    HashMap localHashMap = new HashMap();
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      m localm = (m)((Iterator)localObject).next();
      localHashMap.put(localm.d(), localm);
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bn.c
 * JD-Core Version:    0.7.0.1
 */