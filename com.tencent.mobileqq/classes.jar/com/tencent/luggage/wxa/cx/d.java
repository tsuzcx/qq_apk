package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.fa;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.lc;
import com.tencent.luggage.wxa.qw.ly;
import com.tencent.luggage.wxa.qw.mp;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/CgiLaunchWxaAppForWarmLaunch;", "Lcom/tencent/luggage/launch/CgiLaunchWxaApp;", "rt", "Lcom/tencent/luggage/standalone_ext/Runtime;", "(Lcom/tencent/luggage/standalone_ext/Runtime;)V", "getRt", "()Lcom/tencent/luggage/standalone_ext/Runtime;", "Utils", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class d
  extends c
{
  public static final d.a a = new d.a(null);
  @NotNull
  private final com.tencent.luggage.wxa.em.d b;
  
  public d(@NotNull com.tencent.luggage.wxa.em.d paramd)
  {
    this.b = paramd;
    paramd = this.b.G().h;
    if (paramd == null) {
      Intrinsics.throwNpe();
    }
    paramd = com.tencent.luggage.wxa.nm.a.a(paramd);
    Object localObject1 = this.b.G().h;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    mp localmp = com.tencent.luggage.wxa.nm.a.b((j)localObject1);
    Object localObject2 = new lc();
    ((lc)localObject2).a = this.b.ab();
    ((lc)localObject2).b = this.b.b();
    ((lc)localObject2).c = this.b.l().c;
    ((lc)localObject2).f = this.b.l().a;
    ((lc)localObject2).d = this.b.G().I;
    ((lc)localObject2).e = 1;
    a(this.b.aa());
    localObject1 = new fa();
    ((fa)localObject1).a = this.b.aa();
    ((fa)localObject1).b = ((lc)localObject2);
    ((fa)localObject1).c = 2;
    localObject2 = new ly();
    n localn = this.b.K();
    int i;
    if (localn != null) {
      i = localn.c();
    } else {
      i = 0;
    }
    ((ly)localObject2).a = i;
    ((fa)localObject1).e = ((ly)localObject2);
    ((fa)localObject1).f = paramd;
    ((fa)localObject1).g = localmp;
    ((fa)localObject1).i = -1;
    paramd = this.b.G();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "rt.initConfig");
    ((fa)localObject1).j = paramd.i();
    ((fa)localObject1).k = this.b.G().b;
    ((fa)localObject1).l = false;
    ((fa)localObject1).m = false;
    a((gt)localObject1);
    a((b)this.b.d(b.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.d
 * JD-Core Version:    0.7.0.1
 */