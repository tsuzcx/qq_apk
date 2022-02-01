package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class i$b$f$1$2
  extends Lambda
  implements Function1<Object, Unit>
{
  i$b$f$1$2(i.b.f.1 param1)
  {
    super(1);
  }
  
  public final void a(@Nullable Object paramObject)
  {
    i.b localb = this.a.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume, StepChecker onError ");
    localStringBuilder.append(paramObject);
    i.b.a(localb, localStringBuilder.toString());
    this.a.b.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.f.1.2
 * JD-Core Version:    0.7.0.1
 */