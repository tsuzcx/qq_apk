package com.tencent.biz.webviewplugin;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.image.URLImageView;

class PubAccountUIPlugin$5
  implements Animation.AnimationListener
{
  PubAccountUIPlugin$5(PubAccountUIPlugin paramPubAccountUIPlugin, URLImageView paramURLImageView, ScaleAnimation paramScaleAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.startAnimation(this.b);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountUIPlugin.5
 * JD-Core Version:    0.7.0.1
 */