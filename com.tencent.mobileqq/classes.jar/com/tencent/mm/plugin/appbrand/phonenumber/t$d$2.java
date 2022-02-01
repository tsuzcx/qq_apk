package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class t$d$2
  implements Runnable
{
  t$d$2(t.d paramd) {}
  
  public final void run()
  {
    Object localObject2 = aa.a.d(t.a(this.a.a));
    if (localObject2 != null)
    {
      localObject1 = aa.a.d(t.a(this.a.a));
      if (localObject1 != null) {
        localObject1 = Long.valueOf(((z)localObject1).m());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((z)localObject2).n(((Long)localObject1).longValue() + 1L);
    }
    Object localObject1 = this.a.a;
    localObject2 = t.b(this.a.a).getString(2131886804);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…er_send_verify_code_fail)");
    t.b((t)localObject1, (String)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t.d.2
 * JD-Core Version:    0.7.0.1
 */