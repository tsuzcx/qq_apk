package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.ep;
import com.tencent.luggage.wxa.rl.b;
import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSLoginConfirmResponse;", "call"}, k=3, mv={1, 1, 16})
final class i$a$1$a$b<_Ret, _Var>
  implements b<_Ret, _Var>
{
  public static final b a = new b();
  
  @NotNull
  public final Triple<dy, String, String> a(@Nullable ep paramep)
  {
    String str = null;
    dy localdy;
    if (paramep != null) {
      localdy = paramep.a;
    } else {
      localdy = null;
    }
    if (paramep != null) {
      str = paramep.b;
    }
    i.c();
    return new Triple(localdy, str, "/cgi-bin/mmbiz-bin/js-login-confirm");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i.a.1.a.b
 * JD-Core Version:    0.7.0.1
 */