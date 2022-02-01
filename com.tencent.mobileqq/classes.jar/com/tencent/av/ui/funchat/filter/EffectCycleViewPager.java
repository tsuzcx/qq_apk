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
  protected EffectCycleViewPager.InnerPagerAdapter a;
  SparseArray<View> b = new SparseArray();
  private EffectCycleViewPager.InnerOnPageChangeListener c;
  
  public EffectCycleViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectCycleViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  View getCurrentView()
  {
    int i = getCurrentItem();
    return (View)this.b.get(i);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    this.a = new EffectCycleViewPager.InnerPagerAdapter(this, paramPagerAdapter);
    super.setAdapter(this.a);
    setCurrentItem(1);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.c = new EffectCycleViewPager.InnerOnPageChangeListener(this, paramOnPageChangeListener, getCurrentItem());
    super.setOnPageChangeListener(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager
 * JD-Core Version:    0.7.0.1
 */