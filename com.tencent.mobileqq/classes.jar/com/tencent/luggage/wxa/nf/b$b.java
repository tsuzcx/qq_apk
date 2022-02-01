package com.tencent.luggage.wxa.nf;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class b$b
  extends ObservableProperty<Boolean>
{
  public b$b(Object paramObject1, Object paramObject2, b paramb)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    boolean bool = ((Boolean)paramBoolean2).booleanValue();
    ((Boolean)paramBoolean1).booleanValue();
    if ((bool) && (b.d(this.b)))
    {
      b.e(this.b);
      b.f(this.b);
      return;
    }
    b.g(this.b);
    b.h(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.b.b
 * JD-Core Version:    0.7.0.1
 */