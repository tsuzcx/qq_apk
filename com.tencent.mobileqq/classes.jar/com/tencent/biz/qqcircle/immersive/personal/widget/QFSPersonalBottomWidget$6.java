package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.view.View;
import android.widget.RadioGroup;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.qqlive.module.videoreport.VideoReport;

class QFSPersonalBottomWidget$6
  extends ViewPager2.OnPageChangeCallback
{
  QFSPersonalBottomWidget$6(QFSPersonalBottomWidget paramQFSPersonalBottomWidget) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    super.onPageScrollStateChanged(paramInt);
    if (paramInt == 0) {
      VideoReport.traverseExposure();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((QFSPersonalBottomWidget.g(this.a) != null) && (QFSPersonalBottomWidget.g(this.a).getChildCount() > paramInt)) {
      QFSPersonalBottomWidget.g(this.a).getChildAt(paramInt).performClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.6
 * JD-Core Version:    0.7.0.1
 */