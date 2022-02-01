package com.tencent.biz.expand.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandFragmentViewPager$PageChangeListener;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "(Lcom/tencent/biz/expand/ui/ExpandFragmentViewPager;)V", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFragmentViewPager$PageChangeListener
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt)
  {
    Iterator localIterator = ((Iterable)ExpandFragmentViewPager.a(this.a)).iterator();
    while (localIterator.hasNext())
    {
      ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)localIterator.next();
      if (localOnPageChangeListener != null) {
        localOnPageChangeListener.onPageScrollStateChanged(paramInt);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = ((Iterable)ExpandFragmentViewPager.a(this.a)).iterator();
    while (localIterator.hasNext())
    {
      ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)localIterator.next();
      if (localOnPageChangeListener != null) {
        localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = ((Iterable)ExpandFragmentViewPager.a(this.a)).iterator();
    while (localIterator.hasNext())
    {
      ViewPager.OnPageChangeListener localOnPageChangeListener = (ViewPager.OnPageChangeListener)localIterator.next();
      if (localOnPageChangeListener != null) {
        localOnPageChangeListener.onPageSelected(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandFragmentViewPager.PageChangeListener
 * JD-Core Version:    0.7.0.1
 */