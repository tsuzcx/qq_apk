package com.tencent.map.core.functions.animation;

import javax.microedition.khronos.opengles.GL10;

public class GLAnimTranslate
  extends GLAnim
{
  private float a;
  private float b;
  private float c;
  private float d;
  
  public GLAnimTranslate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong)
  {
    super(paramLong);
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
  }
  
  protected void performDraw(GL10 paramGL10, long paramLong)
  {
    float f1 = this.b;
    float f2 = this.a;
    float f3 = this.d;
    float f4 = this.c;
    float f5 = (float)paramLong;
    paramGL10.glTranslatef(f2 + (f1 - f2) * f5 / (float)this.duration, this.c + (f3 - f4) * f5 / (float)this.duration, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimTranslate
 * JD-Core Version:    0.7.0.1
 */