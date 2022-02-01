package com.tencent.ilive.commonpages.room;

import android.database.DataSetObserver;

class VerticalViewPager$PagerObserver
  extends DataSetObserver
{
  private VerticalViewPager$PagerObserver(VerticalViewPager paramVerticalViewPager) {}
  
  public void onChanged()
  {
    this.this$0.dataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.this$0.dataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.VerticalViewPager.PagerObserver
 * JD-Core Version:    0.7.0.1
 */