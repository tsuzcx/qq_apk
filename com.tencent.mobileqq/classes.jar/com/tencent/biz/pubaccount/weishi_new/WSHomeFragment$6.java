package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.Tab;
import com.tencent.biz.pubaccount.weishi_new.view.WSParentViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;

class WSHomeFragment$6
  implements WSTabLayout.TabContentClickListener
{
  WSHomeFragment$6(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(WSTabItemViewHolder paramWSTabItemViewHolder)
  {
    WSHomeFragment.c(this.a, false);
    if ((WSHomeFragment.a(this.a) == null) || (WSHomeFragment.b(this.a) == null)) {}
    while ((paramWSTabItemViewHolder == null) || (paramWSTabItemViewHolder.a() == null)) {
      return;
    }
    WSHomeFragment.a(this.a).setCurrentItem(paramWSTabItemViewHolder.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.6
 * JD-Core Version:    0.7.0.1
 */