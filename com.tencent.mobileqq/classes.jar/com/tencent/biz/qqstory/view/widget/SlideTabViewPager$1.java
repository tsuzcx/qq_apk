package com.tencent.biz.qqstory.view.widget;

import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class SlideTabViewPager$1
  implements ViewPager.OnPageChangeListener
{
  SlideTabViewPager$1(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (SlideTabViewPager.a(this.a) == 0)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)SlideTabViewPager.b(this.a).getLayoutParams();
      SlideTabViewPager localSlideTabViewPager = this.a;
      SlideTabViewPager.a(localSlideTabViewPager, SlideTabViewPager.c(localSlideTabViewPager).getWidth() + localLayoutParams.leftMargin);
    }
    float f1 = SlideTabViewPager.a(this.a, 12.5F);
    float f2 = SlideTabViewPager.a(this.a);
    paramFloat = paramInt1 + paramFloat;
    paramInt1 = (int)(f1 + f2 * paramFloat);
    SlideTabViewPager.d(this.a).setOffset(paramInt1);
    paramInt1 = SlideTabViewPager.c(this.a).getWidth();
    paramInt2 = SlideTabViewPager.b(this.a).getWidth();
    paramInt1 = (int)(paramInt1 + (paramInt2 - paramInt1) * paramFloat);
    SlideTabViewPager.d(this.a).setBlockWidth(paramInt1);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.a.b(paramInt);
    if (SlideTabViewPager.e(this.a) != null) {
      onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager.1
 * JD-Core Version:    0.7.0.1
 */