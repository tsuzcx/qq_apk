package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import java.lang.ref.WeakReference;

class TabLayoutMediator$TabLayoutOnPageChangeCallback
  extends ViewPager2.OnPageChangeCallback
{
  private int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference<TabLayout> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    TabLayout localTabLayout = (TabLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localTabLayout != null)
    {
      paramInt2 = this.b;
      boolean bool2 = false;
      boolean bool1;
      if ((paramInt2 == 2) && (this.jdField_a_of_type_Int != 1)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if ((this.b != 2) || (this.jdField_a_of_type_Int != 0)) {
        bool2 = true;
      }
      localTabLayout.setScrollPosition(paramInt1, paramFloat, bool1, bool2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TabLayout localTabLayout = (TabLayout)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localTabLayout != null) && (localTabLayout.b() != paramInt) && (paramInt < localTabLayout.a()))
    {
      int i = this.b;
      boolean bool;
      if ((i != 0) && ((i != 2) || (this.jdField_a_of_type_Int != 0))) {
        bool = false;
      } else {
        bool = true;
      }
      localTabLayout.b(localTabLayout.a(paramInt), bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayoutMediator.TabLayoutOnPageChangeCallback
 * JD-Core Version:    0.7.0.1
 */