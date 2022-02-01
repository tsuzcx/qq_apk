package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import java.lang.ref.WeakReference;

class TabLayoutMediator$TabLayoutOnPageChangeCallback
  extends ViewPager2.OnPageChangeCallback
{
  @NonNull
  private final WeakReference<TabLayout> a;
  private int b;
  private int c;
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.b = this.c;
    this.c = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    TabLayout localTabLayout = (TabLayout)this.a.get();
    if (localTabLayout != null)
    {
      paramInt2 = this.c;
      boolean bool2 = false;
      boolean bool1;
      if ((paramInt2 == 2) && (this.b != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if ((this.c != 2) || (this.b != 0)) {
        bool2 = true;
      }
      localTabLayout.setScrollPosition(paramInt1, paramFloat, bool1, bool2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)this.a.get();
    if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount()))
    {
      int i = this.c;
      boolean bool;
      if ((i != 0) && ((i != 2) || (this.b != 0))) {
        bool = false;
      } else {
        bool = true;
      }
      localTabLayout.b(localTabLayout.a(paramInt), bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayoutMediator.TabLayoutOnPageChangeCallback
 * JD-Core Version:    0.7.0.1
 */