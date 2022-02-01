package com.tencent.biz.qqstory.view.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class SlideTabViewPager$1
  implements ViewPager.OnPageChangeListener
{
  SlideTabViewPager$1(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (SlideTabViewPager.a(this.a) == 0)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)SlideTabViewPager.a(this.a).getLayoutParams();
      SlideTabViewPager localSlideTabViewPager = this.a;
      paramInt2 = SlideTabViewPager.b(this.a).getWidth();
      SlideTabViewPager.a(localSlideTabViewPager, localLayoutParams.leftMargin + paramInt2);
    }
    paramInt2 = (int)(SlideTabViewPager.a(this.a, 12.5F) + SlideTabViewPager.a(this.a) * (paramInt1 + paramFloat));
    SlideTabViewPager.a(this.a).setOffset(paramInt2);
    paramInt2 = SlideTabViewPager.b(this.a).getWidth();
    int i = SlideTabViewPager.a(this.a).getWidth();
    paramInt1 = (int)(paramInt2 + (i - paramInt2) * (paramInt1 + paramFloat));
    SlideTabViewPager.a(this.a).setBlockWidth(paramInt1);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.a.b(paramInt);
    if (SlideTabViewPager.a(this.a) != null) {
      onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager.1
 * JD-Core Version:    0.7.0.1
 */