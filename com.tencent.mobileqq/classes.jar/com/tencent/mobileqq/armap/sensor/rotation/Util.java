package com.tencent.mobileqq.armap.sensor.rotation;

public class Util
{
  public static float a(double paramDouble)
  {
    return (float)(paramDouble - Math.floor(paramDouble / 360.0D) * 360.0D);
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    return (float)Math.asin(paramFloat1 / (paramFloat2 * 2.0F));
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d1 = paramFloat1 * paramFloat2 * paramFloat3;
    float f = paramFloat1 + paramFloat2;
    double d2 = Math.sqrt((f + paramFloat3) * (paramFloat1 - paramFloat2 + paramFloat3) * (f - paramFloat3) * (paramFloat2 + paramFloat3 - paramFloat1));
    Double.isNaN(d1);
    return (float)(d1 / d2);
  }
  
  public static float a(Vector3 paramVector31, Vector3 paramVector32)
  {
    return (float)Math.sqrt((paramVector31.x - paramVector32.x) * (paramVector31.x - paramVector32.x) + (paramVector31.y - paramVector32.y) * (paramVector31.y - paramVector32.y) + (paramVector31.z - paramVector32.z) * (paramVector31.z - paramVector32.z));
  }
  
  public static float b(float paramFloat1, float paramFloat2)
  {
    return (float)Math.asin(Math.min(1.0F, Math.max(-1.0F, paramFloat1 / (paramFloat2 * 2.0F))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.Util
 * JD-Core Version:    0.7.0.1
 */