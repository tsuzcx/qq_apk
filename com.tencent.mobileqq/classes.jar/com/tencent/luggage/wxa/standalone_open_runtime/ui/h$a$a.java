package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.cx.t;
import com.tencent.luggage.wxa.cx.t.c;
import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class h$a$a
  implements View.OnClickListener
{
  h$a$a(h.a parama, View.OnClickListener paramOnClickListener) {}
  
  public final void onClick(View paramView)
  {
    if (!h.a.a(this.a))
    {
      Object localObject = h.a.b(this.a);
      if (localObject != null)
      {
        t localt = t.a;
        localObject = ((d)localObject).j();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig");
        localObject = ((c)localObject).i();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "initConfig.wxaLaunchInstanceId");
        localt.a((String)localObject, t.c.e);
      }
    }
    this.b.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.h.a.a
 * JD-Core Version:    0.7.0.1
 */