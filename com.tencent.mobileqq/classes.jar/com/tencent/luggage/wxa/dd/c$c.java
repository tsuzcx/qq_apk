package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/luggage/login/account/SessionInfo;", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class c$c<_Ret, _Var>
  implements b<_Ret, _Var>
{
  c$c(Request paramRequest, g paramg) {}
  
  @NotNull
  public final g a(Void paramVoid)
  {
    com.tencent.luggage.wxa.dc.g.get().newCall(this.a).enqueue((Callback)new c.c.1(this, h.c()));
    return new g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.c.c
 * JD-Core Version:    0.7.0.1
 */