package com.tencent.av.ui.funchat.filter;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.AVLog;
import com.tencent.qphone.base.util.QLog;

class EffectCycleViewPager$InnerOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private int jdField_a_of_type_Int;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
  
  public EffectCycleViewPager$InnerOnPageChangeListener(EffectCycleViewPager paramEffectCycleViewPager, ViewPager.OnPageChangeListener paramOnPageChangeListener, int paramInt)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = paramOnPageChangeListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.getCount() - 1)
      {
        AVLog.printColorLog("EffectCycleViewPager", "onPageScrollStateChanged 00:1");
        this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.setCurrentItem(1, false);
      }
      else if (this.jdField_a_of_type_Int == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPageScrollStateChanged 11:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.getCount() - 2);
        AVLog.printColorLog("EffectCycleViewPager", ((StringBuilder)localObject).toString());
        localObject = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager;
        ((EffectCycleViewPager)localObject).setCurrentItem(((EffectCycleViewPager)localObject).a.getCount() - 2, false);
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageSelected, pos[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], mSelectListener[");
      boolean bool;
      if (this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w("EffectCycleViewPager", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener != null)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.a(paramInt);
      this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager.InnerOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */