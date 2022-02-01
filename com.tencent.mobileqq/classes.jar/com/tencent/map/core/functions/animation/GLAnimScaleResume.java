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
    float f1 = this.mXScaleEnd - this.mXScaleStart;
    float f2 = this.mYScaleEnd - this.mYScaleStart;
    long l = this.a;
    float f4;
    float f3;
    if (paramLong < l)
    {
      f4 = this.mXScaleStart;
      f3 = (float)paramLong;
      f1 = f4 + f1 * f3 / (float)this.a;
      f2 = this.mYScaleStart + f2 * f3 / (float)this.a;
    }
    else
    {
      f4 = this.mXScaleEnd;
      f3 = (float)(paramLong - l);
      f1 = f4 - f1 * f3 / (float)this.b;
      f2 = this.mYScaleEnd - f2 * f3 / (float)this.b;
    }
    paramGL10.glScalef(f1, f2, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimScaleResume
 * JD-Core Version:    0.7.0.1
 */