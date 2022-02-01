package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.qw.id;
import com.tencent.luggage.wxa.qw.ie;
import com.tencent.luggage.wxa.qw.iv;
import com.tencent.luggage.wxa.qw.ld;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "onTerminate"}, k=3, mv={1, 1, 16})
final class a$a<T>
  implements e.c<iv>
{
  a$a(ie paramie) {}
  
  public final void a(@Nullable iv paramiv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("run op[");
    localStringBuilder.append(this.a.a.a);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.a.a.b);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.a.e);
    localStringBuilder.append("], get resp:");
    if (paramiv != null)
    {
      ld localld = paramiv.a;
      if (localld != null)
      {
        i = localld.a;
        break label104;
      }
    }
    int i = -1;
    label104:
    localStringBuilder.append(i);
    o.d("Luggage.CgiModCollection", localStringBuilder.toString());
    if (paramiv != null)
    {
      paramiv = paramiv.a;
      if (paramiv != null)
      {
        paramiv = Integer.valueOf(paramiv.a);
        break label145;
      }
    }
    paramiv = null;
    label145:
    if ((paramiv != null) && (paramiv.intValue() == 0)) {
      return;
    }
    if (paramiv == null) {
      return;
    }
    paramiv.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.a.a
 * JD-Core Version:    0.7.0.1
 */