package com.tencent.biz.pubaccount.weishi_new.profile;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.mobileqq.widget.TabLayoutCompat.Tab;

class WSProfileFragment$6
  implements ViewPager.OnPageChangeListener
{
  WSProfileFragment$6(WSProfileFragment paramWSProfileFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    WSProfileFragment localWSProfileFragment = this.a;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    WSProfileFragment.b(localWSProfileFragment, bool);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    WSProfileFragment.h(this.a).b(paramFloat);
    WSTabItemViewHolder localWSTabItemViewHolder = WSProfileFragment.i(this.a);
    float f = 0.0F;
    if (!WeishiUtils.a(paramFloat, 0.0F)) {
      f = 1.0F - paramFloat;
    }
    localWSTabItemViewHolder.b(f);
    WSProfileFragment.j(this.a).a(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = WSProfileFragment.j(this.a).b(paramInt);
    if (localObject != null) {
      ((TabLayoutCompat.Tab)localObject).f();
    }
    WSProfileFragment.a(this.a, paramInt);
    ((WSProfileContract.Presenter)WSProfileFragment.k(this.a)).a(paramInt);
    localObject = this.a;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    WSProfileFragment.a((WSProfileFragment)localObject, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment.6
 * JD-Core Version:    0.7.0.1
 */