package com.tencent.biz.qqstory.view.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class InnerListView$1
  implements View.OnClickListener
{
  InnerListView$1(InnerListView paramInnerListView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((InnerListView.a(this.b) != null) && (InnerListView.b(this.b) != null)) {
      InnerListView.a(this.b).a(this.b, paramView, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListView.1
 * JD-Core Version:    0.7.0.1
 */