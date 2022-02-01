package com.tencent.avgame.gameroom.gamelist;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.tencent.qphone.base.util.QLog;
import nix;
import niy;

public class GameListRecyclerViewAdapter$1
  implements Runnable
{
  public GameListRecyclerViewAdapter$1(nix paramnix) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListRecyclerViewAdapter", 2, "startAnimation " + nix.a(this.this$0));
    }
    if (nix.a(this.this$0) != null)
    {
      AnimatorSet localAnimatorSet1 = new AnimatorSet();
      localAnimatorSet1.playTogether(new Animator[] { ObjectAnimator.ofFloat(nix.a(this.this$0), "scaleX", new float[] { 1.0F, 1.05F }), ObjectAnimator.ofFloat(nix.a(this.this$0), "scaleY", new float[] { 1.0F, 1.05F }) });
      localAnimatorSet1.setDuration(500L);
      AnimatorSet localAnimatorSet2 = new AnimatorSet();
      localAnimatorSet2.playTogether(new Animator[] { ObjectAnimator.ofFloat(nix.a(this.this$0), "scaleX", new float[] { 1.05F, 1.0F }), ObjectAnimator.ofFloat(nix.a(this.this$0), "scaleY", new float[] { 1.05F, 1.0F }) });
      localAnimatorSet2.setDuration(500L);
      nix.a(this.this$0, new AnimatorSet());
      nix.a(this.this$0).playSequentially(new Animator[] { localAnimatorSet1, localAnimatorSet2 });
      nix.a(this.this$0).addListener(new niy(this));
      nix.a(this.this$0).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListRecyclerViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */