package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "p0", "aelight_impl_release"}, k=1, mv={1, 1, 16})
final class CenterSmoothScroller
  extends LinearSmoothScroller
{
  public CenterSmoothScroller(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return (paramInt3 + paramInt4) / 2 - (paramInt1 + paramInt2) / 2;
  }
  
  protected float calculateSpeedPerPixel(@NotNull DisplayMetrics paramDisplayMetrics)
  {
    Intrinsics.checkParameterIsNotNull(paramDisplayMetrics, "displayMetrics");
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  @NotNull
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    Object localObject = getLayoutManager();
    if (localObject != null)
    {
      localObject = ((LinearLayoutManager)localObject).computeScrollVectorForPosition(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(layoutManager as Linear…rollVectorForPosition(p0)");
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.CenterSmoothScroller
 * JD-Core Version:    0.7.0.1
 */