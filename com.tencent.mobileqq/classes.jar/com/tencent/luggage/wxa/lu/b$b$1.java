package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.h.a;
import java.util.HashMap;
import java.util.Map;

class b$b$1
  implements h.a
{
  b$b$1(b.b paramb, c paramc) {}
  
  public boolean a(Object... paramVarArgs)
  {
    paramVarArgs = (float[])paramVarArgs[0];
    HashMap localHashMap = new HashMap();
    localHashMap.put("x", Float.valueOf(-paramVarArgs[0] / 10.0F));
    localHashMap.put("y", Float.valueOf(-paramVarArgs[1] / 10.0F));
    localHashMap.put("z", Float.valueOf(-paramVarArgs[2] / 10.0F));
    this.b.d.b(localHashMap);
    return i.a().a(this.b.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.b.b.1
 * JD-Core Version:    0.7.0.1
 */