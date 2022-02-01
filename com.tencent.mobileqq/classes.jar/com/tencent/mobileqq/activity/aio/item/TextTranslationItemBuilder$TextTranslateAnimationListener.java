package com.tencent.mobileqq.activity.aio.item;

import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

class TextTranslationItemBuilder$TextTranslateAnimationListener
  implements Animation.AnimationListener
{
  private CharSequence a;
  private TextTranslationItemBuilder.Holder b;
  private AlphaAnimation c;
  private AlphaAnimation d;
  
  TextTranslationItemBuilder$TextTranslateAnimationListener(CharSequence paramCharSequence, TextTranslationItemBuilder.Holder paramHolder, AlphaAnimation paramAlphaAnimation1, AlphaAnimation paramAlphaAnimation2)
  {
    this.a = paramCharSequence;
    this.b = paramHolder;
    this.c = paramAlphaAnimation1;
    this.d = paramAlphaAnimation2;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.b.v.setText(this.a);
    this.b.v.startAnimation(this.c);
    this.b.a.requestLayout();
    paramAnimation = this.b;
    paramAnimation.f = 0;
    paramAnimation = (RelativeLayout.LayoutParams)paramAnimation.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.b.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.b;
    paramAnimation.f = 0;
    paramAnimation.v.startAnimation(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.TextTranslateAnimationListener
 * JD-Core Version:    0.7.0.1
 */