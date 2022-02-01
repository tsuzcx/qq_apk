package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

class TabLayoutMediator$ViewPagerOnTabSelectedListener
  implements TabLayout.OnTabSelectedListener
{
  private final ViewPager2 a;
  private final boolean b;
  
  public void a(@NonNull TabLayout.Tab paramTab)
  {
    this.a.setCurrentItem(paramTab.c(), this.b);
  }
  
  public void b(TabLayout.Tab paramTab) {}
  
  public void c(TabLayout.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayoutMediator.ViewPagerOnTabSelectedListener
 * JD-Core Version:    0.7.0.1
 */