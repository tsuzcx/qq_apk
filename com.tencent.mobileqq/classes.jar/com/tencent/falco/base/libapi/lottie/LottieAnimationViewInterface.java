package com.tencent.falco.base.libapi.lottie;

import android.animation.Animator.AnimatorListener;

public abstract interface LottieAnimationViewInterface
{
  public abstract void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener);
  
  public abstract void cancelAnimation();
  
  public abstract boolean isAnimating();
  
  public abstract void playAnimation();
  
  public abstract void setAnimation(String paramString);
  
  public abstract void setComposition(LottieCompositionInterface paramLottieCompositionInterface);
  
  public abstract void setImageAssetDelegate(LiveLottieApi.ImageAssetDelegate paramImageAssetDelegate);
  
  public abstract void setRepeatCount(int paramInt);
  
  public abstract void setRepeatMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.lottie.LottieAnimationViewInterface
 * JD-Core Version:    0.7.0.1
 */