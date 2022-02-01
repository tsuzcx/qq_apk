package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.h.a;
import java.util.HashMap;
import java.util.Map;

class d$b$1
  implements h.a
{
  d$b$1(d.b paramb, c paramc) {}
  
  public boolean a(Object... paramVarArgs)
  {
    paramVarArgs = (float[])paramVarArgs[0];
    HashMap localHashMap = new HashMap();
    localHashMap.put("alpha", Float.valueOf(paramVarArgs[0]));
    localHashMap.put("beta", Float.valueOf(paramVarArgs[1]));
    localHashMap.put("gamma", Float.valueOf(paramVarArgs[2]));
    this.b.d.b(localHashMap);
    return i.a().a(this.b.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.d.b.1
 * JD-Core Version:    0.7.0.1
 */