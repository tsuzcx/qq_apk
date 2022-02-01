package com.tencent.biz.pubaccount.weishi_new;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabItemViewHolder;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class WSHomeFragment$3
  implements ViewPager.OnPageChangeListener
{
  WSHomeFragment$3(WSHomeFragment paramWSHomeFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      WSHomeFragment.c(this.a, true);
    }
    while (paramInt != 0) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new WSHomeFragment.3.1(this), 100L);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    if ((!WSHomeFragment.a(this.a)) || (WSHomeFragment.a(this.a) == null) || (WSHomeFragment.b(this.a) == null)) {
      return;
    }
    if (this.a.b)
    {
      localWSTabItemViewHolder = WSHomeFragment.a(this.a);
      if (WeishiUtils.a(paramFloat, 0.0F)) {}
      for (;;)
      {
        localWSTabItemViewHolder.a(f1);
        WSHomeFragment.b(this.a).a(paramFloat);
        return;
        f1 = 1.0F - paramFloat;
      }
    }
    if (WSHomeFragment.b(this.a))
    {
      WSHomeFragment.a(this.a).b(paramFloat);
      WSHomeFragment.b(this.a).a(paramFloat);
      return;
    }
    WSHomeFragment.a(this.a).b(paramFloat);
    WSTabItemViewHolder localWSTabItemViewHolder = WSHomeFragment.b(this.a);
    if (WeishiUtils.a(paramFloat, 0.0F)) {}
    for (paramFloat = f2;; paramFloat = 1.0F - paramFloat)
    {
      localWSTabItemViewHolder.b(paramFloat);
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    WSHomeFragment.a = paramInt;
    WSHomeFragment.a(this.a, true);
    WSHomeFragment.b(this.a, true);
    if (WSHomeFragment.b(this.a)) {
      WSHomeFragment.a(this.a);
    }
    WSHomeFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.3
 * JD-Core Version:    0.7.0.1
 */