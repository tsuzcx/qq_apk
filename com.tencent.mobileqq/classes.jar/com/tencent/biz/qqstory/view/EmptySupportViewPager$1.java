package com.tencent.biz.qqstory.view;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;

class EmptySupportViewPager$1
  extends DataSetObserver
{
  EmptySupportViewPager$1(EmptySupportViewPager paramEmptySupportViewPager) {}
  
  public void onChanged()
  {
    PagerAdapter localPagerAdapter = this.a.getAdapter();
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      this.a.setAllEmptyViewVisibility(8);
      EmptySupportViewPager.a(this.a, 0);
      return;
    }
    this.a.setAllEmptyViewVisibility(0);
    EmptySupportViewPager.b(this.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.EmptySupportViewPager.1
 * JD-Core Version:    0.7.0.1
 */