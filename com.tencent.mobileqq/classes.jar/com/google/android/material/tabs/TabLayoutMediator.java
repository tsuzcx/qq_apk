package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager2.widget.ViewPager2;

public final class TabLayoutMediator
{
  @Nullable
  private RecyclerView.Adapter<?> jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$Adapter;
  @NonNull
  private final ViewPager2 jdField_a_of_type_AndroidxViewpager2WidgetViewPager2;
  @NonNull
  private final TabLayout jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout;
  private final TabLayoutMediator.TabConfigurationStrategy jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayoutMediator$TabConfigurationStrategy;
  
  void a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a();
    Object localObject = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$Adapter;
    if (localObject != null)
    {
      int j = ((RecyclerView.Adapter)localObject).getItemCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a();
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayoutMediator$TabConfigurationStrategy.a((TabLayout.Tab)localObject, i);
        this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a((TabLayout.Tab)localObject, false);
        i += 1;
      }
      if (j > 0)
      {
        i = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.a();
        i = Math.min(this.jdField_a_of_type_AndroidxViewpager2WidgetViewPager2.getCurrentItem(), i - 1);
        if (i != this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout.b())
        {
          localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialTabsTabLayout;
          ((TabLayout)localObject).b(((TabLayout)localObject).a(i));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayoutMediator
 * JD-Core Version:    0.7.0.1
 */