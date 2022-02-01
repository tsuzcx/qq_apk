package com.tencent.biz.qqcircle.richframework.widget;

import android.database.DataSetObserver;

class TabLayoutCompat$PagerAdapterObserver
  extends DataSetObserver
{
  private boolean b;
  
  TabLayoutCompat$PagerAdapterObserver(TabLayoutCompat paramTabLayoutCompat) {}
  
  void a()
  {
    if ((this.a.m != null) && (TabLayoutCompat.d(this.a) != null))
    {
      int i = this.a.m.getCurrentItem();
      if (this.a.getSelectedTabPosition() == i) {
        TabLayoutCompat.d(this.a).b(i, 300);
      }
    }
    if (TabLayoutCompat.e(this.a) != null) {
      TabLayoutCompat.e(this.a).a();
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void onChanged()
  {
    if (this.b)
    {
      this.a.c();
      return;
    }
    a();
  }
  
  public void onInvalidated()
  {
    if (this.b)
    {
      this.a.c();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.PagerAdapterObserver
 * JD-Core Version:    0.7.0.1
 */