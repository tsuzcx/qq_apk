package com.tencent.aelight.camera.aeeditor.view.reorder;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ReorderContainerView$screenWidth$2
  extends Lambda
  implements Function0<Integer>
{
  ReorderContainerView$screenWidth$2(Context paramContext)
  {
    super(0);
  }
  
  public final int invoke()
  {
    Resources localResources = this.$context.getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "context.resources");
    return localResources.getDisplayMetrics().widthPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView.screenWidth.2
 * JD-Core Version:    0.7.0.1
 */