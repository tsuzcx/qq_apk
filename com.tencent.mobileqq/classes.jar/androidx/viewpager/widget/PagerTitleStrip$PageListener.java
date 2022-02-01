package androidx.viewpager.widget;

import android.database.DataSetObserver;

class PagerTitleStrip$PageListener
  extends DataSetObserver
  implements ViewPager.OnAdapterChangeListener, ViewPager.OnPageChangeListener
{
  private int mScrollState;
  
  PagerTitleStrip$PageListener(PagerTitleStrip paramPagerTitleStrip) {}
  
  public void onAdapterChanged(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
  {
    this.this$0.updateAdapter(paramPagerAdapter1, paramPagerAdapter2);
  }
  
  public void onChanged()
  {
    float f = 0.0F;
    this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
    if (this.this$0.mLastKnownPositionOffset >= 0.0F) {
      f = this.this$0.mLastKnownPositionOffset;
    }
    this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), f, true);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.mScrollState = paramInt;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt2 = paramInt1;
    if (paramFloat > 0.5F) {
      paramInt2 = paramInt1 + 1;
    }
    this.this$0.updateTextPositions(paramInt2, paramFloat, false);
  }
  
  public void onPageSelected(int paramInt)
  {
    float f = 0.0F;
    if (this.mScrollState == 0)
    {
      this.this$0.updateText(this.this$0.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
      if (this.this$0.mLastKnownPositionOffset >= 0.0F) {
        f = this.this$0.mLastKnownPositionOffset;
      }
      this.this$0.updateTextPositions(this.this$0.mPager.getCurrentItem(), f, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip.PageListener
 * JD-Core Version:    0.7.0.1
 */