package com.tencent.luggage.wxa.eh;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "activity", "Landroid/app/Activity;", "appId", "", "invoke"}, k=3, mv={1, 1, 16})
final class d$c
  extends Lambda
  implements Function2<Activity, String, Unit>
{
  d$c(d paramd)
  {
    super(2);
  }
  
  public final void a(@NotNull Activity paramActivity, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    this.a.a(paramActivity, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.d.c
 * JD-Core Version:    0.7.0.1
 */