package com.tencent.av.opengl.glrenderer;

import com.tencent.util.Assert;

public class GLPaint
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 0;
  
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
    boolean bool;
    if (paramFloat >= 0.0F) {
      bool = true;
    } else {
      bool = false;
    }
    Assert.a(bool);
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.glrenderer.GLPaint
 * JD-Core Version:    0.7.0.1
 */