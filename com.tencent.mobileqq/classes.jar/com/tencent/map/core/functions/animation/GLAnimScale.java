package com.tencent.map.core.functions.animation;

import javax.microedition.khronos.opengles.GL10;

public class GLAnimScale
  extends GLAnim
{
  protected float mXScaleEnd;
  protected float mXScaleStart;
  protected float mYScaleEnd;
  protected float mYScaleStart;
  
  public GLAnimScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramLong);
    this.mXScaleStart = paramFloat1;
    this.mXScaleEnd = paramFloat2;
    this.mYScaleStart = paramFloat3;
    this.mYScaleEnd = paramFloat4;
  }
  
  protected void performDraw(GL10 paramGL10, long paramLong)
  {
    float f1 = this.mXScaleEnd;
    float f2 = this.mXScaleStart;
    float f3 = this.mYScaleEnd;
    float f4 = this.mYScaleStart;
    float f5 = (float)paramLong;
    paramGL10.glScalef(f2 + (f1 - f2) * f5 / (float)this.duration, this.mYScaleStart + (f3 - f4) * f5 / (float)this.duration, 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimScale
 * JD-Core Version:    0.7.0.1
 */