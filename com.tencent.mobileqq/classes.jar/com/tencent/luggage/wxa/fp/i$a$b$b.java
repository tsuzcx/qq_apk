package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.aw;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckUserStarRecordResponse;", "onTerminate"}, k=3, mv={1, 1, 16})
final class i$a$b$b<T>
  implements e.c<aw>
{
  i$a$b$b(i.a.b.a parama) {}
  
  public final void a(@Nullable aw paramaw)
  {
    if (paramaw != null)
    {
      if (paramaw.z.a != 0)
      {
        o.d("MicroMsg.WxaCollectionStorage", "[syncCollectionStatusToLocal] CGI FAIL");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[syncCollectionStatusToLocal] RESULT: appId=");
      localStringBuilder.append(this.a.a());
      localStringBuilder.append(" status=");
      localStringBuilder.append(paramaw.a);
      localStringBuilder.append("  count=");
      localStringBuilder.append(paramaw.b);
      o.d("MicroMsg.WxaCollectionStorage", localStringBuilder.toString());
      h.a.d().invoke(Integer.valueOf(paramaw.b));
      if (paramaw.a == 1)
      {
        h.a.a().invoke(this.a.b(), Integer.valueOf(this.a.c()));
        return;
      }
      h.a.b().invoke(this.a.b(), Integer.valueOf(this.a.c()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.i.a.b.b
 * JD-Core Version:    0.7.0.1
 */