package com.tencent.av.ui.funchat.filter;

import android.database.DataSetObserver;

class EffectCycleViewPager$InnerPagerAdapter$1
  extends DataSetObserver
{
  EffectCycleViewPager$InnerPagerAdapter$1(EffectCycleViewPager.InnerPagerAdapter paramInnerPagerAdapter, EffectCycleViewPager paramEffectCycleViewPager) {}
  
  public void onChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectCycleViewPager.InnerPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */