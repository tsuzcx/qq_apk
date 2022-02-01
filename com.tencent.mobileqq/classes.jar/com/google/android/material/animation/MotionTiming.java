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
  private long a = 0L;
  private long b = 300L;
  @Nullable
  private TimeInterpolator c = null;
  private int d = 0;
  private int e = 1;
  
  public MotionTiming(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public MotionTiming(long paramLong1, long paramLong2, @NonNull TimeInterpolator paramTimeInterpolator)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramTimeInterpolator;
  }
  
  @NonNull
  static MotionTiming a(@NonNull ValueAnimator paramValueAnimator)
  {
    MotionTiming localMotionTiming = new MotionTiming(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), b(paramValueAnimator));
    localMotionTiming.d = paramValueAnimator.getRepeatCount();
    localMotionTiming.e = paramValueAnimator.getRepeatMode();
    return localMotionTiming;
  }
  
  private static TimeInterpolator b(@NonNull ValueAnimator paramValueAnimator)
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
  
  public long a()
  {
    return this.a;
  }
  
  public void a(@NonNull Animator paramAnimator)
  {
    paramAnimator.setStartDelay(a());
    paramAnimator.setDuration(b());
    paramAnimator.setInterpolator(c());
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = (ValueAnimator)paramAnimator;
      paramAnimator.setRepeatCount(d());
      paramAnimator.setRepeatMode(e());
    }
  }
  
  public long b()
  {
    return this.b;
  }
  
  @Nullable
  public TimeInterpolator c()
  {
    TimeInterpolator localTimeInterpolator = this.c;
    if (localTimeInterpolator != null) {
      return localTimeInterpolator;
    }
    return AnimationUtils.b;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
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
    if (d() != paramObject.d()) {
      return false;
    }
    if (e() != paramObject.e()) {
      return false;
    }
    return c().getClass().equals(paramObject.c().getClass());
  }
  
  public int hashCode()
  {
    return ((((int)(a() ^ a() >>> 32) * 31 + (int)(b() ^ b() >>> 32)) * 31 + c().getClass().hashCode()) * 31 + d()) * 31 + e();
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
    localStringBuilder.append(c().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(d());
    localStringBuilder.append(" repeatMode: ");
    localStringBuilder.append(e());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.animation.MotionTiming
 * JD-Core Version:    0.7.0.1
 */