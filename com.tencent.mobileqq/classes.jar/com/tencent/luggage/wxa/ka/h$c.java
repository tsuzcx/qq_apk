package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class h$c<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  h$c(h paramh, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  public final void a(Pair<? extends dy, String> paramPair)
  {
    Object localObject1 = (dy)paramPair.component1();
    String str = (String)paramPair.component2();
    if (localObject1 != null) {
      paramPair = Integer.valueOf(((dy)localObject1).a);
    } else {
      paramPair = null;
    }
    if ((paramPair != null) && (paramPair.intValue() == 0))
    {
      this.b.a(this.c, this.a.b("ok"));
      return;
    }
    if ((paramPair != null) && (paramPair.intValue() == -12006))
    {
      this.b.a(this.c, this.a.b("fail:auth denied"));
      return;
    }
    if (paramPair == null)
    {
      paramPair = this.b;
      i = this.c;
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fail invalid ");
      ((StringBuilder)localObject2).append(h.a(this.a, str));
      ((StringBuilder)localObject2).append(" response");
      paramPair.a(i, ((h)localObject1).b(((StringBuilder)localObject2).toString()));
      return;
    }
    Object localObject2 = this.b;
    int i = this.c;
    h localh = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail ");
    localStringBuilder.append(h.a(this.a, str));
    localStringBuilder.append(" response errcode=");
    localStringBuilder.append(paramPair);
    localStringBuilder.append(" errmsg=");
    localStringBuilder.append(((dy)localObject1).b);
    ((com.tencent.luggage.wxa.iu.b)localObject2).a(i, localh.b(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.h.c
 * JD-Core Version:    0.7.0.1
 */