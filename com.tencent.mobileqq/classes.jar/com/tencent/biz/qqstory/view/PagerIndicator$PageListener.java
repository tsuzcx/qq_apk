package com.tencent.biz.qqstory.view;

import android.database.DataSetObserver;
import android.util.Log;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class PagerIndicator$PageListener
  extends DataSetObserver
  implements ViewPager.OnPageChangeListener
{
  private PagerIndicator$PageListener(PagerIndicator paramPagerIndicator) {}
  
  public void onChanged()
  {
    Log.d("PagerIndicator", "onChanged");
    PagerIndicator localPagerIndicator = this.a;
    localPagerIndicator.a(localPagerIndicator.a.getCurrentItem(), (PagerIndicator.IndicatorAdapter)this.a.a.getAdapter());
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageSelected : ");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("PagerIndicator", ((StringBuilder)localObject).toString());
    localObject = this.a;
    ((PagerIndicator)localObject).a(((PagerIndicator)localObject).a.getCurrentItem(), (PagerIndicator.IndicatorAdapter)this.a.a.getAdapter());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PagerIndicator.PageListener
 * JD-Core Version:    0.7.0.1
 */