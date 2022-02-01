package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnFocusChangeListener;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R.drawable;
import com.google.android.material.R.string;
import com.google.android.material.animation.AnimationUtils;

class ClearTextEndIconDelegate
  extends EndIconDelegate
{
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private final TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new ClearTextEndIconDelegate.1(this);
  private final View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new ClearTextEndIconDelegate.2(this);
  private final TextInputLayout.OnEditTextAttachedListener jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEditTextAttachedListener = new ClearTextEndIconDelegate.3(this);
  private final TextInputLayout.OnEndIconChangedListener jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEndIconChangedListener = new ClearTextEndIconDelegate.4(this);
  
  ClearTextEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.8F, 1.0F });
    localValueAnimator.setInterpolator(AnimationUtils.d);
    localValueAnimator.setDuration(150L);
    localValueAnimator.addUpdateListener(new ClearTextEndIconDelegate.9(this));
    return localValueAnimator;
  }
  
  private ValueAnimator a(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.a);
    paramVarArgs.setDuration(100L);
    paramVarArgs.addUpdateListener(new ClearTextEndIconDelegate.8(this));
    return paramVarArgs;
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator1 = a();
    ValueAnimator localValueAnimator2 = a(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ClearTextEndIconDelegate.6(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator = a(new float[] { 1.0F, 0.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new ClearTextEndIconDelegate.7(this));
  }
  
  private void b(boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.d() == paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramBoolean) && (!this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      if (i != 0) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      }
    }
    else if (!paramBoolean)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      if (i != 0) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
      }
    }
  }
  
  private static boolean b(@NonNull Editable paramEditable)
  {
    return paramEditable.length() > 0;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.jdField_a_of_type_AndroidContentContext, R.drawable.g));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconContentDescription(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.getResources().getText(R.string.e));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.setEndIconOnClickListener(new ClearTextEndIconDelegate.5(this));
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEditTextAttachedListener);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout$OnEndIconChangedListener);
    b();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.c() == null) {
      return;
    }
    b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */