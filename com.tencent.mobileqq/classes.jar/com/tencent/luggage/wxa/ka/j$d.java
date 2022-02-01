package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.et;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "call"}, k=3, mv={1, 1, 16})
final class j$d<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  j$d(j paramj, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  public final void a(@Nullable et paramet)
  {
    if (paramet != null)
    {
      localObject1 = paramet.a;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((dy)localObject1).a);
        break label26;
      }
    }
    Object localObject1 = null;
    label26:
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 0))
    {
      paramet = paramet.b;
      if (paramet != null)
      {
        paramet = paramet.d();
        if (paramet != null)
        {
          localObject1 = this.b;
          i = this.c;
          localObject2 = this.a;
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("data", paramet);
          ((com.tencent.luggage.wxa.iu.b)localObject1).a(i, ((j)localObject2).a("ok", (Map)localObject3));
          return;
        }
      }
      paramet = (Unit)((Function0)new j.d.1(this)).invoke();
      return;
    }
    if (localObject1 == null)
    {
      this.b.a(this.c, this.a.b("fail invalid response"));
      return;
    }
    Object localObject2 = this.b;
    int i = this.c;
    Object localObject3 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramet.a.b);
    ((com.tencent.luggage.wxa.iu.b)localObject2).a(i, ((j)localObject3).a(localStringBuilder.toString(), (Map)MapsKt.hashMapOf(new Pair[] { TuplesKt.to("err_code", localObject1) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.d
 * JD-Core Version:    0.7.0.1
 */