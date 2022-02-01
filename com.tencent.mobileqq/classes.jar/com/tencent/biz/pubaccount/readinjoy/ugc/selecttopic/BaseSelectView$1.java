package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.mvp.ListPresenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "HOLDER", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BaseSelectView$1
  implements View.OnClickListener
{
  BaseSelectView$1(BaseSelectView paramBaseSelectView) {}
  
  public final void onClick(View paramView)
  {
    BaseSelectView.a(this.a).b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.BaseSelectView.1
 * JD-Core Version:    0.7.0.1
 */