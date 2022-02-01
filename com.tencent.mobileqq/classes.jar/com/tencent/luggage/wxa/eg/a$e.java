package com.tencent.luggage.wxa.eg;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class a$e
  implements View.OnClickListener
{
  a$e(a parama, a.c paramc, d paramd) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = this.b.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "holder.checkBox");
    Object localObject2 = this.b.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "holder.checkBox");
    ((CheckBox)localObject1).setChecked(((CheckBox)localObject2).isChecked() ^ true);
    localObject1 = a.a(this.a);
    localObject2 = this.c;
    CheckBox localCheckBox = this.b.a();
    Intrinsics.checkExpressionValueIsNotNull(localCheckBox, "holder.checkBox");
    ((a.a)localObject1).a((d)localObject2, localCheckBox.isChecked());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eg.a.e
 * JD-Core Version:    0.7.0.1
 */