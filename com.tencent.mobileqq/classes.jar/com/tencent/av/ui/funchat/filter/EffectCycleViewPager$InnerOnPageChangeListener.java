package com.tencent.av.ui.funchat.filter;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.AVLog;
import com.tencent.qphone.base.util.QLog;

class EffectCycleViewPager$InnerOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private ViewPager.OnPageChangeListener b;
  private int c;
  
  public EffectCycleViewPager$InnerOnPageChangeListener(EffectCycleViewPager paramEffectCycleViewPager, ViewPager.OnPageChangeListener paramOnPageChangeListener, int paramInt)
  {
    this.b = paramOnPageChangeListener;
    this.c = paramInt;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      if (this.c == this.a.a.getCount() - 1)
      {
        AVLog.printColorLog("EffectCycleViewPager", "onPageScrollStateChanged 00:1");
        this.a.setCurrentItem(1, false);
      }
      else if (this.c == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPageScrollStateChanged 11:");
        ((StringBuilder)localObject).append(this.a.a.getCount() - 2);
        AVLog.printColorLog("EffectCycleViewPager", ((StringBuilder)localObject).toString());
        localObject = this.a;
        ((EffectCycleViewPager)localObject).setCurrentItem(((EffectCycleViewPager)localObject).a.getCount() - 2, false);
      }
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.b;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.c = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected, pos[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], mSelectListener[");
      boolean bool;
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("EffectCycleViewPager", 1, localStringBuilder.toString());
    }
    if (this.b != null)
    {
      paramInt = this.a.a.a(paramInt);
      this.b.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager.InnerOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */