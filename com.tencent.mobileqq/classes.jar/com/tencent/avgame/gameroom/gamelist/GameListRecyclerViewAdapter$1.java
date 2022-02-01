package com.tencent.avgame.gameroom.gamelist;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.tencent.qphone.base.util.QLog;

class GameListRecyclerViewAdapter$1
  implements Runnable
{
  GameListRecyclerViewAdapter$1(GameListRecyclerViewAdapter paramGameListRecyclerViewAdapter) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAnimation ");
      ((StringBuilder)localObject).append(GameListRecyclerViewAdapter.a(this.this$0));
      QLog.i("GameListRecyclerViewAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (GameListRecyclerViewAdapter.a(this.this$0) != null)
    {
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(new Animator[] { ObjectAnimator.ofFloat(GameListRecyclerViewAdapter.a(this.this$0), "scaleX", new float[] { 1.0F, 1.05F }), ObjectAnimator.ofFloat(GameListRecyclerViewAdapter.a(this.this$0), "scaleY", new float[] { 1.0F, 1.05F }) });
      ((AnimatorSet)localObject).setDuration(500L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(GameListRecyclerViewAdapter.a(this.this$0), "scaleX", new float[] { 1.05F, 1.0F }), ObjectAnimator.ofFloat(GameListRecyclerViewAdapter.a(this.this$0), "scaleY", new float[] { 1.05F, 1.0F }) });
      localAnimatorSet.setDuration(500L);
      GameListRecyclerViewAdapter.a(this.this$0, new AnimatorSet());
      GameListRecyclerViewAdapter.a(this.this$0).playSequentially(new Animator[] { localObject, localAnimatorSet });
      GameListRecyclerViewAdapter.a(this.this$0).addListener(new GameListRecyclerViewAdapter.1.1(this));
      GameListRecyclerViewAdapter.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */