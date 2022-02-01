package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import com.tencent.luggage.wxa.qw.ay;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class t$f$1
  implements Runnable
{
  t$f$1(t.f paramf, ay paramay) {}
  
  public final void run()
  {
    int i = this.b.a;
    int j = h.a.f();
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    if (i == j)
    {
      localObject2 = aa.a.d(t.a(this.a.a));
      if (localObject2 != null)
      {
        localObject3 = aa.a.d(t.a(this.a.a));
        if (localObject3 != null) {
          localObject1 = Long.valueOf(((z)localObject3).o());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject2).p(((Long)localObject1).longValue() + 1L);
      }
      localObject2 = this.b.b;
      localObject3 = this.b.c;
      localObject4 = this.b.d;
      localObject1 = this.b.e;
      if (localObject1 == null) {
        localObject1 = "";
      }
      if (this.a.b)
      {
        new g(t.a(this.a.a), this.a.c, 0).a((Function1)new t.f.1.1(this, (String)localObject4, (String)localObject2, (String)localObject3, (String)localObject1));
        return;
      }
      s locals = s.a;
      String str = this.a.c;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "showMobile");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "encryptedData");
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "iv");
      locals.b(new r(str, (String)localObject4, (String)localObject2, (String)localObject3, (String)localObject1, false, false, false, true, 224, null));
      t.c(this.a.a).invoke();
      return;
    }
    if (i == h.a.g())
    {
      localObject3 = aa.a.d(t.a(this.a.a));
      if (localObject3 != null)
      {
        localObject4 = aa.a.d(t.a(this.a.a));
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = Long.valueOf(((z)localObject4).p());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject3).q(((Long)localObject1).longValue() + 1L);
      }
      localObject1 = this.a.a;
      localObject2 = t.b(this.a.a).getString(2131886805);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…end_verify_code_frequent)");
      t.b((t)localObject1, (String)localObject2);
      return;
    }
    if (i == h.a.h())
    {
      localObject2 = aa.a.d(t.a(this.a.a));
      if (localObject2 != null)
      {
        localObject4 = aa.a.d(t.a(this.a.a));
        localObject1 = localObject3;
        if (localObject4 != null) {
          localObject1 = Long.valueOf(((z)localObject4).p());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject2).q(((Long)localObject1).longValue() + 1L);
      }
      localObject1 = this.a.a;
      localObject2 = t.b(this.a.a).getString(2131886807);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…number_verify_code_error)");
      t.b((t)localObject1, (String)localObject2);
      return;
    }
    localObject2 = aa.a.d(t.a(this.a.a));
    if (localObject2 != null)
    {
      localObject3 = aa.a.d(t.a(this.a.a));
      localObject1 = localObject4;
      if (localObject3 != null) {
        localObject1 = Long.valueOf(((z)localObject3).p());
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((z)localObject2).q(((Long)localObject1).longValue() + 1L);
    }
    localObject1 = this.a.a;
    localObject2 = t.b(this.a.a).getString(2131886810);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…_number_verify_code_fail)");
    t.b((t)localObject1, (String)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t.f.1
 * JD-Core Version:    0.7.0.1
 */