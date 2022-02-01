package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "TRAN_REQ", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "TRAN_RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "isSuccess", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class j$d$1
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  j$d$1(j.d paramd)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    if (paramBoolean)
    {
      o.d(this.a.a.f(), "boot userAutoLogin success");
      paramString = this.a.b;
      if (paramString != null) {
        paramString = (Unit)paramString.invoke(Boolean.valueOf(true), "");
      }
    }
    else
    {
      Object localObject = this.a.a.f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("boot userAutoLogin fail: ");
      localStringBuilder.append(paramString);
      o.b((String)localObject, localStringBuilder.toString());
      localObject = this.a.b;
      if (localObject != null) {
        paramString = (Unit)((Function2)localObject).invoke(Boolean.valueOf(false), paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j.d.1
 * JD-Core Version:    0.7.0.1
 */