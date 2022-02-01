package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;

class TabLayout$AdapterChangeListener
  implements ViewPager.OnAdapterChangeListener
{
  private boolean jdField_a_of_type_Boolean;
  
  TabLayout$AdapterChangeListener(TabLayout paramTabLayout) {}
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onAdapterChanged(@NonNull ViewPager paramViewPager, @Nullable PagerAdapter paramPagerAdapter1, @Nullable PagerAdapter paramPagerAdapter2)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a == paramViewPager) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a(paramPagerAdapter2, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.AdapterChangeListener
 * JD-Core Version:    0.7.0.1
 */