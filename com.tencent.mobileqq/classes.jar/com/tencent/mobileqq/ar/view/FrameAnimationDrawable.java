package com.tencent.mobileqq.ar.view;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class FrameAnimationDrawable
  implements Animatable
{
  private int jdField_a_of_type_Int;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
  private ValueAnimator.AnimatorUpdateListener jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt;
  private int b;
  
  public FrameAnimationDrawable(int paramInt1, int[] paramArrayOfInt, ImageView paramImageView, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    if (paramArrayOfInt.length > 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramArrayOfInt[paramInt2]);
      this.jdField_a_of_type_Int = paramInt2;
      this.b = paramInt2;
      a();
      return;
    }
    throw new RuntimeException(" FrameAnimDrawable RES_IDS can not empty !!!");
  }
  
  public FrameAnimationDrawable(int[] paramArrayOfInt, ImageView paramImageView, int paramInt)
  {
    this(0, paramArrayOfInt, paramImageView, paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ArrayOfInt.length - 1 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener = new FrameAnimationDrawable.1(this);
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new FrameAnimationDrawable.2(this);
  }
  
  private void b(Animator.AnimatorListener paramAnimatorListener)
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener);
    if (paramAnimatorListener != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(paramAnimatorListener);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      paramInt %= this.jdField_a_of_type_ArrayOfInt.length;
    }
    else
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      paramInt = arrayOfInt.length - paramInt % arrayOfInt.length - 1;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(this.jdField_a_of_type_ArrayOfInt[paramInt]);
  }
  
  public void a(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isStarted()) {
      return;
    }
    b(paramAnimatorListener);
  }
  
  public void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    stop();
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      this.b = (this.jdField_a_of_type_ArrayOfInt.length - 1);
    } else {
      this.b = 0;
    }
    a(paramAnimatorListener);
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning();
  }
  
  public void start()
  {
    b(null);
  }
  
  public void stop()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isStarted())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.end();
    }
    localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_Int = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.FrameAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */