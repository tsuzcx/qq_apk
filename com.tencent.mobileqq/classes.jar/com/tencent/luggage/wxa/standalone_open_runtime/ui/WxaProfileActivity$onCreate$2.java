package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.cx.q;
import com.tencent.luggage.wxa.ew.b;
import com.tencent.luggage.wxa.ou.d;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxaProfileActivity$onCreate$2
  implements View.OnClickListener
{
  WxaProfileActivity$onCreate$2(WxaProfileActivity paramWxaProfileActivity) {}
  
  public final void onClick(View paramView)
  {
    Context localContext = (Context)this.a;
    b localb = new b();
    localb.a = WxaProfileActivity.a(this.a);
    localb.e = 0;
    d locald = new d();
    locald.c = 1024;
    q.a(localContext, localb, locald);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.onCreate.2
 * JD-Core Version:    0.7.0.1
 */