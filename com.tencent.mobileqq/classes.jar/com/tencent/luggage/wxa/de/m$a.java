package com.tencent.luggage.wxa.de;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class m$a
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  m$a(m paramm, Function2 paramFunction2)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    if (paramBoolean)
    {
      o.d(this.a.b(), "boot iLinkAutoLogin success");
      paramString = this.b;
      if (paramString != null) {
        paramString = (Unit)paramString.invoke(Boolean.valueOf(true), "");
      }
    }
    else
    {
      Object localObject = this.a.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("boot iLinkAutoLogin fail: ");
      localStringBuilder.append(paramString);
      o.b((String)localObject, localStringBuilder.toString());
      localObject = this.b;
      if (localObject != null) {
        paramString = (Unit)((Function2)localObject).invoke(Boolean.valueOf(false), paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.m.a
 * JD-Core Version:    0.7.0.1
 */