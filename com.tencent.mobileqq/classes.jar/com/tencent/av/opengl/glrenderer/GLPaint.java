package com.tencent.av.opengl.glrenderer;

import com.tencent.util.Assert;

public class GLPaint
{
  private float a = 1.0F;
  private int b = 0;
  
  public int a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    boolean bool;
    if (paramFloat >= 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.a(bool);
    this.a = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public float b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.glrenderer.GLPaint
 * JD-Core Version:    0.7.0.1
 */