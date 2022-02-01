package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.ng;
import com.tencent.luggage.wxa.qw.nh;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invokeArgs", "", "call"}, k=3, mv={1, 1, 16})
final class i$b$d<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  i$b$d(i.b paramb) {}
  
  @Nullable
  public final Void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "invokeArgs");
    Object localObject1 = i.b.b(this.a).a.a(com.tencent.luggage.wxa.ob.b.class);
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = (com.tencent.luggage.wxa.ob.b)localObject1;
    Object localObject2 = i.b.b(this.a).a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "request.env");
    localObject2 = ((a.a)localObject2).a();
    ng localng = new ng();
    localng.a = i.b.b(this.a).b;
    localng.b = i.a.a(paramString);
    localng.c = i.b.b(this.a).e;
    h.a((e)((com.tencent.luggage.wxa.ob.b)localObject1).b("/cgi-bin/mmbiz-bin/wxaruntime/getdeeplinkticket", (String)localObject2, (a)localng, nh.class));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.d
 * JD-Core Version:    0.7.0.1
 */