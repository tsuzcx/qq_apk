package com.tencent.biz.qqcircle.richframework.widget;

public class TabLayoutCompat$ViewPagerOnTabSelectedListener
  implements TabLayoutCompat.OnTabSelectedListener
{
  private final ViewPagerCompat a;
  
  public TabLayoutCompat$ViewPagerOnTabSelectedListener(ViewPagerCompat paramViewPagerCompat)
  {
    this.a = paramViewPagerCompat;
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    this.a.setCurrentItem(paramTab.c());
  }
  
  public void b(TabLayoutCompat.Tab paramTab) {}
  
  public void c(TabLayoutCompat.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.ViewPagerOnTabSelectedListener
 * JD-Core Version:    0.7.0.1
 */