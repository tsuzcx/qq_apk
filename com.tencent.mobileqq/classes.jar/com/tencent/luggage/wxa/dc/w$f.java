package com.tencent.luggage.wxa.dc;

import android.os.Looper;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.de.h;
import com.tencent.luggage.wxa.dg.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)Z"}, k=3, mv={1, 1, 16})
final class w$f<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  w$f(com.tencent.luggage.wxa.dg.b paramb) {}
  
  public final boolean a(Boolean paramBoolean)
  {
    paramBoolean = new StringBuilder();
    paramBoolean.append("Wxa login logic boot: step 4: inject report service");
    paramBoolean.append("process:");
    paramBoolean.append(r.c());
    paramBoolean.append(" hasLogin:");
    paramBoolean.append(i.a.g());
    o.d("Luggage.WxaTdiLoginBoot", paramBoolean.toString());
    boolean bool = d.a.g();
    o.d("Luggage.WxaTdiLoginBoot", "hasActivateDevice = [%b]", new Object[] { Boolean.valueOf(bool) });
    if ((r.h()) && (bool))
    {
      paramBoolean = this.a;
      Intrinsics.checkExpressionValueIsNotNull(paramBoolean, "activateDeviceLogic");
      paramBoolean = paramBoolean.f();
      if (paramBoolean == null)
      {
        o.b("Luggage.WxaTdiLoginBoot", "create report service fail! hasActivate = [%b], hasLogin = [%b]", new Object[] { Boolean.valueOf(d.a.g()), Boolean.valueOf(i.a.g()) });
        return true;
      }
      if (1 == h.a.a()) {
        com.tencent.luggage.wxa.qy.a.a.a((com.tencent.luggage.wxa.qy.b)new com.tencent.luggage.wxa.dh.a(paramBoolean), Looper.getMainLooper());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.f
 * JD-Core Version:    0.7.0.1
 */