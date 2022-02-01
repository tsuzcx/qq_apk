package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.utils.V8ObjectUtils;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;

class u$1
  implements JavaCallback
{
  u$1(u paramu, n paramn) {}
  
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    int j = paramV8Array.length();
    int i = 0;
    if ((j >= 1) && (paramV8Array.getType(0) == 7))
    {
      V8Function localV8Function = (V8Function)paramV8Array.getObject(0);
      if (paramV8Array.length() > 1) {
        if (paramV8Array.getType(1) == 1)
        {
          i = paramV8Array.getInteger(1);
        }
        else if (paramV8Array.getType(1) == 2)
        {
          i = (int)paramV8Array.getDouble(1);
        }
        else if (paramV8Array.getType(1) == 4)
        {
          i = u.a(paramV8Array.getString(1), -2147483648);
          if (i == -2147483648) {
            return null;
          }
        }
        else
        {
          o.c("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters[1] type:%d", new Object[] { Integer.valueOf(paramV8Array.getType(1)) });
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
      return Integer.valueOf(u.a(this.b, this.a, localV8Function, i, paramV8Object));
    }
    o.c("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters invalid length:%d type[0]:%d", new Object[] { Integer.valueOf(paramV8Array.length()), Integer.valueOf(paramV8Array.getType(0)) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u.1
 * JD-Core Version:    0.7.0.1
 */