package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.oo.c.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class f$1
  implements View.OnClickListener
{
  f$1(f paramf) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = f.a(this.a, true);
    c.d locald = f.b(this.a);
    n.a locala = f.c(this.a);
    int i;
    if (locala != null) {
      i = locala.g();
    } else {
      i = 0;
    }
    locald.a(1, (ArrayList)localObject, i);
    localObject = f.d(this.a);
    if (localObject != null) {
      ((l)localObject).b((i)this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.1
 * JD-Core Version:    0.7.0.1
 */