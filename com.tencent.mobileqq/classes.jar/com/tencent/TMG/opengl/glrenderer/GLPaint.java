package com.tencent.TMG.opengl.glrenderer;

import junit.framework.Assert;

public class GLPaint
{
  private int mColor = 0;
  private float mLineWidth = 1.0F;
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public float getLineWidth()
  {
    return this.mLineWidth;
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public void setLineWidth(float paramFloat)
  {
    boolean bool;
    if (paramFloat >= 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.assertTrue(bool);
    this.mLineWidth = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLPaint
 * JD-Core Version:    0.7.0.1
 */