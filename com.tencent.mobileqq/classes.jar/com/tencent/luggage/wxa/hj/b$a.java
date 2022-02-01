package com.tencent.luggage.wxa.hj;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "data", "kotlin.jvm.PlatformType", "onCallback", "(Landroid/os/Parcelable;)V"}, k=3, mv={1, 1, 16})
final class b$a<T>
  implements e<ResultType>
{
  b$a(Function1 paramFunction1) {}
  
  public final void a(ResultType paramResultType)
  {
    Function1 localFunction1 = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramResultType, "data");
    localFunction1.invoke(paramResultType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.b.a
 * JD-Core Version:    0.7.0.1
 */