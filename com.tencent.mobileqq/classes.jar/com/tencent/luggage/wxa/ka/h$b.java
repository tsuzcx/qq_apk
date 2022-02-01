package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.en;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSAuthorizeResponse;", "call"}, k=3, mv={1, 1, 16})
final class h$b<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  h$b(h paramh, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  @Nullable
  public final Pair<dy, String> a(@Nullable en paramen)
  {
    Collection localCollection = null;
    if (paramen != null)
    {
      localObject = paramen.a;
      if (localObject != null)
      {
        localObject = Integer.valueOf(((dy)localObject).a);
        break label29;
      }
    }
    Object localObject = null;
    label29:
    if ((localObject != null) && (((Integer)localObject).intValue() == -12000))
    {
      localObject = com.tencent.luggage.wxa.ro.h.c();
      localCollection = (Collection)paramen.b;
      int i;
      if ((localCollection != null) && (!localCollection.isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        this.b.a(this.c, this.a.b("fail:internal error scope empty"));
        return null;
      }
      f.a.a((Runnable)new h.b.1(this, (com.tencent.luggage.wxa.ro.b)localObject, paramen));
      return null;
    }
    localObject = localCollection;
    if (paramen != null) {
      localObject = paramen.a;
    }
    h.c();
    return new Pair(localObject, "/cgi-bin/mmbiz-bin/js-authorize");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.h.b
 * JD-Core Version:    0.7.0.1
 */