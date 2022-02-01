package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class DrawableWithAnimatedVisibilityChange
  extends Drawable
  implements Animatable2Compat
{
  private static final Property<DrawableWithAnimatedVisibilityChange, Float> jdField_a_of_type_AndroidUtilProperty = new DrawableWithAnimatedVisibilityChange.3(Float.class, "growFraction");
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  final Context jdField_a_of_type_AndroidContentContext;
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Animatable2Compat.AnimationCallback jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback;
  AnimatorDurationScaleProvider jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider;
  final BaseProgressIndicatorSpec jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec;
  private List<Animatable2Compat.AnimationCallback> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  DrawableWithAnimatedVisibilityChange(@NonNull Context paramContext, @NonNull BaseProgressIndicatorSpec paramBaseProgressIndicatorSpec)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec = paramBaseProgressIndicatorSpec;
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider = new AnimatorDurationScaleProvider();
    setAlpha(255);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofFloat(this, jdField_a_of_type_AndroidUtilProperty, new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(AnimationUtils.b);
      a(this.jdField_a_of_type_AndroidAnimationValueAnimator);
    }
    if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofFloat(this, jdField_a_of_type_AndroidUtilProperty, new float[] { 1.0F, 0.0F });
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(500L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(AnimationUtils.b);
      b(this.jdField_b_of_type_AndroidAnimationValueAnimator);
    }
  }
  
  private void a(@NonNull ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = paramValueAnimator;
    paramValueAnimator.addListener(new DrawableWithAnimatedVisibilityChange.1(this));
  }
  
  private void a(@NonNull ValueAnimator... paramVarArgs)
  {
    boolean bool = this.c;
    this.c = true;
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].end();
      i += 1;
    }
    this.c = bool;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback;
    if (localObject != null) {
      ((Animatable2Compat.AnimationCallback)localObject).onAnimationStart(this);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!this.c))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Animatable2Compat.AnimationCallback)((Iterator)localObject).next()).onAnimationStart(this);
      }
    }
  }
  
  private void b(@NonNull ValueAnimator paramValueAnimator)
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }
    this.jdField_b_of_type_AndroidAnimationValueAnimator = paramValueAnimator;
    paramValueAnimator.addListener(new DrawableWithAnimatedVisibilityChange.2(this));
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback;
    if (localObject != null) {
      ((Animatable2Compat.AnimationCallback)localObject).onAnimationEnd(this);
    }
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!this.c))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Animatable2Compat.AnimationCallback)((Iterator)localObject).next()).onAnimationEnd(this);
      }
    }
  }
  
  float a()
  {
    if ((!this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.a()) && (!this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.b())) {
      return 1.0F;
    }
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      return this.jdField_b_of_type_Float;
    }
    return this.jdField_a_of_type_Float;
  }
  
  public boolean a()
  {
    return b(false, false, false);
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a();
    if ((!isVisible()) && (!paramBoolean1)) {
      return false;
    }
    ValueAnimator localValueAnimator;
    if (paramBoolean1) {
      localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    } else {
      localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    }
    if (!paramBoolean3)
    {
      if (localValueAnimator.isRunning()) {
        localValueAnimator.end();
      } else {
        a(new ValueAnimator[] { localValueAnimator });
      }
      return super.setVisible(paramBoolean1, false);
    }
    if ((paramBoolean3) && (localValueAnimator.isRunning())) {
      return false;
    }
    if ((paramBoolean1) && (!super.setVisible(paramBoolean1, false))) {
      paramBoolean3 = false;
    } else {
      paramBoolean3 = true;
    }
    if (paramBoolean1) {
      paramBoolean1 = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.a();
    } else {
      paramBoolean1 = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.b();
    }
    if (!paramBoolean1)
    {
      a(new ValueAnimator[] { localValueAnimator });
      return paramBoolean3;
    }
    if ((!paramBoolean2) && (Build.VERSION.SDK_INT >= 19) && (localValueAnimator.isPaused()))
    {
      localValueAnimator.resume();
      return paramBoolean3;
    }
    localValueAnimator.start();
    return paramBoolean3;
  }
  
  void b(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.jdField_b_of_type_Float != paramFloat)
    {
      this.jdField_b_of_type_Float = paramFloat;
      invalidateSelf();
    }
  }
  
  public boolean b()
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    return ((localValueAnimator != null) && (localValueAnimator.isRunning())) || (this.jdField_b_of_type_Boolean);
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    float f = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider.a(this.jdField_a_of_type_AndroidContentContext.getContentResolver());
    if ((paramBoolean3) && (f > 0.0F)) {
      paramBoolean3 = true;
    } else {
      paramBoolean3 = false;
    }
    return a(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public boolean c()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    return ((localValueAnimator != null) && (localValueAnimator.isRunning())) || (this.jdField_a_of_type_Boolean);
  }
  
  public void clearAnimationCallbacks()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public int getAlpha()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isRunning()
  {
    return (c()) || (b());
  }
  
  public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramAnimationCallback)) {
      this.jdField_a_of_type_JavaUtilList.add(paramAnimationCallback);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    return b(paramBoolean1, paramBoolean2, true);
  }
  
  public void start()
  {
    a(true, true, false);
  }
  
  public void stop()
  {
    a(false, true, false);
  }
  
  public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.contains(paramAnimationCallback)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramAnimationCallback);
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        this.jdField_a_of_type_JavaUtilList = null;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
 * JD-Core Version:    0.7.0.1
 */