package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.et;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "response", "call"}, k=3, mv={1, 1, 16})
final class j$c<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  j$c(j paramj, com.tencent.luggage.wxa.iu.b paramb, int paramInt, j.b paramb1) {}
  
  @Nullable
  public final et a(@Nullable et paramet)
  {
    if (paramet != null)
    {
      localObject = paramet.a;
      if (localObject != null)
      {
        localObject = Integer.valueOf(((dy)localObject).a);
        break label26;
      }
    }
    Object localObject = null;
    label26:
    if (localObject == null) {
      return paramet;
    }
    if (((Integer)localObject).intValue() == -12000)
    {
      localObject = h.c();
      f.a.a((Runnable)new j.c.1(this, (com.tencent.luggage.wxa.ro.b)localObject, paramet));
      return null;
    }
    return paramet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.j.c
 * JD-Core Version:    0.7.0.1
 */