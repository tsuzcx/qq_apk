package com.tencent.biz.qqcircle.fragments.person;

import android.view.View;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

class QCirclePersonalBottomView$4
  implements ViewPager.OnPageChangeListener
{
  QCirclePersonalBottomView$4(QCirclePersonalBottomView paramQCirclePersonalBottomView) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if ((QCirclePersonalBottomView.g(this.a) != null) && (QCirclePersonalBottomView.g(this.a).getChildCount() > paramInt)) {
      QCirclePersonalBottomView.g(this.a).getChildAt(paramInt).performClick();
    }
    if (paramInt == 1)
    {
      QCirclePersonalBottomView.a(this.a, 20, 1);
      return;
    }
    if (paramInt == 2) {
      QCirclePersonalBottomView.a(this.a, 21, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.4
 * JD-Core Version:    0.7.0.1
 */