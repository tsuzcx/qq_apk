package com.tencent.map.core.functions.animation;

import javax.microedition.khronos.opengles.GL10;

public class GLAnimAlpha
  extends GLAnim
{
  private float a;
  private float b;
  
  public GLAnimAlpha(float paramFloat1, float paramFloat2, long paramLong)
  {
    super(paramLong);
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  protected void performDraw(GL10 paramGL10, long paramLong)
  {
    float f1 = this.b;
    float f2 = this.a;
    f1 = f2 + (f1 - f2) * (float)paramLong / (float)this.duration;
    paramGL10.glColor4f(f1, f1, f1, f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimAlpha
 * JD-Core Version:    0.7.0.1
 */