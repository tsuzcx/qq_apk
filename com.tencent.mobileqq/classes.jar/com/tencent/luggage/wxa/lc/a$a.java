package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.ik.a;
import com.tencent.luggage.wxa.ik.a.b;
import com.tencent.luggage.wxa.ik.a.c;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class a$a<T>
  implements e.c
{
  a$a(a.c paramc, a.b paramb, a parama) {}
  
  public final void a(gu paramgu)
  {
    if (paramgu != null)
    {
      try
      {
        this.a.b().a(paramgu.b());
        paramgu = this.b;
        if (paramgu == null) {
          return;
        }
        paramgu.a(0, 0, null, this.c);
        return;
      }
      catch (IOException paramgu)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTerminate uri=");
        localStringBuilder.append(this.a.c());
        localStringBuilder.append(", parse responseProtoBuf get e=");
        localStringBuilder.append(paramgu);
        o.b("Luggage.WXA.FULL.CompatNetSceneDispatcherDefaultAdapter", localStringBuilder.toString());
        paramgu = this.b;
        if (paramgu == null) {
          return;
        }
      }
      paramgu.a(5, 0, null, this.c);
    }
    else
    {
      paramgu = new StringBuilder();
      paramgu.append("onTerminate null response, uri=");
      paramgu.append(this.a.c());
      o.b("Luggage.WXA.FULL.CompatNetSceneDispatcherDefaultAdapter", paramgu.toString());
      paramgu = this.b;
      if (paramgu != null) {
        paramgu.a(4, -1, null, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.a.a
 * JD-Core Version:    0.7.0.1
 */