package com.tencent.avgame.gameroom.gamelist;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class GameListRecyclerViewAdapter$1$1
  extends D8SafeAnimatorListener
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */