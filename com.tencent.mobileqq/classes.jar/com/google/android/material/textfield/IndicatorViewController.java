package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @Nullable
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  @Nullable
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NonNull
  private final TextInputLayout jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout;
  @Nullable
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @Nullable
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  @Nullable
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  @Nullable
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private int d;
  private int e;
  
  public IndicatorViewController(@NonNull TextInputLayout paramTextInputLayout)
  {
    this.jdField_a_of_type_AndroidContentContext = paramTextInputLayout.getContext();
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout = paramTextInputLayout;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(R.dimen.s);
  }
  
  private int a(boolean paramBoolean, @DimenRes int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      paramInt2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(paramInt1);
    }
    return paramInt2;
  }
  
  private ObjectAnimator a(TextView paramTextView)
  {
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.jdField_a_of_type_Float, 0.0F });
    paramTextView.setDuration(217L);
    paramTextView.setInterpolator(AnimationUtils.d);
    return paramTextView;
  }
  
  private ObjectAnimator a(TextView paramTextView, boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    paramTextView = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f });
    paramTextView.setDuration(167L);
    paramTextView.setInterpolator(AnimationUtils.a);
    return paramTextView;
  }
  
  @Nullable
  private TextView a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return null;
      }
      return this.jdField_b_of_type_AndroidWidgetTextView;
    }
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    TextView localTextView;
    if (paramInt2 != 0)
    {
      localTextView = a(paramInt2);
      if (localTextView != null)
      {
        localTextView.setVisibility(0);
        localTextView.setAlpha(1.0F);
      }
    }
    if (paramInt1 != 0)
    {
      localTextView = a(paramInt1);
      if (localTextView != null)
      {
        localTextView.setVisibility(4);
        if (paramInt1 == 1) {
          localTextView.setText(null);
        }
      }
    }
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramBoolean)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimator = localAnimatorSet;
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_AndroidWidgetTextView, 2, paramInt1, paramInt2);
      a(localArrayList, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidWidgetTextView, 1, paramInt1, paramInt2);
      AnimatorSetCompat.a(localAnimatorSet, localArrayList);
      localAnimatorSet.addListener(new IndicatorViewController.1(this, paramInt2, a(paramInt1), paramInt1, a(paramInt2)));
      localAnimatorSet.start();
    }
    else
    {
      a(paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(paramBoolean);
    this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.e();
  }
  
  private void a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void a(@Nullable TextView paramTextView, Typeface paramTypeface)
  {
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
  }
  
  private void a(@NonNull List<Animator> paramList, boolean paramBoolean, @Nullable TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView != null)
    {
      if (!paramBoolean) {
        return;
      }
      if ((paramInt1 == paramInt3) || (paramInt1 == paramInt2))
      {
        if (paramInt3 == paramInt1) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramList.add(a(paramTextView, paramBoolean));
        if (paramInt3 == paramInt1) {
          paramList.add(a(paramTextView));
        }
      }
    }
  }
  
  private boolean a(@Nullable TextView paramTextView, @Nullable CharSequence paramCharSequence)
  {
    return (ViewCompat.isLaidOut(this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout)) && (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.isEnabled()) && ((this.jdField_c_of_type_Int != this.jdField_b_of_type_Int) || (paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence)));
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 1) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence));
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a() != null);
  }
  
  @ColorInt
  int a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
  
  @Nullable
  ColorStateList a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      return localTextView.getTextColors();
    }
    return null;
  }
  
  @Nullable
  CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  void a()
  {
    c();
    if (this.jdField_b_of_type_Int == 2) {
      this.jdField_c_of_type_Int = 0;
    }
    a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, a(this.jdField_b_of_type_AndroidWidgetTextView, null));
  }
  
  void a(@StyleRes int paramInt)
  {
    this.d = paramInt;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a(localTextView, paramInt);
    }
  }
  
  void a(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (paramColorStateList != null)) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void a(Typeface paramTypeface)
  {
    if (paramTypeface != this.jdField_a_of_type_AndroidGraphicsTypeface)
    {
      this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramTypeface);
      a(this.jdField_b_of_type_AndroidWidgetTextView, paramTypeface);
    }
  }
  
  void a(TextView paramTextView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout == null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, -2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, localLayoutParams);
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a() != null) {
        d();
      }
    }
    if (a(paramInt))
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramTextView);
    }
    else
    {
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramTextView, localLayoutParams);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Int += 1;
  }
  
  void a(CharSequence paramCharSequence)
  {
    c();
    this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    if (this.jdField_b_of_type_Int != 2) {
      this.jdField_c_of_type_Int = 2;
    }
    a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, a(this.jdField_b_of_type_AndroidWidgetTextView, paramCharSequence));
  }
  
  void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    c();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = new AppCompatTextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(R.id.ag);
      if (Build.VERSION.SDK_INT >= 17) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextAlignment(5);
      }
      Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
      if (localTypeface != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(localTypeface);
      }
      a(this.d);
      a(this.jdField_a_of_type_AndroidContentResColorStateList);
      c(this.jdField_b_of_type_JavaLangCharSequence);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.jdField_a_of_type_AndroidWidgetTextView, 1);
      a(this.jdField_a_of_type_AndroidWidgetTextView, 0);
    }
    else
    {
      b();
      b(this.jdField_a_of_type_AndroidWidgetTextView, 0);
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.e();
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  CharSequence b()
  {
    return this.jdField_c_of_type_JavaLangCharSequence;
  }
  
  void b()
  {
    this.jdField_a_of_type_JavaLangCharSequence = null;
    c();
    if (this.jdField_b_of_type_Int == 1) {
      if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence))) {
        this.jdField_c_of_type_Int = 2;
      } else {
        this.jdField_c_of_type_Int = 0;
      }
    }
    a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, a(this.jdField_a_of_type_AndroidWidgetTextView, null));
  }
  
  void b(@StyleRes int paramInt)
  {
    this.e = paramInt;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      TextViewCompat.setTextAppearance(localTextView, paramInt);
    }
  }
  
  void b(@Nullable ColorStateList paramColorStateList)
  {
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localTextView != null) && (paramColorStateList != null)) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  void b(TextView paramTextView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    if (a(paramInt))
    {
      FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if (localFrameLayout != null)
      {
        localFrameLayout.removeView(paramTextView);
        break label41;
      }
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramTextView);
    label41:
    this.jdField_a_of_type_Int -= 1;
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_Int);
  }
  
  void b(CharSequence paramCharSequence)
  {
    c();
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    if (this.jdField_b_of_type_Int != 1) {
      this.jdField_c_of_type_Int = 1;
    }
    a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, a(this.jdField_a_of_type_AndroidWidgetTextView, paramCharSequence));
  }
  
  void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean == paramBoolean) {
      return;
    }
    c();
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView = new AppCompatTextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetTextView.setId(R.id.ah);
      if (Build.VERSION.SDK_INT >= 17) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextAlignment(5);
      }
      Typeface localTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
      if (localTypeface != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(localTypeface);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      ViewCompat.setAccessibilityLiveRegion(this.jdField_b_of_type_AndroidWidgetTextView, 1);
      b(this.e);
      b(this.jdField_b_of_type_AndroidContentResColorStateList);
      a(this.jdField_b_of_type_AndroidWidgetTextView, 1);
    }
    else
    {
      a();
      b(this.jdField_b_of_type_AndroidWidgetTextView, 1);
      this.jdField_b_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
      this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.e();
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  void c()
  {
    Animator localAnimator = this.jdField_a_of_type_AndroidAnimationAnimator;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  void c(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setContentDescription(paramCharSequence);
    }
  }
  
  boolean c()
  {
    return b(this.jdField_c_of_type_Int);
  }
  
  void d()
  {
    if (d())
    {
      EditText localEditText = this.jdField_a_of_type_ComGoogleAndroidMaterialTextfieldTextInputLayout.a();
      boolean bool = MaterialResources.a(this.jdField_a_of_type_AndroidContentContext);
      ViewCompat.setPaddingRelative(this.jdField_a_of_type_AndroidWidgetLinearLayout, a(bool, R.dimen.D, ViewCompat.getPaddingStart(localEditText)), a(bool, R.dimen.E, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(R.dimen.C)), a(bool, R.dimen.D, ViewCompat.getPaddingEnd(localEditText)), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.IndicatorViewController
 * JD-Core Version:    0.7.0.1
 */