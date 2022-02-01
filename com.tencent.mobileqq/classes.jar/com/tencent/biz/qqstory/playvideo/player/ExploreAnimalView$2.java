package com.tencent.biz.qqstory.playvideo.player;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;

class ExploreAnimalView$2
  implements Animation.AnimationListener
{
  ExploreAnimalView$2(ExploreAnimalView paramExploreAnimalView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.f = new AlphaAnimation(0.5F, 1.0F);
    this.a.f.setDuration(600L);
    this.a.f.setRepeatCount(-1);
    this.a.f.setRepeatMode(2);
    this.a.b.startAnimation(this.a.f);
    paramAnimation = (ImageView)this.a.findViewById(2131432067);
    ImageView localImageView1 = (ImageView)this.a.findViewById(2131432068);
    ImageView localImageView2 = (ImageView)this.a.findViewById(2131428774);
    this.a.a(paramAnimation, 100L);
    this.a.a(localImageView1, 240L);
    this.a.a(localImageView2, 360L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView.2
 * JD-Core Version:    0.7.0.1
 */