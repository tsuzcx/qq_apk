package com.tencent.biz.qqstory.view;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.util.Iterator;
import java.util.List;

class EmptySupportViewPager$2
  implements ViewPager.OnPageChangeListener
{
  EmptySupportViewPager$2(EmptySupportViewPager paramEmptySupportViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.a.b != null)
    {
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.a.b != null)
    {
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.a.b != null)
    {
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.EmptySupportViewPager.2
 * JD-Core Version:    0.7.0.1
 */