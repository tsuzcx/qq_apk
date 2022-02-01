package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.dc.w;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "TRAN_REQ", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "TRAN_RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "isSuccess", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class j$d
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  j$d(j paramj, Function2 paramFunction2)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    if (paramBoolean)
    {
      o.d(this.a.f(), "boot iLinkAutoLogin success");
      w.a.a((Function2)new j.d.1(this));
      return;
    }
    ??? = this.a.f();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("boot iLinkAutoLogin fail: ");
    ((StringBuilder)localObject2).append(paramString);
    o.b((String)???, ((StringBuilder)localObject2).toString());
    synchronized (j.a(this.a))
    {
      localObject2 = this.b;
      if (localObject2 != null) {
        paramString = (Unit)((Function2)localObject2).invoke(Boolean.valueOf(false), paramString);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.d
 * JD-Core Version:    0.7.0.1
 */