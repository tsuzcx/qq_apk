package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnLongClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k=3, mv={1, 1, 16})
final class n$d$c
  implements View.OnLongClickListener
{
  n$d$c(n.d paramd, n.a parama, int paramInt) {}
  
  public final boolean onLongClick(View paramView)
  {
    paramView = n.d.a(this.a).b();
    if (paramView != null) {
      paramView.a(this.a.a(), this.b, this.c);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.n.d.c
 * JD-Core Version:    0.7.0.1
 */