package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

@TargetApi(9)
public class EffectCycleViewPager
  extends ViewPager
{
  SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private EffectCycleViewPager.InnerOnPageChangeListener jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$InnerOnPageChangeListener;
  protected EffectCycleViewPager.InnerPagerAdapter a;
  
  public EffectCycleViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectCycleViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  View a()
  {
    int i = getCurrentItem();
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$InnerPagerAdapter = new EffectCycleViewPager.InnerPagerAdapter(this, paramPagerAdapter);
    super.setAdapter(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$InnerPagerAdapter);
    setCurrentItem(1);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$InnerOnPageChangeListener = new EffectCycleViewPager.InnerOnPageChangeListener(this, paramOnPageChangeListener, getCurrentItem());
    super.setOnPageChangeListener(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager$InnerOnPageChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager
 * JD-Core Version:    0.7.0.1
 */