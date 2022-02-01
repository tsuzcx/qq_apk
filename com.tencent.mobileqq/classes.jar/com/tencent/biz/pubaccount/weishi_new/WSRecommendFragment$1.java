package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;

class WSRecommendFragment$1
  implements WSTabLayout.TabContentClickListener
{
  WSRecommendFragment$1(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void a(WSTabItemViewHolder paramWSTabItemViewHolder)
  {
    if (paramWSTabItemViewHolder != null)
    {
      if (paramWSTabItemViewHolder.b() == null) {
        return;
      }
      WSRecommendFragment.a(this.a).setCurrentItem(paramWSTabItemViewHolder.b().d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.1
 * JD-Core Version:    0.7.0.1
 */