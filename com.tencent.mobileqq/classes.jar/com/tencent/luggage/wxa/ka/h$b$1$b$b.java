package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.el;
import com.tencent.luggage.wxa.rl.b;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeConfirmResponse;", "call"}, k=3, mv={1, 1, 16})
final class h$b$1$b$b<_Ret, _Var>
  implements b<_Ret, _Var>
{
  public static final b a = new b();
  
  @NotNull
  public final Pair<dy, String> a(@Nullable el paramel)
  {
    if (paramel != null) {
      paramel = paramel.a;
    } else {
      paramel = null;
    }
    h.c();
    return new Pair(paramel, "/cgi-bin/mmbiz-bin/js-authorize-confirm");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.h.b.1.b.b
 * JD-Core Version:    0.7.0.1
 */