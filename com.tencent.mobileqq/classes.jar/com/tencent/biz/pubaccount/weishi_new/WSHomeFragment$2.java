package com.tencent.biz.pubaccount.weishi_new;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class WSHomeFragment$2
  implements ViewPager.OnPageChangeListener
{
  WSHomeFragment$2(WSHomeFragment paramWSHomeFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      WSHomeFragment.c(this.a, true);
      return;
    }
    if (paramInt == 0) {
      ThreadManager.getUIHandler().postDelayed(new WSHomeFragment.2.1(this), 100L);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((WSHomeFragment.b(this.a)) && (WSHomeFragment.c(this.a) != null))
    {
      if (WSHomeFragment.d(this.a) == null) {
        return;
      }
      boolean bool = this.a.e;
      float f2 = 0.0F;
      float f1 = 0.0F;
      if (bool)
      {
        localWSTabItemViewHolder = WSHomeFragment.c(this.a);
        if (!WeishiUtils.a(paramFloat, 0.0F)) {
          f1 = 1.0F - paramFloat;
        }
        localWSTabItemViewHolder.a(f1);
        WSHomeFragment.d(this.a).a(paramFloat);
        return;
      }
      if (WSHomeFragment.e(this.a))
      {
        WSHomeFragment.c(this.a).b(paramFloat);
        WSHomeFragment.d(this.a).a(paramFloat);
        return;
      }
      WSHomeFragment.c(this.a).b(paramFloat);
      WSTabItemViewHolder localWSTabItemViewHolder = WSHomeFragment.d(this.a);
      if (WeishiUtils.a(paramFloat, 0.0F)) {
        paramFloat = f2;
      } else {
        paramFloat = 1.0F - paramFloat;
      }
      localWSTabItemViewHolder.b(paramFloat);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    WSHomeFragment.f = paramInt;
    WSHomeFragment.a(this.a, true);
    WSHomeFragment.b(this.a, true);
    if (WSHomeFragment.e(this.a)) {
      WSHomeFragment.f(this.a);
    }
    WSHomeFragment.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.2
 * JD-Core Version:    0.7.0.1
 */