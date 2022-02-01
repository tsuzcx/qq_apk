package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ViewSwitcher;

public class PttTipSwitchView
  extends ViewSwitcher
{
  private Context a;
  private AnimationSet b;
  private AnimationSet c;
  private AnimationSet d;
  private AnimationSet e;
  
  public PttTipSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PttTipSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  private AnimationSet a(float paramFloat1, float paramFloat2)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, paramFloat1, 2, paramFloat2);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setFillAfter(false);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    localAnimationSet.addAnimation(localTranslateAnimation);
    return localAnimationSet;
  }
  
  private void b()
  {
    this.b = a(1.0F, 0.0F);
    this.c = a(0.0F, -1.0F);
    this.d = a(-1.0F, 0.0F);
    this.e = a(0.0F, 1.0F);
    setInAnimation(this.b);
    setOutAnimation(this.c);
  }
  
  public void a()
  {
    Animation localAnimation = getInAnimation();
    AnimationSet localAnimationSet = this.b;
    if (localAnimation != localAnimationSet) {
      setInAnimation(localAnimationSet);
    }
    localAnimation = getOutAnimation();
    localAnimationSet = this.c;
    if (localAnimation != localAnimationSet) {
      setOutAnimation(localAnimationSet);
    }
    showNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PttTipSwitchView
 * JD-Core Version:    0.7.0.1
 */