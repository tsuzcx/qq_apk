package com.tencent.mobileqq.apollo.screenshot;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ApolloFrameEncoder$$special$$inlined$observable$1
  extends ObservableProperty<Integer>
{
  public ApolloFrameEncoder$$special$$inlined$observable$1(Object paramObject1, Object paramObject2, ApolloFrameEncoder paramApolloFrameEncoder)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, Integer paramInteger1, Integer paramInteger2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    int i = ((Number)paramInteger2).intValue();
    ((Number)paramInteger1).intValue();
    if (i == 0) {
      ApolloFrameEncoder.b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloFrameEncoder..special..inlined.observable.1
 * JD-Core Version:    0.7.0.1
 */