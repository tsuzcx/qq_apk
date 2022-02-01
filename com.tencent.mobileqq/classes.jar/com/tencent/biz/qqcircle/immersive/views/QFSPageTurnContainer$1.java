package com.tencent.biz.qqcircle.immersive.views;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.qphone.base.util.QLog;

class QFSPageTurnContainer$1
  extends ViewPager2.OnPageChangeCallback
{
  QFSPageTurnContainer$1(QFSPageTurnContainer paramQFSPageTurnContainer) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("  onPageScrollStateChanged  state = ");
    localStringBuilder.append(paramInt);
    QLog.d("FSPageTurnContainer", 1, localStringBuilder.toString());
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected  position = ");
    localStringBuilder.append(paramInt);
    QLog.d("FSPageTurnContainer", 1, localStringBuilder.toString());
    QFSPageTurnContainer.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.1
 * JD-Core Version:    0.7.0.1
 */