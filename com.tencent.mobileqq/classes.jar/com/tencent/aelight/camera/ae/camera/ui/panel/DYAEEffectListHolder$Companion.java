package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectListHolder$Companion;", "", "()V", "LIST_HORIZONTAL_PADDING_DP", "", "LIST_ITEM_SPACE_DP", "LIST_TOP_MARGIN_DP", "px", "", "context", "Landroid/content/Context;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class DYAEEffectListHolder$Companion
{
  private final int a(float paramFloat, Context paramContext)
  {
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getDisplayMetrics());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.Companion
 * JD-Core Version:    0.7.0.1
 */