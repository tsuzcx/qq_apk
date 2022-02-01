package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k=3, mv={1, 1, 16})
final class AppBrandCircleProgressView$j
  extends Lambda
  implements Function0<Paint>
{
  AppBrandCircleProgressView$j(AppBrandCircleProgressView paramAppBrandCircleProgressView)
  {
    super(0);
  }
  
  @NotNull
  public final Paint a()
  {
    Paint localPaint = new Paint(1);
    localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    localPaint.setStrokeWidth(this.a.getCircleStrokeWidth());
    return localPaint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView.j
 * JD-Core Version:    0.7.0.1
 */