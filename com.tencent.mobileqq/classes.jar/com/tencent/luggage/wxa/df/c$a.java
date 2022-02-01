package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "realResp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "onTerminate"}, k=3, mv={1, 1, 16})
final class c$a<T>
  implements e.c<gu>
{
  c$a(c paramc, e parame) {}
  
  public final void a(@Nullable gu paramgu)
  {
    if (paramgu == null)
    {
      o.b(this.a.a(), "resp is null, return");
      paramgu = this.b;
      if (paramgu != null)
      {
        localObject = new f(0, null, null, 7, null);
        ((f)localObject).a(-1);
        ((f)localObject).a("resp is null, return");
        paramgu.a(localObject);
      }
      return;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      f localf = new f(0, null, null, 7, null);
      localf.a((a)paramgu);
      localf.a(0);
      localf.a("");
      ((e)localObject).a(localf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.c.a
 * JD-Core Version:    0.7.0.1
 */