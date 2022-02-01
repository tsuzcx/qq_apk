package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;

class WSHomeFragment$5
  implements WSTabLayout.TabContentClickListener
{
  WSHomeFragment$5(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(WSTabItemViewHolder paramWSTabItemViewHolder)
  {
    WSHomeFragment.c(this.a, false);
    if (WSHomeFragment.c(this.a) != null)
    {
      if (WSHomeFragment.d(this.a) == null) {
        return;
      }
      if (paramWSTabItemViewHolder != null)
      {
        if (paramWSTabItemViewHolder.b() == null) {
          return;
        }
        WSHomeFragment.j(this.a).setCurrentItem(paramWSTabItemViewHolder.b().d());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.5
 * JD-Core Version:    0.7.0.1
 */