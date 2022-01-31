package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ViewSwitcher;

public class PttTipSwitchView
  extends ViewSwitcher
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private AnimationSet b;
  private AnimationSet c;
  private AnimationSet d;
  
  public PttTipSwitchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PttTipSwitchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = a(1.0F, 0.0F);
    this.b = a(0.0F, -1.0F);
    this.c = a(-1.0F, 0.0F);
    this.d = a(0.0F, 1.0F);
    setInAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    setOutAnimation(this.b);
  }
  
  public void a()
  {
    if (getInAnimation() != this.jdField_a_of_type_AndroidViewAnimationAnimationSet) {
      setInAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    }
    if (getOutAnimation() != this.b) {
      setOutAnimation(this.b);
    }
    showNext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PttTipSwitchView
 * JD-Core Version:    0.7.0.1
 */