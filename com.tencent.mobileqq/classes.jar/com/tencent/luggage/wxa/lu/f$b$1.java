package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.h.a;
import java.util.HashMap;
import java.util.Map;

class f$b$1
  implements h.a
{
  f$b$1(f.b paramb, c paramc) {}
  
  public boolean a(Object... paramVarArgs)
  {
    paramVarArgs = (float[])paramVarArgs[0];
    HashMap localHashMap = new HashMap();
    localHashMap.put("x", Float.valueOf(paramVarArgs[0]));
    localHashMap.put("y", Float.valueOf(paramVarArgs[1]));
    localHashMap.put("z", Float.valueOf(paramVarArgs[2]));
    this.b.d.b(localHashMap);
    return i.a().a(this.b.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.f.b.1
 * JD-Core Version:    0.7.0.1
 */