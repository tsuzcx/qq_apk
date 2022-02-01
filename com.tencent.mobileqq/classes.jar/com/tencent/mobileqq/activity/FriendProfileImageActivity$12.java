package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class FriendProfileImageActivity$12
  implements Animation.AnimationListener
{
  FriendProfileImageActivity$12(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.j.execute(new Void[0]);
    paramAnimation = this.a;
    paramAnimation.D = false;
    if (paramAnimation.w)
    {
      this.a.u.setVisibility(8);
      return;
    }
    if (!this.a.v) {
      this.a.u.setVisibility(0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.12
 * JD-Core Version:    0.7.0.1
 */