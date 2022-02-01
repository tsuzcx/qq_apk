package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJXTabBar$init$5
  implements View.OnClickListener
{
  RIJXTabBar$init$5(RIJXTabBar paramRIJXTabBar) {}
  
  public final void onClick(View paramView)
  {
    RIJXTabBar.OnBtnClickListener localOnBtnClickListener = RIJXTabBar.a(this.a);
    if (localOnBtnClickListener != null) {
      localOnBtnClickListener.d((View)RIJXTabBar.d(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar.init.5
 * JD-Core Version:    0.7.0.1
 */