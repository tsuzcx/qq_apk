package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.animator;
import com.google.android.material.animation.MotionSpec;

class ExtendedFloatingActionButton$ChangeSizeStrategy
  extends BaseMotionStrategy
{
  private final ExtendedFloatingActionButton.Size jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size;
  private final boolean jdField_a_of_type_Boolean;
  
  ExtendedFloatingActionButton$ChangeSizeStrategy(ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker, ExtendedFloatingActionButton.Size paramSize, boolean paramBoolean)
  {
    super(paramExtendedFloatingActionButton, paramAnimatorTracker);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size = paramSize;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return R.animator.h;
    }
    return R.animator.g;
  }
  
  @NonNull
  public AnimatorSet a()
  {
    MotionSpec localMotionSpec = a();
    PropertyValuesHolder[] arrayOfPropertyValuesHolder;
    if (localMotionSpec.b("width"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.a("width");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.getWidth(), this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.a() });
      localMotionSpec.a("width", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.b("height"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.a("height");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.getHeight(), this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.b() });
      localMotionSpec.a("height", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.b("paddingStart"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.a("paddingStart");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { ViewCompat.getPaddingStart(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton), this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.c() });
      localMotionSpec.a("paddingStart", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.b("paddingEnd"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.a("paddingEnd");
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { ViewCompat.getPaddingEnd(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton), this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.d() });
      localMotionSpec.a("paddingEnd", arrayOfPropertyValuesHolder);
    }
    if (localMotionSpec.b("labelOpacity"))
    {
      arrayOfPropertyValuesHolder = localMotionSpec.a("labelOpacity");
      boolean bool = this.jdField_a_of_type_Boolean;
      float f2 = 0.0F;
      float f1;
      if (bool) {
        f1 = 0.0F;
      } else {
        f1 = 1.0F;
      }
      if (this.jdField_a_of_type_Boolean) {
        f2 = 1.0F;
      }
      arrayOfPropertyValuesHolder[0].setFloatValues(new float[] { f1, f2 });
      localMotionSpec.a("labelOpacity", arrayOfPropertyValuesHolder);
    }
    return super.a(localMotionSpec);
  }
  
  public void a()
  {
    super.a();
    ExtendedFloatingActionButton.b(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, false);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.setHorizontallyScrolling(false);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    localLayoutParams.width = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.a().width;
    localLayoutParams.height = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.a().height;
  }
  
  public void a(Animator paramAnimator)
  {
    super.a(paramAnimator);
    ExtendedFloatingActionButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, this.jdField_a_of_type_Boolean);
    ExtendedFloatingActionButton.b(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, true);
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.setHorizontallyScrolling(true);
  }
  
  public void a(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback)
  {
    if (paramOnChangedCallback == null) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramOnChangedCallback.c(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton);
      return;
    }
    paramOnChangedCallback.d(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean == ExtendedFloatingActionButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton)) || (this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.a() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.getText()));
  }
  
  public void c()
  {
    ExtendedFloatingActionButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, this.jdField_a_of_type_Boolean);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    localLayoutParams.width = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.a().width;
    localLayoutParams.height = this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.a().height;
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.c(), this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.getPaddingTop(), this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton$Size.d(), this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.getPaddingBottom());
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ChangeSizeStrategy
 * JD-Core Version:    0.7.0.1
 */