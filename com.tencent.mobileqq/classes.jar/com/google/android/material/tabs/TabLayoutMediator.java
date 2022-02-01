package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager2.widget.ViewPager2;

public final class TabLayoutMediator
{
  @NonNull
  private final TabLayout a;
  @NonNull
  private final ViewPager2 b;
  private final TabLayoutMediator.TabConfigurationStrategy c;
  @Nullable
  private RecyclerView.Adapter<?> d;
  
  void a()
  {
    this.a.c();
    Object localObject = this.d;
    if (localObject != null)
    {
      int j = ((RecyclerView.Adapter)localObject).getItemCount();
      int i = 0;
      while (i < j)
      {
        localObject = this.a.a();
        this.c.a((TabLayout.Tab)localObject, i);
        this.a.a((TabLayout.Tab)localObject, false);
        i += 1;
      }
      if (j > 0)
      {
        i = this.a.getTabCount();
        i = Math.min(this.b.getCurrentItem(), i - 1);
        if (i != this.a.getSelectedTabPosition())
        {
          localObject = this.a;
          ((TabLayout)localObject).c(((TabLayout)localObject).a(i));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayoutMediator
 * JD-Core Version:    0.7.0.1
 */