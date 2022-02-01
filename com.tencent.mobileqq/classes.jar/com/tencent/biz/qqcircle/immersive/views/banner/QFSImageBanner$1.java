package com.tencent.biz.qqcircle.immersive.views.banner;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import java.util.Iterator;
import java.util.List;

class QFSImageBanner$1
  extends ViewPager2.OnPageChangeCallback
{
  private boolean b;
  
  QFSImageBanner$1(QFSImageBanner paramQFSImageBanner) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Iterator localIterator = QFSImageBanner.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager2.OnPageChangeCallback)localIterator.next()).onPageScrollStateChanged(paramInt);
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt == 0)
      {
        this.b = false;
        if (!QFSImageBanner.b(this.a).c()) {
          return;
        }
        if (QFSImageBanner.c(this.a) == this.a.getRealCount()) {
          QFSImageBanner.b(this.a, 0);
        }
      }
      return;
    }
    this.b = true;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    paramInt1 = this.a.a(paramInt1);
    Iterator localIterator = QFSImageBanner.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager2.OnPageChangeCallback)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QFSImageBanner.a(this.a, paramInt);
    if (!this.b) {
      return;
    }
    int i = this.a.a(paramInt);
    Iterator localIterator = QFSImageBanner.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((ViewPager2.OnPageChangeCallback)localIterator.next()).onPageSelected(i);
    }
    QFSImageBanner.a(this.a, String.valueOf(paramInt + 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.1
 * JD-Core Version:    0.7.0.1
 */