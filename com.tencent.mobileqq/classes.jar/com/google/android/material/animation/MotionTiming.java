package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MotionTiming
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  @Nullable
  private TimeInterpolator jdField_a_of_type_AndroidAnimationTimeInterpolator = null;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = 300L;
  
  public MotionTiming(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public MotionTiming(long paramLong1, long paramLong2, @NonNull TimeInterpolator paramTimeInterpolator)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_AndroidAnimationTimeInterpolator = paramTimeInterpolator;
  }
  
  private static TimeInterpolator a(@NonNull ValueAnimator paramValueAnimator)
  {
    TimeInterpolator localTimeInterpolator = paramValueAnimator.getInterpolator();
    if ((!(localTimeInterpolator instanceof AccelerateDecelerateInterpolator)) && (localTimeInterpolator != null))
    {
      if ((localTimeInterpolator instanceof AccelerateInterpolator)) {
        return AnimationUtils.c;
      }
      paramValueAnimator = localTimeInterpolator;
      if ((localTimeInterpolator instanceof DecelerateInterpolator)) {
        paramValueAnimator = AnimationUtils.d;
      }
      return paramValueAnimator;
    }
    return AnimationUtils.b;
  }
  
  @NonNull
  static MotionTiming a(@NonNull ValueAnimator paramValueAnimator)
  {
    MotionTiming localMotionTiming = new MotionTiming(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), a(paramValueAnimator));
    localMotionTiming.jdField_a_of_type_Int = paramValueAnimator.getRepeatCount();
    localMotionTiming.jdField_b_of_type_Int = paramValueAnimator.getRepeatMode();
    return localMotionTiming;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public TimeInterpolator a()
  {
    TimeInterpolator localTimeInterpolator = this.jdField_a_of_type_AndroidAnimationTimeInterpolator;
    if (localTimeInterpolator != null) {
      return localTimeInterpolator;
    }
    return AnimationUtils.b;
  }
  
  public void a(@NonNull Animator paramAnimator)
  {
    paramAnimator.setStartDelay(a());
    paramAnimator.setDuration(b());
    paramAnimator.setInterpolator(a());
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = (ValueAnimator)paramAnimator;
      paramAnimator.setRepeatCount(a());
      paramAnimator.setRepeatMode(b());
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MotionTiming)) {
      return false;
    }
    paramObject = (MotionTiming)paramObject;
    if (a() != paramObject.a()) {
      return false;
    }
    if (b() != paramObject.b()) {
      return false;
    }
    if (a() != paramObject.a()) {
      return false;
    }
    if (b() != paramObject.b()) {
      return false;
    }
    return a().getClass().equals(paramObject.a().getClass());
  }
  
  public int hashCode()
  {
    return ((((int)(a() ^ a() >>> 32) * 31 + (int)(b() ^ b() >>> 32)) * 31 + a().getClass().hashCode()) * 31 + a()) * 31 + b();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" delay: ");
    localStringBuilder.append(a());
    localStringBuilder.append(" duration: ");
    localStringBuilder.append(b());
    localStringBuilder.append(" interpolator: ");
    localStringBuilder.append(a().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(a());
    localStringBuilder.append(" repeatMode: ");
    localStringBuilder.append(b());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.animation.MotionTiming
 * JD-Core Version:    0.7.0.1
 */