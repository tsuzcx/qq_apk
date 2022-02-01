package com.hiar.sdk.utils;

import java.nio.FloatBuffer;

public class Drawable2d
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
  public static float[] a;
  private static final FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
  private static final float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_a_of_type_Int;
  private int jdField_b_of_type_Int = 2;
  private int jdField_c_of_type_Int;
  private FloatBuffer jdField_c_of_type_JavaNioFloatBuffer = jdField_a_of_type_JavaNioFloatBuffer;
  private int jdField_d_of_type_Int;
  private FloatBuffer jdField_d_of_type_JavaNioFloatBuffer = jdField_b_of_type_JavaNioFloatBuffer;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public Drawable2d()
  {
    int i = this.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = (i * 4);
    this.jdField_a_of_type_Int = (jdField_a_of_type_ArrayOfFloat.length / i);
    this.jdField_d_of_type_Int = 8;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public FloatBuffer a()
  {
    return this.jdField_c_of_type_JavaNioFloatBuffer;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public FloatBuffer b()
  {
    return this.jdField_d_of_type_JavaNioFloatBuffer;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.hiar.sdk.utils.Drawable2d
 * JD-Core Version:    0.7.0.1
 */