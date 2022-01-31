package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.ad.tangram.log.AdLog;
import java.util.ArrayList;

class b$1
  implements ViewPager.OnPageChangeListener
{
  b$1(b paramb) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      b.access$802(this.this$0, true);
      return;
    }
    if (paramInt == 0)
    {
      b.access$102(System.currentTimeMillis());
      AdLog.i("AdCanvasImagesCarouselComponentView", "onPageScrollStateChanged: mCurrentPosition=" + b.access$700(this.this$0));
      b.access$900(this.this$0).setCurrentItem(b.access$700(this.this$0), false);
    }
    b.access$802(this.this$0, false);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i = this.this$0.OFF_SCREEN_PAGE_LIMIT;
    int j = this.this$0.OFF_SCREEN_PAGE_LIMIT;
    int k = b.access$600(this.this$0).imageList.size();
    b.access$702(this.this$0, paramInt);
    if (paramInt < i) {
      b.access$702(this.this$0, b.access$600(this.this$0).imageList.size() + paramInt);
    }
    for (;;)
    {
      AdLog.i("AdCanvasImagesCarouselComponentView", "onPageSelected: mCurrentPosition=" + b.access$700(this.this$0) + " index=" + paramInt);
      return;
      if (paramInt >= j + k) {
        b.access$702(this.this$0, paramInt - b.access$600(this.this$0).imageList.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.b.1
 * JD-Core Version:    0.7.0.1
 */