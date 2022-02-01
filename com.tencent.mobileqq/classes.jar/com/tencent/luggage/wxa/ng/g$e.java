package com.tencent.luggage.wxa.ng;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class g$e
  implements View.OnClickListener
{
  g$e(g paramg) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = g.d(this.a);
    if (localObject != null) {
      localObject = (Unit)((Function0)localObject).invoke();
    }
    localObject = g.c(this.a);
    if (localObject != null) {
      localObject = (Unit)((Function2)localObject).invoke(null, Integer.valueOf(0));
    }
    this.a.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.e
 * JD-Core Version:    0.7.0.1
 */