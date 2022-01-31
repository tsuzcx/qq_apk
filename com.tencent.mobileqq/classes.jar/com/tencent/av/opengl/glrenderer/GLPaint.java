package com.tencent.av.opengl.glrenderer;

import junit.framework.Assert;

public class GLPaint
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat >= 0.0F) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.jdField_a_of_type_Float = paramFloat;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.glrenderer.GLPaint
 * JD-Core Version:    0.7.0.1
 */