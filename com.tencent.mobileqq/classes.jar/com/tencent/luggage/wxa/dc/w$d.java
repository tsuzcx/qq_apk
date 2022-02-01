package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rl.b;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "activateDeviceSuccess", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)V"}, k=3, mv={1, 1, 16})
final class w$d<_Ret, _Var>
  implements b<_Ret, _Var>
{
  public static final d a = new d();
  
  public final void a(Boolean paramBoolean)
  {
    if (r.h())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wxa login logic boot: step 2: checkTokenByCgi & activateDeviceSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" process:");
      localStringBuilder.append(r.c());
      o.d("Luggage.WxaTdiLoginBoot", localStringBuilder.toString());
      w.a(w.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.d
 * JD-Core Version:    0.7.0.1
 */