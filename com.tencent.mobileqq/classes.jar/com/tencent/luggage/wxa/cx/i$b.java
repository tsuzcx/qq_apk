package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.nl.b.a;
import com.tencent.luggage.wxa.nl.i.a;
import com.tencent.luggage.wxa.nl.i.a.a;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.page.s.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class i$b
  implements Runnable
{
  i$b(i parami, String paramString, Ref.ObjectRef paramObjectRef, int paramInt, List paramList, Map paramMap, af paramaf, AtomicBoolean paramAtomicBoolean, long paramLong, com.tencent.luggage.wxa.ro.b paramb, boolean paramBoolean1, n paramn, boolean paramBoolean2) {}
  
  public final void run()
  {
    com.tencent.luggage.wxa.nl.b localb = com.tencent.luggage.wxa.nl.b.a;
    String str = this.b;
    Intrinsics.checkExpressionValueIsNotNull(str, "appId");
    int n = ((s.f)this.c.element).a;
    int i1 = this.d;
    List localList = this.e;
    Map localMap = this.f;
    Function1 localFunction11 = (Function1)new i.b.1(this);
    Function1 localFunction12 = (Function1)i.b.2.a;
    Function2 localFunction2 = (Function2)new i.b.3(this);
    if ((!this.k) && (i.a.a.a(this.m)))
    {
      n localn = this.l;
      if ((localn != null) && (s.a.a(localn) == true))
      {
        bool = false;
        break label136;
      }
    }
    boolean bool = true;
    label136:
    localb.a(str, n, i1, localList, localMap, localFunction11, localFunction12, localFunction2, bool, (b.a)new i.b.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.i.b
 * JD-Core Version:    0.7.0.1
 */