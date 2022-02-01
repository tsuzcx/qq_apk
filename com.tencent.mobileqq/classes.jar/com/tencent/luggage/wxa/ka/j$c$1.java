package com.tencent.luggage.wxa.ka;

import android.content.Context;
import com.tencent.luggage.wxa.ee.a;
import com.tencent.luggage.wxa.ee.a.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.oo.c.d;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.qw.et;
import com.tencent.luggage.wxa.qw.hn;
import com.tencent.mm.plugin.appbrand.widget.dialog.f;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class j$c$1
  implements Runnable
{
  j$c$1(j.c paramc, com.tencent.luggage.wxa.ro.b paramb, et paramet) {}
  
  public final void run()
  {
    if (!this.a.b.d())
    {
      this.b.a(f.b.a);
      return;
    }
    Object localObject2 = new j.c.1.c(this);
    Context localContext = this.a.a.a((h)this.a.b);
    Object localObject1 = this.a.b.q();
    if (localObject1 != null)
    {
      localObject1 = ((d)localObject1).W();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = (com.tencent.luggage.wxa.oq.c)new n();
    }
    localObject2 = new f(localContext, (com.tencent.luggage.wxa.oq.c)localObject1, (c.d)localObject2);
    ((f)localObject2).a(this.c.d);
    ((f)localObject2).b(this.c.c.b);
    ((f)localObject2).d(this.c.j);
    ((f)localObject2).f(this.c.h);
    ((f)localObject2).g(this.c.i);
    ((f)localObject2).e(this.c.e);
    ((f)localObject2).h("");
    localObject1 = this.a.b.y();
    if ((localObject1 != null) && (((com.tencent.luggage.wxa.oq.c)localObject1).f() == true)) {
      ((f)localObject2).b(1);
    } else {
      ((f)localObject2).b(2);
    }
    if (Intrinsics.areEqual("scope.userInfo", this.c.c.a))
    {
      localObject1 = (a)this.a.b.a(a.class);
      if (localObject1 == null) {
        localObject1 = (a)new j.c.1.a(this);
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "service.customize(IWecha…                        }");
      this.a.a.a(this.a.a.a((h)this.a.b), null, ((a)localObject1).a(), "scope.userInfo", (com.tencent.luggage.wxa.oo.c)localObject2);
      ((a)localObject1).a((a.b)new j.c.1.b((a)localObject1, (f)localObject2, this));
    }
    else
    {
      localObject1 = this.c.c.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "response.Scope.Scope");
      ((f)localObject2).i((String)localObject1);
    }
    this.a.a.a((h)this.a.b, (i)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.c.1
 * JD-Core Version:    0.7.0.1
 */