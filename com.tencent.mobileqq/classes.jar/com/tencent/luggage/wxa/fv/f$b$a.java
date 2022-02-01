package com.tencent.luggage.wxa.fv;

import com.tencent.ilink.tdi.b.u;
import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/ilinkservice/IlinkTdiSessionInterface;", "invoke", "com/tencent/luggage/wxaapi/internal/tdi/LoginByWechatOpenSDKOauth$login$1$2$1"}, k=3, mv={1, 1, 16})
final class f$b$a
  extends Lambda
  implements Function1<aq, Unit>
{
  f$b$a(b.u paramu, f.b paramb)
  {
    super(1);
  }
  
  public final void a(@NotNull aq paramaq)
  {
    Intrinsics.checkParameterIsNotNull(paramaq, "it");
    o.d(f.a(this.b.a), "login() before invoke TdiApiProto.thirdAppLogin()");
    paramaq.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.f.b.a
 * JD-Core Version:    0.7.0.1
 */