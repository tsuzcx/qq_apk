package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class DYAEEffectListAdapter$onBindViewHolder$1
  implements View.OnClickListener
{
  DYAEEffectListAdapter$onBindViewHolder$1(DYAEEffectListAdapter paramDYAEEffectListAdapter, DYAEEffectItem paramDYAEEffectItem, DYAEEffectListAdapter.DYAEEffectVH paramDYAEEffectVH, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (this.b.f())
    {
      paramView = DYAEEffectListAdapter.a(this.a);
      View localView = this.c.itemView;
      Intrinsics.checkExpressionValueIsNotNull(localView, "p0.itemView");
      paramView.invoke(localView, this.b, Integer.valueOf(this.d));
      paramView = this.c.itemView;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "p0.itemView");
      DYAEEffectListHolderKt.a(paramView, this.b);
      return;
    }
    int i = DYAEBeautyPanelConfigHolder.a().g();
    paramView = DYAEEffectListAdapter.b(this.a).getResources().getString(i);
    QQToast.makeText(DYAEEffectListAdapter.b(this.a), (CharSequence)paramView, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectListAdapter.onBindViewHolder.1
 * JD-Core Version:    0.7.0.1
 */