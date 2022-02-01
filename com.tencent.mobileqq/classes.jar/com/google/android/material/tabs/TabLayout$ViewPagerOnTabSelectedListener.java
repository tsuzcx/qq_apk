package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class TabLayout$ViewPagerOnTabSelectedListener
  implements TabLayout.OnTabSelectedListener
{
  private final ViewPager a;
  
  public TabLayout$ViewPagerOnTabSelectedListener(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
  
  public void a(@NonNull TabLayout.Tab paramTab)
  {
    this.a.setCurrentItem(paramTab.c());
  }
  
  public void b(TabLayout.Tab paramTab) {}
  
  public void c(TabLayout.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.ViewPagerOnTabSelectedListener
 * JD-Core Version:    0.7.0.1
 */