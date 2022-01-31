package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import mpk;
import mpl;

@TargetApi(9)
public class EffectCycleViewPager
  extends ViewPager
{
  public SparseArray<View> a;
  private mpk a;
  public mpl a;
  
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
    this.jdField_a_of_type_Mpl = new mpl(this, paramPagerAdapter);
    super.setAdapter(this.jdField_a_of_type_Mpl);
    setCurrentItem(1);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_Mpk = new mpk(this, paramOnPageChangeListener, getCurrentItem());
    super.setOnPageChangeListener(this.jdField_a_of_type_Mpk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager
 * JD-Core Version:    0.7.0.1
 */