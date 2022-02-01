package com.tencent.mobileqq.activity.aio.anim;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

public class MainEnterOutAni
  extends TranslateAnimation
{
  public int a = 0;
  
  public MainEnterOutAni()
  {
    this(1, 0.0F, 1, -1.0F, 1, 0.0F, 1, 0.0F);
  }
  
  public MainEnterOutAni(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4, float paramFloat4)
  {
    super(paramInt1, paramFloat1, paramInt2, paramFloat2, paramInt3, paramFloat3, paramInt4, paramFloat4);
  }
  
  public boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (!AIOEnterInAni.b) {
      setStartTime(paramLong);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.MainEnterOutAni
 * JD-Core Version:    0.7.0.1
 */