package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class w$c$1
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  w$c$1(b paramb)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wxa login logic boot: step 1: isSuccess:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    o.d("Luggage.WxaTdiLoginBoot", localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.a(new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.c.1
 * JD-Core Version:    0.7.0.1
 */