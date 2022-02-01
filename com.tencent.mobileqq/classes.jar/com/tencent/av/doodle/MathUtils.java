package com.tencent.av.doodle;

import java.util.Random;

public final class MathUtils
{
  static final int a = (int)Math.sqrt(16384.0D);
  public static Random b = new Random();
  private static final float c = 1.0F / (a - 1);
  
  public static final float a()
  {
    return b.nextFloat();
  }
  
  public static final float a(float paramFloat)
  {
    return MathUtils.Sin.a[((int)(paramFloat * 45.511112F) & 0x3FFF)];
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
    return b.nextInt(paramInt + 1);
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
  
  public static final float b(float paramFloat)
  {
    return MathUtils.Sin.a[((int)((paramFloat + 90.0F) * 45.511112F) & 0x3FFF)];
  }
  
  public static final float c(float paramFloat)
  {
    return b.nextFloat() * paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.MathUtils
 * JD-Core Version:    0.7.0.1
 */