package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;

class WSHomeFragment$6
  implements WSTabLayout.TabContentClickListener
{
  WSHomeFragment$6(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(WSTabItemViewHolder paramWSTabItemViewHolder)
  {
    WSHomeFragment.c(this.a, false);
    if (WSHomeFragment.a(this.a) != null)
    {
      if (WSHomeFragment.b(this.a) == null) {
        return;
      }
      if (paramWSTabItemViewHolder != null)
      {
        if (paramWSTabItemViewHolder.a() == null) {
          return;
        }
        WSHomeFragment.a(this.a).setCurrentItem(paramWSTabItemViewHolder.a().a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.6
 * JD-Core Version:    0.7.0.1
 */