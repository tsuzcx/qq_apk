package com.tencent.biz.webviewplugin;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

class PubAccountUIPlugin$2
  implements Animation.AnimationListener
{
  PubAccountUIPlugin$2(PubAccountUIPlugin paramPubAccountUIPlugin, URLImageView paramURLImageView, URLDrawable paramURLDrawable, ScaleAnimation paramScaleAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setImageDrawable(this.b);
    this.a.startAnimation(this.c);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountUIPlugin.2
 * JD-Core Version:    0.7.0.1
 */