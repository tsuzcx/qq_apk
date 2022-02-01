package com.tencent.luggage.wxa.lc;

import android.app.Application;
import android.content.Context;
import com.tencent.luggage.wxa.ih.c;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.ih.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.msgsubscription.ui.a;
import com.tencent.mm.msgsubscription.ui.a.a.a;
import com.tencent.mm.msgsubscription.ui.a.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class b$d
  implements Runnable
{
  b$d(b paramb, c paramc, Context paramContext, List paramList, Map paramMap, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    Object localObject1 = (Function3)new b.d.a(this);
    Object localObject2 = this.c;
    if ((localObject2 instanceof Application))
    {
      ((Function3)localObject1).invoke(Integer.valueOf(2), this.d, Boolean.valueOf(false));
      o.c("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
      return;
    }
    this.a.a(new a((Context)localObject2, this.d, (a.d)new b.d.1(this, (Function3)localObject1), this.f));
    if (this.g == 3) {
      if (this.f)
      {
        this.a.c().j(((d)this.b.c().get(0)).a());
      }
      else
      {
        localObject1 = this.a.c();
        localObject2 = this.b.d();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((a)localObject1).j(((e)localObject2).i());
      }
    }
    if (this.g == 2)
    {
      localObject1 = this.a.c();
      localObject2 = this.b.d();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((a)localObject1).g(((e)localObject2).g());
    }
    else if (this.f)
    {
      localObject1 = this.a.c();
      localObject2 = new StringBuilder();
      e locale = this.b.d();
      if (locale == null) {
        Intrinsics.throwNpe();
      }
      ((StringBuilder)localObject2).append(locale.h());
      ((StringBuilder)localObject2).append(((d)this.b.c().get(0)).b());
      ((a)localObject1).g(((StringBuilder)localObject2).toString());
    }
    else
    {
      localObject1 = this.a.c();
      localObject2 = this.b.d();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((a)localObject1).g(((e)localObject2).j());
    }
    this.a.c().b(this.b.b());
    localObject2 = this.a.c();
    localObject1 = this.b.d();
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).e();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    ((a)localObject2).c((String)localObject1);
    this.a.c().a(this.b.a());
    localObject1 = this.a.c();
    localObject2 = this.b.d();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((a)localObject1).f(((e)localObject2).a());
    localObject1 = this.a.c();
    localObject2 = this.b.d();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((a)localObject1).h(((e)localObject2).b());
    localObject1 = this.a.c();
    localObject2 = this.b.d();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    ((a)localObject1).i(((e)localObject2).c());
    this.a.c().b(2130842125);
    if (this.g == 2)
    {
      localObject1 = this.a.c();
      localObject2 = this.b.d();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((a)localObject1).d(((e)localObject2).d());
    }
    else
    {
      localObject1 = this.a.c();
      localObject2 = this.b.d();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((a)localObject1).e(((e)localObject2).f());
    }
    this.a.c().a((a.a.a)new b.d.2(this));
    localObject1 = this.a.b();
    if (localObject1 != null) {
      ((b.c)localObject1).a((i)this.a.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.b.d
 * JD-Core Version:    0.7.0.1
 */