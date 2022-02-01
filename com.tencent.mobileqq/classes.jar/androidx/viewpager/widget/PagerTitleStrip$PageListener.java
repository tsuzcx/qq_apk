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
    PagerTitleStrip localPagerTitleStrip = this.this$0;
    localPagerTitleStrip.updateText(localPagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
    float f2 = this.this$0.mLastKnownPositionOffset;
    float f1 = 0.0F;
    if (f2 >= 0.0F) {
      f1 = this.this$0.mLastKnownPositionOffset;
    }
    localPagerTitleStrip = this.this$0;
    localPagerTitleStrip.updateTextPositions(localPagerTitleStrip.mPager.getCurrentItem(), f1, true);
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
    if (this.mScrollState == 0)
    {
      PagerTitleStrip localPagerTitleStrip = this.this$0;
      localPagerTitleStrip.updateText(localPagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
      float f2 = this.this$0.mLastKnownPositionOffset;
      float f1 = 0.0F;
      if (f2 >= 0.0F) {
        f1 = this.this$0.mLastKnownPositionOffset;
      }
      localPagerTitleStrip = this.this$0;
      localPagerTitleStrip.updateTextPositions(localPagerTitleStrip.mPager.getCurrentItem(), f1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip.PageListener
 * JD-Core Version:    0.7.0.1
 */