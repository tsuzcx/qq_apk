package com.tencent.biz.pubaccount.readinjoy.view;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<no name provided>", "", "canvas", "Landroid/graphics/Canvas;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJBlackWhiteModeLinearLayout$dispatchDrawCanvas$1
  extends Lambda
  implements Function1<Canvas, Unit>
{
  RIJBlackWhiteModeLinearLayout$dispatchDrawCanvas$1(RIJBlackWhiteModeLinearLayout paramRIJBlackWhiteModeLinearLayout)
  {
    super(1);
  }
  
  public final void invoke(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    RIJBlackWhiteModeLinearLayout.b(this.this$0, paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJBlackWhiteModeLinearLayout.dispatchDrawCanvas.1
 * JD-Core Version:    0.7.0.1
 */