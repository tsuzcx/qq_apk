package com.tencent.mobileqq.activity.aio.anim;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

public class AIOEnterInAni
  extends TranslateAnimation
{
  public static volatile boolean b;
  public int a = 0;
  
  public AIOEnterInAni()
  {
    this(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
  }
  
  public AIOEnterInAni(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    super(paramInt1, paramFloat1, paramInt2, paramFloat2, paramInt3, paramFloat3, paramInt4, paramFloat4);
    b = false;
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    this.a += 1;
    if ((!b) && (this.a <= 2))
    {
      setStartTime(paramLong);
      if (this.a == 2) {
        b = true;
      }
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
  
  public void reset()
  {
    this.a = 0;
    b = false;
    super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AIOEnterInAni
 * JD-Core Version:    0.7.0.1
 */