package com.tencent.mobileqq.activity.aio.intimate.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class LoveTreeView$init$1
  implements View.OnClickListener
{
  LoveTreeView$init$1(LoveTreeView paramLoveTreeView) {}
  
  public final void onClick(View paramView)
  {
    LoveTreeView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.LoveTreeView.init.1
 * JD-Core Version:    0.7.0.1
 */