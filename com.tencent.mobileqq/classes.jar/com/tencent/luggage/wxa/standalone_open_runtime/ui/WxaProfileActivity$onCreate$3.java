package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxaProfileActivity$onCreate$3
  implements View.OnClickListener
{
  WxaProfileActivity$onCreate$3(WxaProfileActivity paramWxaProfileActivity) {}
  
  public final void onClick(View paramView)
  {
    if ((WxaProfileActivity.b(this.a) != null) && (WxaProfileActivity.d(this.a) != null)) {
      b.a.a(WxaProfileActivity.a(this.a), (Context)this.a, "sdk_openAppProfile", (Function0)new WxaProfileActivity.onCreate.3.3(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.onCreate.3
 * JD-Core Version:    0.7.0.1
 */