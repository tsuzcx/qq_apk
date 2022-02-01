package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errCode", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class w$e$1
  extends Lambda
  implements Function2<Integer, String, Unit>
{
  w$e$1(b paramb)
  {
    super(2);
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("userAutoLogin: ");
    localStringBuilder.append(paramInt);
    o.e("Luggage.WxaTdiLoginBoot", localStringBuilder.toString());
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 0) {
          return;
        }
        this.a.a(new Object[] { Boolean.valueOf(true) });
        return;
      }
      i.a.b();
      this.a.a(paramString);
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.e.1
 * JD-Core Version:    0.7.0.1
 */