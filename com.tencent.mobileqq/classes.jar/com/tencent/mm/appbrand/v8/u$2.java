package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.utils.V8ObjectUtils;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;

class u$2
  implements JavaCallback
{
  u$2(u paramu, n paramn) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() >= 2) && (paramV8Array.getType(0) == 7))
    {
      V8Function localV8Function = (V8Function)paramV8Array.getObject(0);
      int i;
      if (paramV8Array.getType(1) == 1)
      {
        i = paramV8Array.getInteger(1);
      }
      else if (paramV8Array.getType(1) == 2)
      {
        i = (int)paramV8Array.getDouble(1);
      }
      else
      {
        if (paramV8Array.getType(1) != 4) {
          break label173;
        }
        int j = u.a(paramV8Array.getString(1), -2147483648);
        i = j;
        if (j == -2147483648) {
          return null;
        }
      }
      if (paramV8Array.length() > 2)
      {
        paramV8Object = V8ObjectUtils.toList(paramV8Array);
        paramV8Object = V8ObjectUtils.toV8Array(this.a.b(), paramV8Object.subList(1, paramV8Object.size()));
      }
      else
      {
        paramV8Object = this.a.b().newV8Array();
      }
      return Integer.valueOf(u.b(this.b, this.a, localV8Function, i, paramV8Object));
      label173:
      o.c("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters[1] type:%d", new Object[] { Integer.valueOf(paramV8Array.getType(1)) });
      return null;
    }
    o.c("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters invalid length:%d type[0]:%d", new Object[] { Integer.valueOf(paramV8Array.length()), Integer.valueOf(paramV8Array.getType(0)) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u.2
 * JD-Core Version:    0.7.0.1
 */