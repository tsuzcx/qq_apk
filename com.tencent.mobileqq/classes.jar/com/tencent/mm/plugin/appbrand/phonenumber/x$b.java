package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.qw.it;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"}, k=3, mv={1, 1, 16})
final class x$b
  extends Lambda
  implements Function1<it, Unit>
{
  x$b(x paramx)
  {
    super(1);
  }
  
  public final void a(@Nullable it paramit)
  {
    boolean bool = true;
    if (paramit == null) {
      bool = false;
    }
    o.d("MicroMsg.PhoneNumberManagerUI", "update %b", new Object[] { Boolean.valueOf(bool) });
    z localz2 = null;
    z localz1 = null;
    z localz3;
    if (paramit != null)
    {
      localz2 = aa.a.d(x.a(this.a));
      if (localz2 != null)
      {
        localz3 = aa.a.d(x.a(this.a));
        paramit = localz1;
        if (localz3 != null) {
          paramit = Long.valueOf(localz3.u());
        }
        if (paramit == null) {
          Intrinsics.throwNpe();
        }
        localz2.v(paramit.longValue() + 1L);
      }
    }
    else
    {
      localz1 = aa.a.d(x.a(this.a));
      if (localz1 != null)
      {
        localz3 = aa.a.d(x.a(this.a));
        paramit = localz2;
        if (localz3 != null) {
          paramit = Long.valueOf(localz3.v());
        }
        if (paramit == null) {
          Intrinsics.throwNpe();
        }
        localz1.w(paramit.longValue() + 1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.x.b
 * JD-Core Version:    0.7.0.1
 */