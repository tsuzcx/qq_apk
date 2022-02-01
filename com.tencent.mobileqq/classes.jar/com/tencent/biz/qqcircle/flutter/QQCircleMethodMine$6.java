package com.tencent.biz.qqcircle.flutter;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView.IAnimationEndHandler;

final class QQCircleMethodMine$6
  implements QCircleDoublePraiseView.IAnimationEndHandler
{
  QQCircleMethodMine$6(ViewGroup paramViewGroup) {}
  
  public void a(View paramView)
  {
    if (this.a.indexOfChild(paramView) != -1) {
      this.a.removeView(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodMine.6
 * JD-Core Version:    0.7.0.1
 */