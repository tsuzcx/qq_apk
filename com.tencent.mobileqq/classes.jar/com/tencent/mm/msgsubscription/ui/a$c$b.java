package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class a$c$b
  implements View.OnClickListener
{
  a$c$b(a.c paramc, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    a.a(a.c.a(this.a), (a.b)this.a.a().get(this.b));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.c.b
 * JD-Core Version:    0.7.0.1
 */