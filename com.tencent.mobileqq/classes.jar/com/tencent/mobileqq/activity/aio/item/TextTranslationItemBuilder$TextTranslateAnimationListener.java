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
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private TextTranslationItemBuilder.Holder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private AlphaAnimation b;
  
  TextTranslationItemBuilder$TextTranslateAnimationListener(CharSequence paramCharSequence, TextTranslationItemBuilder.Holder paramHolder, AlphaAnimation paramAlphaAnimation1, AlphaAnimation paramAlphaAnimation2)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder = paramHolder;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = paramAlphaAnimation1;
    this.b = paramAlphaAnimation2;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.d.setText(this.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.d.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.a.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.h = 0;
    paramAnimation = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.a.getLayoutParams();
    paramAnimation.width = -2;
    paramAnimation.height = -2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.a.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.h = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder$Holder.d.startAnimation(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.TextTranslateAnimationListener
 * JD-Core Version:    0.7.0.1
 */