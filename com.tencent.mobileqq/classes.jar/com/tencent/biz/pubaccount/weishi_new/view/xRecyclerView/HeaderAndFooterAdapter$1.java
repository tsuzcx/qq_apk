package com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView;

import android.view.View;
import android.view.View.OnClickListener;

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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.xRecyclerView.HeaderAndFooterAdapter.1
 * JD-Core Version:    0.7.0.1
 */