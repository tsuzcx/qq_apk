package com.tencent.biz.qqstory.playvideo.player;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import xte;
import xtf;

public class ExploreAnimalView
  extends RelativeLayout
{
  protected AnimatorSet a;
  public AlphaAnimation a;
  protected TranslateAnimation a;
  public LinearLayout a;
  public EllipsizingTextView a;
  public TranslateAnimation b;
  
  public ExploreAnimalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExploreAnimalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    RelativeLayout.inflate(getContext(), 2131561914, this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131374676));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)super.findViewById(2131380980));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    if (this.b != null) {
      this.b.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.b = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.b.setDuration(300L);
    this.b.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new xte(this));
    this.b.setAnimationListener(new xtf(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  @TargetApi(11)
  public void a(View paramView, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
      paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView.setDuration(1200L);
      paramView.setRepeatCount(-1);
      paramView.setRepeatMode(-1);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(paramView);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.setStartDelay(paramLong);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    paramView.setVisibility(0);
  }
  
  @TargetApi(11)
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.b != null)
    {
      this.b.cancel();
      this.b = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = null;
    }
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null))
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
  }
  
  public void setText(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      a();
    }
    while (paramInt != 4) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView
 * JD-Core Version:    0.7.0.1
 */