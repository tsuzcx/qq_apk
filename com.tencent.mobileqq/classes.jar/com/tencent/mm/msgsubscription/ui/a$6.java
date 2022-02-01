package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class a$6
  implements View.OnClickListener
{
  a$6(a parama, List paramList) {}
  
  public final void onClick(View paramView)
  {
    a.i(this.a).setChecked(a.i(this.a).isChecked() ^ true);
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext()) {
      ((a.b)localIterator.next()).a(a.i(this.a).isChecked());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.6
 * JD-Core Version:    0.7.0.1
 */