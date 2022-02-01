package com.tencent.luggage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxaMusicActivity$b$b
  implements View.OnClickListener
{
  WxaMusicActivity$b$b(WxaMusicActivity.b paramb) {}
  
  public final void onClick(View paramView)
  {
    WxaMusicActivity.b.b(this.a).b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.b.b
 * JD-Core Version:    0.7.0.1
 */