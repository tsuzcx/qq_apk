package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qw.bd;
import com.tencent.luggage.wxa.qw.dq;
import com.tencent.luggage.wxa.qw.nj;
import com.tencent.luggage.wxa.qy.a;
import com.tencent.luggage.wxa.qy.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class u$a
  implements Runnable
{
  u$a(String paramString1, String paramString2) {}
  
  public final void run()
  {
    try
    {
      Object localObject1 = e.a(this.a, this.b);
      if (localObject1 != null)
      {
        localObject2 = ((nj)localObject1).a;
        if (localObject2 != null) {
          u.b.a((bd)localObject2);
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((nj)localObject1).b;
        if (localObject1 != null) {
          u.b.a((dq)localObject1);
        }
      }
      a.a.a((b)new g());
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("obtainWxaRuntimeHostAttr() async update failed ");
      ((StringBuilder)localObject2).append(localException);
      o.b("WxaRuntimeHostAttr", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.u.a
 * JD-Core Version:    0.7.0.1
 */