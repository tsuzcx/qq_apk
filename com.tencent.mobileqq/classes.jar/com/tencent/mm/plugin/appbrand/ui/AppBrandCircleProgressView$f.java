package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class AppBrandCircleProgressView$f
  extends ObservableProperty<Float>
{
  public AppBrandCircleProgressView$f(Object paramObject1, Object paramObject2, AppBrandCircleProgressView paramAppBrandCircleProgressView)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, Float paramFloat1, Float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    float f = ((Number)paramFloat2).floatValue();
    ((Number)paramFloat1).floatValue();
    AppBrandCircleProgressView.d(this.b).setStrokeWidth(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView.f
 * JD-Core Version:    0.7.0.1
 */