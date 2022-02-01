package com.tencent.biz.qqcircle.immersive.part;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.qqlive.module.videoreport.VideoReport;

class QFSLayerBasePart$2
  extends ViewPager2.OnPageChangeCallback
{
  QFSLayerBasePart$2(QFSLayerBasePart paramQFSLayerBasePart) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
    this.a.b.a(paramInt1, paramFloat, paramInt2);
    QFSMessageNoticePart.o();
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    this.a.a(paramInt);
    VideoReport.traverseExposure();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.2
 * JD-Core Version:    0.7.0.1
 */