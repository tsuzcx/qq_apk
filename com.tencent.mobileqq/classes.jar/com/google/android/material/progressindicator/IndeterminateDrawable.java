package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec>
  extends DrawableWithAnimatedVisibilityChange
{
  private DrawingDelegate<S> jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate;
  private IndeterminateAnimatorDelegate<ObjectAnimator> jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate;
  
  IndeterminateDrawable(@NonNull Context paramContext, @NonNull BaseProgressIndicatorSpec paramBaseProgressIndicatorSpec, @NonNull DrawingDelegate<S> paramDrawingDelegate, @NonNull IndeterminateAnimatorDelegate<ObjectAnimator> paramIndeterminateAnimatorDelegate)
  {
    super(paramContext, paramBaseProgressIndicatorSpec);
    a(paramDrawingDelegate);
    a(paramIndeterminateAnimatorDelegate);
  }
  
  @NonNull
  public static IndeterminateDrawable<CircularProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    return new IndeterminateDrawable(paramContext, paramCircularProgressIndicatorSpec, new CircularDrawingDelegate(paramCircularProgressIndicatorSpec), new CircularIndeterminateAnimatorDelegate(paramCircularProgressIndicatorSpec));
  }
  
  @NonNull
  public static IndeterminateDrawable<LinearProgressIndicatorSpec> a(@NonNull Context paramContext, @NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    LinearDrawingDelegate localLinearDrawingDelegate = new LinearDrawingDelegate(paramLinearProgressIndicatorSpec);
    Object localObject;
    if (paramLinearProgressIndicatorSpec.f == 0) {
      localObject = new LinearIndeterminateContiguousAnimatorDelegate(paramLinearProgressIndicatorSpec);
    } else {
      localObject = new LinearIndeterminateDisjointAnimatorDelegate(paramContext, paramLinearProgressIndicatorSpec);
    }
    return new IndeterminateDrawable(paramContext, paramLinearProgressIndicatorSpec, localLinearDrawingDelegate, (IndeterminateAnimatorDelegate)localObject);
  }
  
  @NonNull
  DrawingDelegate<S> a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate;
  }
  
  @NonNull
  IndeterminateAnimatorDelegate<ObjectAnimator> a()
  {
    return this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate;
  }
  
  void a(@NonNull DrawingDelegate<S> paramDrawingDelegate)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate = paramDrawingDelegate;
    paramDrawingDelegate.a(this);
  }
  
  void a(@NonNull IndeterminateAnimatorDelegate<ObjectAnimator> paramIndeterminateAnimatorDelegate)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate = paramIndeterminateAnimatorDelegate;
    paramIndeterminateAnimatorDelegate.a(this);
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramBoolean2 = super.a(paramBoolean1, paramBoolean2, paramBoolean3);
    if (!isRunning()) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate.b();
    }
    float f = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorAnimatorDurationScaleProvider.a(this.jdField_a_of_type_AndroidContentContext.getContentResolver());
    if ((paramBoolean1) && ((paramBoolean3) || ((Build.VERSION.SDK_INT <= 21) && (f > 0.0F)))) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate.a();
    }
    return paramBoolean2;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = new Rect();
    if ((!getBounds().isEmpty()) && (isVisible()))
    {
      if (!paramCanvas.getClipBounds((Rect)localObject)) {
        return;
      }
      paramCanvas.save();
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate.b(paramCanvas, a());
      this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
      int i = 0;
      while (i < this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawingDelegate;
        Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
        float[] arrayOfFloat = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate.jdField_a_of_type_ArrayOfFloat;
        int j = i * 2;
        ((DrawingDelegate)localObject).a(paramCanvas, localPaint, arrayOfFloat[j], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate.jdField_a_of_type_ArrayOfFloat[(j + 1)], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateAnimatorDelegate.jdField_a_of_type_ArrayOfInt[i]);
        i += 1;
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.IndeterminateDrawable
 * JD-Core Version:    0.7.0.1
 */