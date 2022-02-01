package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.QLog;

public class BaseTabbar$TabHolder
{
  public View a;
  public ImageView a;
  public TextView a;
  public RedDotTextView a;
  private boolean a;
  public ImageView b;
  public ImageView c;
  
  public BaseTabbar$TabHolder()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.addRule(1, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.getId());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.addRule(1, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.getId());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      a();
      return;
    }
    b();
  }
  
  private void b()
  {
    this.b.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.addRule(1, this.b.getId());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.addRule(1, this.b.getId());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView.setVisibility(8);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObjectAnimator1 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
      localObject = ObjectAnimator.ofFloat(this.b, "rotation", new float[] { 0.0F, 720.0F }).setDuration(800L);
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
      localObjectAnimator3.setStartDelay(700L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setInterpolator(new LinearInterpolator());
      localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      localAnimatorSet.play(localObjectAnimator2).before((Animator)localObject);
      localAnimatorSet.play((Animator)localObject).with(localObjectAnimator3);
      localAnimatorSet.addListener(new BaseTabbar.TabHolder.1(this, paramBoolean));
      localAnimatorSet.start();
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.b, "rotation", new float[] { -30.0F, 0.0F }).setDuration(500L);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(localObjectAnimator2).with(localObjectAnimator1);
    ((AnimatorSet)localObject).addListener(new BaseTabbar.TabHolder.2(this));
    ((AnimatorSet)localObject).start();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean1) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.d("TabBarView", 4, "setIsTextStyle isTextStyle:");
    }
    if (paramBoolean2)
    {
      b(paramBoolean1);
      return;
    }
    a(paramBoolean1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.TabHolder
 * JD-Core Version:    0.7.0.1
 */