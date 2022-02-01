package com.tencent.avgame.gameroom.gamelist;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;

class GameListRecyclerViewAdapter$1$1
  implements Animator.AnimatorListener
{
  GameListRecyclerViewAdapter$1$1(GameListRecyclerViewAdapter.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (GameListRecyclerViewAdapter.a(this.a.this$0) != null) {
      GameListRecyclerViewAdapter.a(this.a.this$0).start();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */