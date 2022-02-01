package com.tencent.mm.plugin.appbrand.phonenumber;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog$Listener;", "onMsg", "", "resultCode", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class w$1
  implements a.b
{
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        this.a.p().invoke();
        return;
      }
      this.a.o().invoke();
      return;
    }
    this.a.n().invoke();
    Object localObject1 = w.a(this.a);
    if (localObject1 != null) {
      localObject1 = ((q)localObject1).b();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (r)((Iterator)localObject2).next();
      if (((r)localObject1).j())
      {
        localObject2 = this.a.t();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "phoneItem");
        ((Function1)localObject2).invoke(localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w.1
 * JD-Core Version:    0.7.0.1
 */