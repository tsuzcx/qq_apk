package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;

class WSRecommendFragment$2
  implements WSTabLayout.TabContentClickListener
{
  WSRecommendFragment$2(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(WSTabItemViewHolder paramWSTabItemViewHolder)
  {
    if ((paramWSTabItemViewHolder == null) || (paramWSTabItemViewHolder.a() == null)) {
      return;
    }
    WSRecommendFragment.a(this.a).setCurrentItem(paramWSTabItemViewHolder.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.2
 * JD-Core Version:    0.7.0.1
 */