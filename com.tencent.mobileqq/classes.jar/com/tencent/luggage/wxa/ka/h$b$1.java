package com.tencent.luggage.wxa.ka;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ee.a;
import com.tencent.luggage.wxa.ee.a.a;
import com.tencent.luggage.wxa.ee.a.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.on.m;
import com.tencent.luggage.wxa.oo.c.d;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.qw.en;
import com.tencent.luggage.wxa.qw.hn;
import com.tencent.mm.plugin.appbrand.widget.dialog.f;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class h$b$1
  implements Runnable
{
  h$b$1(h.b paramb, com.tencent.luggage.wxa.ro.b paramb1, en paramen) {}
  
  public final void run()
  {
    if (!this.a.b.d())
    {
      this.b.a(f.b.a);
      return;
    }
    Object localObject2 = new h.b.1.b(this);
    Object localObject1 = this.c.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "response.ScopeList");
    hn localhn = (hn)((LinkedList)localObject1).getFirst();
    localObject1 = localhn.a;
    Object localObject3 = this.a.b.q();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "service.runtime");
    boolean bool = m.a((String)localObject1, ((d)localObject3).A());
    if ((bool) && (TextUtils.isEmpty((CharSequence)m.a(localhn.a, this.a.b.q()))))
    {
      this.b.a(new f.a("fail:require permission desc"));
      return;
    }
    localObject3 = this.a.a.a((com.tencent.luggage.wxa.jx.h)this.a.b);
    localObject1 = this.a.b.q();
    if (localObject1 != null)
    {
      localObject1 = ((d)localObject1).W();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = (com.tencent.luggage.wxa.oq.c)new n();
    }
    localObject1 = new f((Context)localObject3, (com.tencent.luggage.wxa.oq.c)localObject1, (c.d)localObject2);
    ((f)localObject1).a(this.c.c);
    ((f)localObject1).b(localhn.b);
    ((f)localObject1).d(this.c.g);
    ((f)localObject1).f(this.c.e);
    ((f)localObject1).g(this.c.f);
    ((f)localObject1).e(this.c.d);
    localObject2 = this.a.b.y();
    if ((localObject2 != null) && (((com.tencent.luggage.wxa.oq.c)localObject2).f() == true)) {
      ((f)localObject1).b(1);
    }
    if (Intrinsics.areEqual("scope.userInfo", localhn.a))
    {
      localObject2 = a.a.a((com.tencent.luggage.wxa.jx.c)this.a.b);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "IWechatUserInfoProvider.….notNullProvider(service)");
      this.a.a.a(this.a.a.a((com.tencent.luggage.wxa.jx.h)this.a.b), null, ((a)localObject2).a(), "scope.userInfo", (com.tencent.luggage.wxa.oo.c)localObject1);
      ((a)localObject2).a((a.b)new h.b.1.a((a)localObject2, (f)localObject1, this, localhn, bool));
    }
    else
    {
      localObject2 = localhn.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "scopeInfo.Scope");
      ((f)localObject1).i((String)localObject2);
    }
    if (bool) {
      ((f)localObject1).c(m.a(localhn.a, this.a.b.q()));
    }
    this.a.a.a((com.tencent.luggage.wxa.jx.h)this.a.b, (i)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.h.b.1
 * JD-Core Version:    0.7.0.1
 */