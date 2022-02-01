package com.tencent.biz.qqcircle.comment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QCircleBaseInputPopupWindow$3
  implements Animation.AnimationListener
{
  QCircleBaseInputPopupWindow$3(QCircleBaseInputPopupWindow paramQCircleBaseInputPopupWindow) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.a != null) {
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.3
 * JD-Core Version:    0.7.0.1
 */