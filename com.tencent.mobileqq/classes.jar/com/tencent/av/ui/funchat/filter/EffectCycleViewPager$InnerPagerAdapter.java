package com.tencent.av.ui.funchat.filter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

class EffectCycleViewPager$InnerPagerAdapter
  extends PagerAdapter
{
  private PagerAdapter b;
  
  public EffectCycleViewPager$InnerPagerAdapter(EffectCycleViewPager paramEffectCycleViewPager, PagerAdapter paramPagerAdapter)
  {
    this.b = paramPagerAdapter;
    paramPagerAdapter.registerDataSetObserver(new EffectCycleViewPager.InnerPagerAdapter.1(this, paramEffectCycleViewPager));
  }
  
  int a(int paramInt)
  {
    if (paramInt == 0) {
      return this.b.getCount() - 1;
    }
    if (paramInt == this.b.getCount() + 1) {
      return 0;
    }
    return paramInt - 1;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    int i = a(paramInt);
    this.a.b.remove(paramInt);
    this.b.destroyItem(paramViewGroup, i, paramObject);
  }
  
  public int getCount()
  {
    int i = this.b.getCount();
    if (i > 0) {
      return i + 2;
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = a(paramInt);
    paramViewGroup = (View)this.b.instantiateItem(paramViewGroup, i);
    this.a.b.put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return this.b.isViewFromObject(paramView, paramObject);
  }
  
  public void notifyDataSetChanged()
  {
    this.a.setCurrentItem(1);
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager.InnerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */