package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

class TabLayoutMediator$ViewPagerOnTabSelectedListener
  implements TabLayout.OnTabSelectedListener
{
  private final ViewPager2 jdField_a_of_type_AndroidxViewpager2WidgetViewPager2;
  private final boolean jdField_a_of_type_Boolean;
  
  public void a(@NonNull TabLayout.Tab paramTab)
  {
    this.jdField_a_of_type_AndroidxViewpager2WidgetViewPager2.setCurrentItem(paramTab.a(), this.jdField_a_of_type_Boolean);
  }
  
  public void b(TabLayout.Tab paramTab) {}
  
  public void c(TabLayout.Tab paramTab) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayoutMediator.ViewPagerOnTabSelectedListener
 * JD-Core Version:    0.7.0.1
 */