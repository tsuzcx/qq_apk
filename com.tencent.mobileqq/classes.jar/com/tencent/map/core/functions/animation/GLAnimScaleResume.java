package com.tencent.map.core.functions.animation;

import javax.microedition.khronos.opengles.GL10;

public class GLAnimScaleResume
  extends GLAnimScale
{
  private long a;
  private long b;
  
  public GLAnimScaleResume(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong1, long paramLong2)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramLong1 + paramLong2);
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  protected void performDraw(GL10 paramGL10, long paramLong)
  {
    float f2 = this.mXScaleEnd - this.mXScaleStart;
    float f1 = this.mYScaleEnd - this.mYScaleStart;
    if (paramLong < this.a) {
      f2 = this.mXScaleStart + f2 * (float)paramLong / (float)this.a;
    }
    for (f1 = this.mYScaleStart + f1 * (float)paramLong / (float)this.a;; f1 = this.mYScaleEnd - f1 * (float)paramLong / (float)this.b)
    {
      paramGL10.glScalef(f2, f1, 1.0F);
      return;
      paramLong -= this.a;
      f2 = this.mXScaleEnd - f2 * (float)paramLong / (float)this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimScaleResume
 * JD-Core Version:    0.7.0.1
 */