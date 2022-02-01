package com.tencent.luggage.wxa.dc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/TransferActionUtils;", "", "()V", "showAlert", "", "Lcom/tencent/mm/protocal/protobuf/AlertMsgInfo;", "ActionCode", "WxaScene", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class l
{
  public static final l a = new l();
  
  public final void a(@NotNull com.tencent.luggage.wxa.qw.e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "$this$showAlert");
    h localh = (h)com.tencent.luggage.wxa.ba.e.a(h.class);
    if (localh != null)
    {
      localh.a(null, new h.a(parame.a, parame.b));
      return;
    }
    parame = (Unit)((Function0)new l.a(parame)).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.l
 * JD-Core Version:    0.7.0.1
 */