package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.er;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Triple;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/Triple;", "Lcom/tencent/mm/protocal/protobuf/JSAPIBaseResponse;", "", "response", "Lcom/tencent/mm/protocal/protobuf/JSLoginResponse;", "call"}, k=3, mv={1, 1, 16})
final class i$a<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  i$a(i parami, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  @Nullable
  public final Triple<dy, String, String> a(@Nullable er paramer)
  {
    Object localObject2 = null;
    if (paramer != null)
    {
      localObject1 = paramer.a;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((dy)localObject1).a);
        break label29;
      }
    }
    Object localObject1 = null;
    label29:
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == -12000))
    {
      localObject1 = h.c();
      localObject2 = (Collection)paramer.c;
      int i;
      if ((localObject2 != null) && (!((Collection)localObject2).isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        this.b.a(this.c, this.a.b("fail:internal error scope empty"));
        return null;
      }
      f.a.a((Runnable)new i.a.1(this, (com.tencent.luggage.wxa.ro.b)localObject1, paramer));
      return null;
    }
    if (paramer != null) {
      localObject1 = paramer.a;
    } else {
      localObject1 = null;
    }
    if (paramer != null) {
      localObject2 = paramer.b;
    }
    i.c();
    return new Triple(localObject1, localObject2, "/cgi-bin/mmbiz-bin/js-login");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i.a
 * JD-Core Version:    0.7.0.1
 */