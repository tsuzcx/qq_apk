package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import com.tencent.luggage.wxa.qw.hv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class t$d$1
  implements Runnable
{
  t$d$1(t.d paramd, hv paramhv) {}
  
  public final void run()
  {
    int i = this.b.a;
    int j = h.a.c();
    Object localObject2 = null;
    z localz1 = null;
    z localz2 = null;
    Object localObject1 = null;
    if (i == j)
    {
      localObject2 = aa.a.d(t.a(this.a.a));
      if (localObject2 != null)
      {
        localz1 = aa.a.d(t.a(this.a.a));
        if (localz1 != null) {
          localObject1 = Long.valueOf(localz1.l());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject2).m(((Long)localObject1).longValue() + 1L);
      }
    }
    else
    {
      if (i == h.a.d())
      {
        localz1 = aa.a.d(t.a(this.a.a));
        if (localz1 != null)
        {
          localz2 = aa.a.d(t.a(this.a.a));
          localObject1 = localObject2;
          if (localz2 != null) {
            localObject1 = Long.valueOf(localz2.m());
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localz1.n(((Long)localObject1).longValue() + 1L);
        }
        localObject1 = this.a.a;
        localObject2 = t.b(this.a.a).getString(2131886804);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…er_send_verify_code_fail)");
        t.b((t)localObject1, (String)localObject2);
        return;
      }
      if (i == h.a.e())
      {
        localObject2 = aa.a.d(t.a(this.a.a));
        if (localObject2 != null)
        {
          localz2 = aa.a.d(t.a(this.a.a));
          localObject1 = localz1;
          if (localz2 != null) {
            localObject1 = Long.valueOf(localz2.m());
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((z)localObject2).n(((Long)localObject1).longValue() + 1L);
        }
        localObject1 = this.a.a;
        localObject2 = t.b(this.a.a).getString(2131886805);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…end_verify_code_frequent)");
        t.b((t)localObject1, (String)localObject2);
        return;
      }
      localObject2 = aa.a.d(t.a(this.a.a));
      if (localObject2 != null)
      {
        localz1 = aa.a.d(t.a(this.a.a));
        localObject1 = localz2;
        if (localz1 != null) {
          localObject1 = Long.valueOf(localz1.m());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject2).n(((Long)localObject1).longValue() + 1L);
      }
      localObject1 = this.a.a;
      localObject2 = t.b(this.a.a).getString(2131886804);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…er_send_verify_code_fail)");
      t.b((t)localObject1, (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t.d.1
 * JD-Core Version:    0.7.0.1
 */