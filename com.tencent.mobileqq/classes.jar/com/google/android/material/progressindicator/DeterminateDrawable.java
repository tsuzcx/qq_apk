package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.color.MaterialColors;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec>
  extends DrawableWithAnimatedVisibilityChange
{
  private static final FloatPropertyCompat<DeterminateDrawable> jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat = new DeterminateDrawable.1("indicatorLevel");
  private float jdField_a_of_type_Float;
  private final SpringAnimation jdField_a_of_type_AndroidxDynamicanimationAnimationSpringAnimation;
  private final SpringForce jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce;
  private DrawingDelegate<S> jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate;
  private boolean jdField_a_of_type_Boolean = false;
  
  DeterminateDrawable(@NonNull Context paramContext, @NonNull BaseProgressIndicatorSpec paramBaseProgressIndicatorSpec, @NonNull DrawingDelegate<S> paramDrawingDelegate)
  {
    super(paramContext, paramBaseProgressIndicatorSpec);
    a(paramDrawingDelegate);
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce = new SpringForce();
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.setDampingRatio(1.0F);
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.setStiffness(50.0F);
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringAnimation = new SpringAnimation(this, jdField_a_of_type_AndroidxDynamicanimationAnimationFloatPropertyCompat);
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringAnimation.setSpring(this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce);
    b(1.0F);
  }
  
  @NonNull
  public static DeterminateDrawable<CircularProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    return new DeterminateDrawable(paramContext, paramCircularProgressIndicatorSpec, new CircularDrawingDelegate(paramCircularProgressIndicatorSpec));
  }
  
  @NonNull
  public static DeterminateDrawable<LinearProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    return new DeterminateDrawable(paramContext, paramLinearProgressIndicatorSpec, new LinearDrawingDelegate(paramLinearProgressIndicatorSpec));
  }
  
  private float b()
  {
    return this.jdField_a_of_type_Float;
  }
  
  private void c(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    invalidateSelf();
  }
  
  @NonNull
  DrawingDelegate<S> a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate;
  }
  
  void a(float paramFloat)
  {
    setLevel((int)(paramFloat * 10000.0F));
  }
  
  void a(@NonNull DrawingDelegate<S> paramDrawingDelegate)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate = paramDrawingDelegate;
    paramDrawingDelegate.a(this);
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean1 = super.a(paramBoolean1, paramBoolean2, paramBoolean3);
    float f = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider.a(this.jdField_a_of_type_AndroidContentContext.getContentResolver());
    if (f == 0.0F)
    {
      this.jdField_a_of_type_Boolean = true;
      return paramBoolean1;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringForce.setStiffness(50.0F / f);
    return paramBoolean1;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    if ((!getBounds().isEmpty()) && (isVisible()))
    {
      if (!paramCanvas.getClipBounds(localRect)) {
        return;
      }
      paramCanvas.save();
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate.b(paramCanvas, a());
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      int i = MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.a[0], getAlpha());
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, 0.0F, b(), i);
      paramCanvas.restore();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate.b();
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate.a();
  }
  
  public void jumpToCurrentState()
  {
    this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringAnimation.cancel();
    c(getLevel() / 10000.0F);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringAnimation.cancel();
      c(paramInt / 10000.0F);
    }
    else
    {
      this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringAnimation.setStartValue(b() * 10000.0F);
      this.jdField_a_of_type_AndroidxDynamicanimationAnimationSpringAnimation.animateToFinalPosition(paramInt);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.DeterminateDrawable
 * JD-Core Version:    0.7.0.1
 */