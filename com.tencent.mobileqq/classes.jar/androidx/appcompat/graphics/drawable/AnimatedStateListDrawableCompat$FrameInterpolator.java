package androidx.appcompat.graphics.drawable;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

class AnimatedStateListDrawableCompat$FrameInterpolator
  implements TimeInterpolator
{
  private int[] mFrameTimes;
  private int mFrames;
  private int mTotalDuration;
  
  AnimatedStateListDrawableCompat$FrameInterpolator(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    updateFrames(paramAnimationDrawable, paramBoolean);
  }
  
  public float getInterpolation(float paramFloat)
  {
    int j = (int)(paramFloat * this.mTotalDuration + 0.5F);
    int k = this.mFrames;
    int[] arrayOfInt = this.mFrameTimes;
    int i = 0;
    while ((i < k) && (j >= arrayOfInt[i]))
    {
      j -= arrayOfInt[i];
      i += 1;
    }
    if (i < k) {
      paramFloat = j / this.mTotalDuration;
    } else {
      paramFloat = 0.0F;
    }
    return i / k + paramFloat;
  }
  
  int getTotalDuration()
  {
    return this.mTotalDuration;
  }
  
  int updateFrames(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    int m = paramAnimationDrawable.getNumberOfFrames();
    this.mFrames = m;
    int[] arrayOfInt = this.mFrameTimes;
    if ((arrayOfInt == null) || (arrayOfInt.length < m)) {
      this.mFrameTimes = new int[m];
    }
    arrayOfInt = this.mFrameTimes;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      if (paramBoolean) {
        k = m - i - 1;
      } else {
        k = i;
      }
      int k = paramAnimationDrawable.getDuration(k);
      arrayOfInt[i] = k;
      j += k;
      i += 1;
    }
    this.mTotalDuration = j;
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.FrameInterpolator
 * JD-Core Version:    0.7.0.1
 */