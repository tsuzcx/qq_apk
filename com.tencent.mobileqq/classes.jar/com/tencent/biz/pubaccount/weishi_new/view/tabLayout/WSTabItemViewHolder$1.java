package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WSTabItemViewHolder$1
  implements View.OnClickListener
{
  WSTabItemViewHolder$1(WSTabItemViewHolder paramWSTabItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (WSTabItemViewHolder.a(this.a) != null) {
      WSTabItemViewHolder.a(this.a).a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */