package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import anni;
import ypz;

public class NewMessageYellowBar
  extends FrameLayout
{
  protected int a;
  protected AlphaAnimation a;
  protected AnimationSet a;
  protected TranslateAnimation a;
  public TextView a;
  
  public NewMessageYellowBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
    a(paramContext, null);
  }
  
  public NewMessageYellowBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
    a(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      if (paramInt2 > this.jdField_a_of_type_Int) {}
    }
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt2;
      if (paramInt1 > 0)
      {
        setVisibility(0);
        post(new NewMessageYellowBar.2(this, paramInt1));
        return;
      }
      setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131706291));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.0F);
    } while (this.jdField_a_of_type_AndroidViewAnimationAnimationSet.hasEnded());
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(getContext()).inflate(2131561891, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381373));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setStartOffset(1000L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(3000L);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new ypz(this));
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar
 * JD-Core Version:    0.7.0.1
 */