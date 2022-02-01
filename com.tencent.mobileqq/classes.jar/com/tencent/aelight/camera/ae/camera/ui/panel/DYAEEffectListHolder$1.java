package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "item", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/DYAEEffectItem;", "position", "", "invoke"}, k=3, mv={1, 1, 16})
final class DYAEEffectListHolder$1
  extends Lambda
  implements Function3<View, DYAEEffectItem, Integer, Unit>
{
  DYAEEffectListHolder$1(DYAEEffectListHolder paramDYAEEffectListHolder)
  {
    super(3);
  }
  
  public final void invoke(@NotNull View paramView, @NotNull DYAEEffectItem paramDYAEEffectItem, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "<anonymous parameter 0>");
    Intrinsics.checkParameterIsNotNull(paramDYAEEffectItem, "item");
    DYAEEffectListHolder.c(this.this$0).a(paramDYAEEffectItem, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListHolder.1
 * JD-Core Version:    0.7.0.1
 */