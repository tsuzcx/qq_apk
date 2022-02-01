package com.tencent.luggage.wxa.standalone_open_runtime;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class e$p
  implements View.OnClickListener
{
  e$p(e parame) {}
  
  public final void onClick(View paramView)
  {
    m.a(m.a, (c)this.a, 22, null, 0L, 0, 0, 60, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.p
 * JD-Core Version:    0.7.0.1
 */