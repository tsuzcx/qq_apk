package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class i$b<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  i$b(i parami, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  public final void a(Triple<? extends dy, String, String> paramTriple)
  {
    Object localObject2 = (dy)paramTriple.component1();
    Object localObject3 = (String)paramTriple.component2();
    Object localObject1 = (String)paramTriple.component3();
    if (localObject2 != null) {
      paramTriple = Integer.valueOf(((dy)localObject2).a);
    } else {
      paramTriple = null;
    }
    if ((paramTriple != null) && (paramTriple.intValue() == 0))
    {
      paramTriple = this.b;
      i = this.c;
      localObject1 = this.a;
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("code", localObject3);
      paramTriple.a(i, ((i)localObject1).a("ok", (Map)localObject2));
      return;
    }
    if ((paramTriple != null) && (paramTriple.intValue() == -12006))
    {
      this.b.a(this.c, this.a.b("fail:auth denied"));
      return;
    }
    if (paramTriple == null)
    {
      paramTriple = this.b;
      i = this.c;
      localObject2 = this.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("fail invalid ");
      ((StringBuilder)localObject3).append(i.a(this.a, (String)localObject1));
      ((StringBuilder)localObject3).append(" response");
      paramTriple.a(i, ((i)localObject2).b(((StringBuilder)localObject3).toString()));
      return;
    }
    localObject3 = this.b;
    int i = this.c;
    i locali = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail ");
    localStringBuilder.append(i.a(this.a, (String)localObject1));
    localStringBuilder.append(" response errcode=");
    localStringBuilder.append(paramTriple);
    localStringBuilder.append(" errmsg=");
    localStringBuilder.append(((dy)localObject2).b);
    ((com.tencent.luggage.wxa.iu.b)localObject3).a(i, locali.b(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i.b
 * JD-Core Version:    0.7.0.1
 */