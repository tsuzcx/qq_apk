package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;

public class TabLayoutCompat$TabLayoutOnPageChangeListener
  implements ViewPager.OnPageChangeListener
{
  private int jdField_a_of_type_Int;
  private final WeakReference<TabLayoutCompat> jdField_a_of_type_JavaLangRefWeakReference;
  private int b;
  
  public TabLayoutCompat$TabLayoutOnPageChangeListener(TabLayoutCompat paramTabLayoutCompat)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTabLayoutCompat);
  }
  
  void a()
  {
    this.b = 0;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_a_of_type_Int = this.b;
    this.b = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    boolean bool2 = false;
    TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localTabLayoutCompat != null) {
      if ((this.b == 2) && (this.jdField_a_of_type_Int != 1)) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((this.b != 2) || (this.jdField_a_of_type_Int != 0)) {
        bool2 = true;
      }
      localTabLayoutCompat.a(paramInt1, paramFloat, bool1, bool2);
      return;
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localTabLayoutCompat != null) && (localTabLayoutCompat.b() != paramInt) && (paramInt < localTabLayoutCompat.a())) {
      if ((this.b != 0) && ((this.b != 2) || (this.jdField_a_of_type_Int != 0))) {
        break label105;
      }
    }
    label105:
    for (boolean bool = true;; bool = false)
    {
      TabLayoutCompat.Tab localTab1 = TabLayoutCompat.a(localTabLayoutCompat);
      localTabLayoutCompat.b(localTabLayoutCompat.a(paramInt), bool);
      TabLayoutCompat.Tab localTab2 = localTabLayoutCompat.a(paramInt);
      if ((TabLayoutCompat.a(localTabLayoutCompat) != null) && (localTab2 != null)) {
        TabLayoutCompat.a(localTabLayoutCompat).a(localTab2, localTab1, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.TabLayoutOnPageChangeListener
 * JD-Core Version:    0.7.0.1
 */