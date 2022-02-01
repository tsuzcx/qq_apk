package com.tencent.mobileqq.armap.sensor.rotation;

import java.util.Random;

public class MathUtils
{
  public static Random a = new Random();
  
  public static final float a(float paramFloat)
  {
    return MathUtils.Sin.a[((int)(paramFloat * 1303.7972F) & 0x1FFF)];
  }
  
  public static final float b(float paramFloat)
  {
    return MathUtils.Cos.a[((int)(paramFloat * 1303.7972F) & 0x1FFF)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.MathUtils
 * JD-Core Version:    0.7.0.1
 */