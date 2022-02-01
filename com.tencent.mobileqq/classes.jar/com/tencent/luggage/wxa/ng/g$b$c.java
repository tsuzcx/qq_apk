package com.tencent.luggage.wxa.ng;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class g$b$c
  implements View.OnClickListener
{
  g$b$c(g.b paramb, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    if (g.c(this.a.a) != null)
    {
      Function2 localFunction2;
      if (((((Collection)this.a.a.h().c()).isEmpty() ^ true)) && (this.b <= this.a.a.h().c().size()))
      {
        localFunction2 = g.c(this.a.a);
        if (localFunction2 == null) {
          Intrinsics.throwNpe();
        }
        localFunction2.invoke(g.b.a(this.a, this.b).d(), Integer.valueOf(this.c));
      }
      else
      {
        localFunction2 = g.c(this.a.a);
        if (localFunction2 == null) {
          Intrinsics.throwNpe();
        }
        localFunction2.invoke(g.b.a(this.a, this.b).d(), Integer.valueOf(this.c));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.b.c
 * JD-Core Version:    0.7.0.1
 */