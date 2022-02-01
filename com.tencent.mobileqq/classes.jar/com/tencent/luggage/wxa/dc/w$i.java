package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "bool", "", "str", "", "invoke"}, k=3, mv={1, 1, 16})
final class w$i
  extends Lambda
  implements Function2<Boolean, String, Unit>
{
  public static final i a = new i();
  
  w$i()
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "str");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invoke pending waitForUserLoginDone, bool:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", str:");
    localStringBuilder.append(paramString);
    o.d("Luggage.WxaTdiLoginBoot", localStringBuilder.toString());
    while (!w.i(w.a).isEmpty()) {
      ((Function2)w.i(w.a).poll()).invoke(Boolean.valueOf(paramBoolean), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w.i
 * JD-Core Version:    0.7.0.1
 */