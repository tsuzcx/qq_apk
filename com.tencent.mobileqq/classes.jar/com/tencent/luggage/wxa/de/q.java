package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.c;
import com.tencent.ilinkservice.ao;
import com.tencent.ilinkservice.as;
import com.tencent.luggage.wxa.ba.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiCloneSessionCgi;", "Lcom/tencent/luggage/login/account/tdi/ITdiCgi;", "tdiCloneSession", "Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "(Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;)V", "getTdiCloneSession", "()Lcom/tencent/ilinkservice/IlinkTdiCloneSessionInterface;", "cancelAppRequest", "", "taskid", "", "destroy", "sendAppRequest", "req", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppRequest;", "setCallback", "tdiCgiCallback", "Lcom/tencent/luggage/login/account/tdi/ITdiCgiCallback;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class q
  implements b
{
  @NotNull
  private final ao a;
  
  public q(@NotNull ao paramao)
  {
    this.a = paramao;
  }
  
  public int a(@NotNull b.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "req");
    return this.a.a(paramc);
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.dg.b localb = (com.tencent.luggage.wxa.dg.b)e.a(com.tencent.luggage.wxa.dg.b.class);
    if (localb == null) {
      localb = com.tencent.luggage.wxa.dg.b.b;
    }
    this.a.a(null);
    localb.a(this.a);
  }
  
  public void a(@NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "tdiCgiCallback");
    this.a.a((as)new q.a(paramc));
  }
  
  @NotNull
  public final ao b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.q
 * JD-Core Version:    0.7.0.1
 */