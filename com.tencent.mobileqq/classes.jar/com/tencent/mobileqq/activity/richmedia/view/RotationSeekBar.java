package com.tencent.mobileqq.activity.richmedia.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SeekBar;

public class RotationSeekBar
  extends SeekBar
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = null;
  private ValueAnimator b;
  
  public RotationSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RotationSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private float a()
  {
    if (jdField_a_of_type_Float == -1.0F) {
      jdField_a_of_type_Float = getContext().getResources().getDisplayMetrics().density;
    }
    return jdField_a_of_type_Float;
  }
  
  private int a(float paramFloat)
  {
    a();
    return Math.round(paramFloat * jdField_a_of_type_Float);
  }
  
  void a() {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.b;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ArrayOfFloat != null)
    {
      int j = getMeasuredWidth();
      int i = getMeasuredHeight();
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167394));
      }
      int k = a(2.0F);
      int m = i / 2;
      float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      int n = arrayOfFloat.length;
      i = 0;
      while (i < n)
      {
        float f = arrayOfFloat[i];
        if ((f > 0.0F) && (f < 1.0F))
        {
          paramCanvas.save();
          paramCanvas.translate(f * j, m);
          paramCanvas.drawCircle(0.0F, 0.0F, k, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.restore();
        }
        i += 1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setAnimateEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        super.setProgress(paramInt);
        return;
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { getProgress(), paramInt });
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
        this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new RotationSeekBar.1(this));
      }
      else
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { getProgress(), paramInt });
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    finally {}
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        super.setSecondaryProgress(paramInt);
        return;
      }
      if (this.b != null) {
        this.b.cancel();
      }
      if (this.b == null)
      {
        this.b = ValueAnimator.ofInt(new int[] { getProgress(), paramInt });
        this.b.setInterpolator(jdField_a_of_type_AndroidViewAnimationInterpolator);
        this.b.addUpdateListener(new RotationSeekBar.2(this));
      }
      else
      {
        this.b.setIntValues(new int[] { getProgress(), paramInt });
      }
      this.b.start();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar
 * JD-Core Version:    0.7.0.1
 */