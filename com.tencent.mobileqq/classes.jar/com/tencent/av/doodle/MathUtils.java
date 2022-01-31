package com.tencent.av.doodle;

import java.util.Random;

public final class MathUtils
{
  private static final float jdField_a_of_type_Float;
  static final int jdField_a_of_type_Int = (int)Math.sqrt(16384.0D);
  public static Random a;
  
  static
  {
    jdField_a_of_type_Float = 1.0F / (jdField_a_of_type_Int - 1);
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static final float a()
  {
    return jdField_a_of_type_JavaUtilRandom.nextFloat();
  }
  
  public static final float a(float paramFloat)
  {
    return jjs.a[((int)(45.511112F * paramFloat) & 0x3FFF)];
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  public static final int a(int paramInt)
  {
    return jdField_a_of_type_JavaUtilRandom.nextInt(paramInt + 1);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  public static final boolean a()
  {
    return jdField_a_of_type_JavaUtilRandom.nextBoolean();
  }
  
  public static final float b(float paramFloat)
  {
    return jjs.a[((int)((90.0F + paramFloat) * 45.511112F) & 0x3FFF)];
  }
  
  public static final float c(float paramFloat)
  {
    return jdField_a_of_type_JavaUtilRandom.nextFloat() * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.doodle.MathUtils
 * JD-Core Version:    0.7.0.1
 */