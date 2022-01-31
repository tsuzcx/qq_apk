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
    float f4 = this.b;
    float f5 = this.a;
    float f1 = this.d;
    float f2 = this.c;
    float f3 = this.a;
    f4 = (f4 - f5) * (float)paramLong / (float)this.duration;
    f5 = this.c;
    paramGL10.glTranslatef(f4 + f3, (f1 - f2) * (float)paramLong / (float)this.duration + f5, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GLAnimTranslate
 * JD-Core Version:    0.7.0.1
 */