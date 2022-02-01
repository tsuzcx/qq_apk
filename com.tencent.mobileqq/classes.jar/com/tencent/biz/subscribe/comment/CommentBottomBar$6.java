package com.tencent.biz.subscribe.comment;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class CommentBottomBar$6
  implements Animation.AnimationListener
{
  CommentBottomBar$6(CommentBottomBar paramCommentBottomBar, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.a) {
      CommentBottomBar.g(this.b);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar.6
 * JD-Core Version:    0.7.0.1
 */