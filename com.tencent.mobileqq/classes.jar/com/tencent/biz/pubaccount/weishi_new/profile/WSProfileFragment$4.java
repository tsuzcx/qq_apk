package com.tencent.biz.pubaccount.weishi_new.profile;

import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.TabContentClickListener;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;

class WSProfileFragment$4
  implements WSTabLayout.TabContentClickListener
{
  WSProfileFragment$4(WSProfileFragment paramWSProfileFragment) {}
  
  public void a(WSTabItemViewHolder paramWSTabItemViewHolder)
  {
    if (paramWSTabItemViewHolder != null)
    {
      if (paramWSTabItemViewHolder.b() == null) {
        return;
      }
      int i = paramWSTabItemViewHolder.b().d();
      WSProfileFragment.g(this.a).setCurrentItem(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment.4
 * JD-Core Version:    0.7.0.1
 */