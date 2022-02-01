package com.tencent.luggage.wxa.lt;

import com.tencent.luggage.wxa.ob.a;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.gw;
import com.tencent.luggage.wxa.qw.hf;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/RouteResponse;", "resp", "call"}, k=3, mv={1, 1, 16})
final class g$e<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  g$e(List paramList, g.c paramc, g.h paramh) {}
  
  @Nullable
  public final gw a(@Nullable gw paramgw)
  {
    Object localObject2 = null;
    com.tencent.luggage.wxa.ro.b localb = null;
    if (paramgw != null)
    {
      localObject1 = paramgw.z;
      if ((localObject1 != null) && (((aa)localObject1).a == 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doCgi succeed, queue.size=");
        ((StringBuilder)localObject1).append(this.a.size());
        ((StringBuilder)localObject1).append(", reason=");
        ((StringBuilder)localObject1).append(this.b);
        o.d("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", ((StringBuilder)localObject1).toString());
        localObject1 = ((Iterable)this.a).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (g.d)((Iterator)localObject1).next();
          this.c.a(((g.d)localObject2).b(), (g.d)localObject2);
        }
        g.a(g.a, 1074, 2, this.a.size());
        g.a(g.a, 1074, 5, 0, 4, null);
        localObject2 = this.c;
        localObject3 = paramgw.z;
        localObject1 = localb;
        if (localObject3 != null)
        {
          localObject3 = ((aa)localObject3).b;
          localObject1 = localb;
          if (localObject3 != null) {
            localObject1 = ((hf)localObject3).a();
          }
        }
        ((g.h)localObject2).a(0, (String)localObject1);
        return paramgw;
      }
    }
    localb = h.b();
    Object localObject3 = a.a.e;
    if (paramgw != null)
    {
      localObject1 = paramgw.z;
      if (localObject1 != null)
      {
        i = ((aa)localObject1).a;
        break label247;
      }
    }
    int i = -9999;
    label247:
    Object localObject1 = localObject2;
    if (paramgw != null)
    {
      Object localObject4 = paramgw.z;
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject4 = ((aa)localObject4).b;
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((hf)localObject4).a();
        }
      }
    }
    localb.a(new a((a.a)localObject3, i, (String)localObject1));
    return paramgw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.g.e
 * JD-Core Version:    0.7.0.1
 */