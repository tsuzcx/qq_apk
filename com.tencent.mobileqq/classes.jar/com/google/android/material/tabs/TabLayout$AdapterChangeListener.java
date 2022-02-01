package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;

class TabLayout$AdapterChangeListener
  implements ViewPager.OnAdapterChangeListener
{
  private boolean b;
  
  TabLayout$AdapterChangeListener(TabLayout paramTabLayout) {}
  
  void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void onAdapterChanged(@NonNull ViewPager paramViewPager, @Nullable PagerAdapter paramPagerAdapter1, @Nullable PagerAdapter paramPagerAdapter2)
  {
    if (this.a.x == paramViewPager) {
      this.a.a(paramPagerAdapter2, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout.AdapterChangeListener
 * JD-Core Version:    0.7.0.1
 */