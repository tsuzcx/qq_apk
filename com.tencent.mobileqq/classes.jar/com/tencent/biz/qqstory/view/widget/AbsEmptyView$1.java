package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbsEmptyView$1
  implements View.OnClickListener
{
  AbsEmptyView$1(AbsEmptyView paramAbsEmptyView, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.b.a(3);
    this.a.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AbsEmptyView.1
 * JD-Core Version:    0.7.0.1
 */