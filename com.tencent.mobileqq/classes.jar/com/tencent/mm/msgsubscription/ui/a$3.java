package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class a$3
  implements View.OnClickListener
{
  a$3(a parama, List paramList) {}
  
  public final void onClick(View paramView)
  {
    a.a(this.a, (a.b)this.b.get(0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.3
 * JD-Core Version:    0.7.0.1
 */