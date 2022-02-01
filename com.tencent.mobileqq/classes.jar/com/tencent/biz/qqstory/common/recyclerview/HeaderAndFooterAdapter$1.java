package com.tencent.biz.qqstory.common.recyclerview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HeaderAndFooterAdapter$1
  implements View.OnClickListener
{
  HeaderAndFooterAdapter$1(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.getPosition();
    if (i >= 0) {
      this.b.d.a(this.a.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.common.recyclerview.HeaderAndFooterAdapter.1
 * JD-Core Version:    0.7.0.1
 */