package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class PublicAccountImageCollectionMainActivityImpl$8
  implements Animation.AnimationListener
{
  PublicAccountImageCollectionMainActivityImpl$8(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (ImageView)this.a.findViewById(2131380312);
    ImageView localImageView = (ImageView)this.a.findViewById(2131380313);
    PublicAccountImageCollectionMainActivityImpl.access$2100(this.a, localImageView, paramAnimation, 100L, 240L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.8
 * JD-Core Version:    0.7.0.1
 */