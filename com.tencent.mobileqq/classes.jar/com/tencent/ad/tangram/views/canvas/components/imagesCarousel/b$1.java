package com.tencent.ad.tangram.views.canvas.components.imagesCarousel;

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
      b.access$202(this.this$0, true);
      return;
    }
    if (paramInt == 0)
    {
      b.access$302(this.this$0, System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrollStateChanged: mCurrentPosition=");
      localStringBuilder.append(b.access$100(this.this$0));
      AdLog.i("AdCanvasImagesCarouselComponentView", localStringBuilder.toString());
      b.access$400(this.this$0).setCurrentItem(b.access$100(this.this$0), false);
    }
    b.access$202(this.this$0, false);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int i = b.access$000(this.this$0).pageLimit;
    int j = b.access$000(this.this$0).pageLimit;
    int k = b.access$000(this.this$0).imageList.size();
    b.access$102(this.this$0, paramInt);
    if (paramInt < i)
    {
      localObject = this.this$0;
      b.access$102((b)localObject, b.access$000((b)localObject).imageList.size() + paramInt);
    }
    else if (paramInt >= j + k)
    {
      localObject = this.this$0;
      b.access$102((b)localObject, paramInt - b.access$000((b)localObject).imageList.size());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPageSelected: mCurrentPosition=");
    ((StringBuilder)localObject).append(b.access$100(this.this$0));
    ((StringBuilder)localObject).append(" index=");
    ((StringBuilder)localObject).append(paramInt);
    AdLog.i("AdCanvasImagesCarouselComponentView", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.imagesCarousel.b.1
 * JD-Core Version:    0.7.0.1
 */