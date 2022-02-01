package com.tencent.biz.qqcircle.comment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class QCircleCommentBottomBar$1
  implements Animation.AnimationListener
{
  QCircleCommentBottomBar$1(QCircleCommentBottomBar paramQCircleCommentBottomBar) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QCircleCommentBottomBar.a(this.a) != null) {
      QCircleCommentBottomBar.a(this.a).startAnimation(QCircleCommentBottomBar.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar.1
 * JD-Core Version:    0.7.0.1
 */