package com.tencent.luggage.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WxaMusicActivity$b$e
  implements View.OnClickListener
{
  WxaMusicActivity$b$e(WxaMusicActivity.b paramb) {}
  
  public final void onClick(View paramView)
  {
    WxaMusicActivity.b.c(this.a).setVisibility(8);
    WxaMusicActivity.b.d(this.a).setVisibility(0);
    WxaMusicActivity.b.b(this.a).c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.b.e
 * JD-Core Version:    0.7.0.1
 */