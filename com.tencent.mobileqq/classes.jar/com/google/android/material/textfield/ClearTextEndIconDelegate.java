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
  private final TextWatcher d = new ClearTextEndIconDelegate.1(this);
  private final View.OnFocusChangeListener e = new ClearTextEndIconDelegate.2(this);
  private final TextInputLayout.OnEditTextAttachedListener f = new ClearTextEndIconDelegate.3(this);
  private final TextInputLayout.OnEndIconChangedListener g = new ClearTextEndIconDelegate.4(this);
  private AnimatorSet h;
  private ValueAnimator i;
  
  ClearTextEndIconDelegate(@NonNull TextInputLayout paramTextInputLayout)
  {
    super(paramTextInputLayout);
  }
  
  private ValueAnimator a(float... paramVarArgs)
  {
    paramVarArgs = ValueAnimator.ofFloat(paramVarArgs);
    paramVarArgs.setInterpolator(AnimationUtils.a);
    paramVarArgs.setDuration(100L);
    paramVarArgs.addUpdateListener(new ClearTextEndIconDelegate.8(this));
    return paramVarArgs;
  }
  
  private void b(boolean paramBoolean)
  {
    int j;
    if (this.a.g() == paramBoolean) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramBoolean) && (!this.h.isRunning()))
    {
      this.i.cancel();
      this.h.start();
      if (j != 0) {
        this.h.end();
      }
    }
    else if (!paramBoolean)
    {
      this.h.cancel();
      this.i.start();
      if (j != 0) {
        this.i.end();
      }
    }
  }
  
  private static boolean b(@NonNull Editable paramEditable)
  {
    return paramEditable.length() > 0;
  }
  
  private void c()
  {
    ValueAnimator localValueAnimator1 = d();
    ValueAnimator localValueAnimator2 = a(new float[] { 0.0F, 1.0F });
    this.h = new AnimatorSet();
    this.h.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.h.addListener(new ClearTextEndIconDelegate.6(this));
    this.i = a(new float[] { 1.0F, 0.0F });
    this.i.addListener(new ClearTextEndIconDelegate.7(this));
  }
  
  private ValueAnimator d()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.8F, 1.0F });
    localValueAnimator.setInterpolator(AnimationUtils.d);
    localValueAnimator.setDuration(150L);
    localValueAnimator.addUpdateListener(new ClearTextEndIconDelegate.9(this));
    return localValueAnimator;
  }
  
  void a()
  {
    this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.g));
    this.a.setEndIconContentDescription(this.a.getResources().getText(R.string.e));
    this.a.setEndIconOnClickListener(new ClearTextEndIconDelegate.5(this));
    this.a.a(this.f);
    this.a.a(this.g);
    c();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.a.getSuffixText() == null) {
      return;
    }
    b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.ClearTextEndIconDelegate
 * JD-Core Version:    0.7.0.1
 */