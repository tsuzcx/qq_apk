package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/luggage/wxa/standalone_open_runtime/ui/WxaMenuHeader$setPage$1$1"}, k=3, mv={1, 1, 16})
final class c$b
  implements View.OnClickListener
{
  c$b(e parame, Function0 paramFunction0) {}
  
  public final void onClick(View paramView)
  {
    this.b.invoke();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.c.b
 * JD-Core Version:    0.7.0.1
 */