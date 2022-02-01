package com.tencent.luggage.wxa.jx;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ba.b;
import com.tencent.luggage.wxa.bb.a.a;
import com.tencent.luggage.wxa.qz.o;

class d$1
  implements a.a
{
  d$1(d paramd) {}
  
  public <T extends b> void a(Class<T> paramClass, T paramT)
  {
    if ((paramClass != null) && (paramT != null))
    {
      d.a(this.a).a(paramClass, paramT);
      return;
    }
    o.c("MicroMsg.AppBrandComponentImpl", "registerCustomize failed, clazz(%s) or customize(%s) is null.", new Object[] { paramClass, paramT });
  }
  
  public <T extends com.tencent.luggage.wxa.ba.d> void a(@NonNull Class<T> paramClass, @NonNull T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.d.1
 * JD-Core Version:    0.7.0.1
 */