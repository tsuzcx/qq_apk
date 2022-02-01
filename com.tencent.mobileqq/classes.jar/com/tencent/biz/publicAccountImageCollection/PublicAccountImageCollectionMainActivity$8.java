package com.tencent.biz.publicAccountImageCollection;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class PublicAccountImageCollectionMainActivity$8
  implements Animation.AnimationListener
{
  PublicAccountImageCollectionMainActivity$8(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131381047);
    ImageView localImageView = (ImageView)this.a.findViewById(2131381048);
    PublicAccountImageCollectionMainActivity.a(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity.8
 * JD-Core Version:    0.7.0.1
 */