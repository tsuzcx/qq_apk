package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$1"}, k=3, mv={1, 1, 16})
final class a$j
  implements View.OnClickListener
{
  a$j(a parama) {}
  
  public final void onClick(View paramView)
  {
    a.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.j
 * JD-Core Version:    0.7.0.1
 */