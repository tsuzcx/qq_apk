package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import kct;
import kcu;

@TargetApi(9)
public class EffectCycleViewPager
  extends ViewPager
{
  public SparseArray a;
  private kct a;
  public kcu a;
  
  public EffectCycleViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectCycleViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  View a()
  {
    int i = getCurrentItem();
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    this.jdField_a_of_type_Kcu = new kcu(this, paramPagerAdapter);
    super.setAdapter(this.jdField_a_of_type_Kcu);
    setCurrentItem(1);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_Kct = new kct(this, paramOnPageChangeListener, getCurrentItem());
    super.setOnPageChangeListener(this.jdField_a_of_type_Kct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager
 * JD-Core Version:    0.7.0.1
 */