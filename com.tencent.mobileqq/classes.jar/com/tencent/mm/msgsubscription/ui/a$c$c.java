package com.tencent.mm.msgsubscription.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class a$c$c
  implements View.OnClickListener
{
  a$c$c(a.c paramc, a.c.a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    this.b.a().setChecked(this.b.a().isChecked() ^ true);
    ((a.b)this.a.a().get(this.c)).b(this.b.a().isChecked());
    if (((a.b)this.a.a().get(this.c)).a()) {
      a.c.b(this.a).add(this.a.a().get(this.c));
    } else {
      a.c.b(this.a).remove(this.a.a().get(this.c));
    }
    a.a(a.c.a(this.a), a.c.b(this.a).size());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.c.c
 * JD-Core Version:    0.7.0.1
 */