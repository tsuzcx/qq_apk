package com.nineoldandroids.animation;

public class ArgbEvaluator
  implements TypeEvaluator
{
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    int m = ((Integer)paramObject1).intValue();
    int i = m >> 24;
    int j = m >> 16 & 0xFF;
    int k = m >> 8 & 0xFF;
    m &= 0xFF;
    int n = ((Integer)paramObject2).intValue();
    int i1 = (int)(((n >> 24) - i) * paramFloat);
    int i2 = (int)(((n >> 16 & 0xFF) - j) * paramFloat);
    int i3 = (int)(((n >> 8 & 0xFF) - k) * paramFloat);
    return Integer.valueOf(m + (int)(((n & 0xFF) - m) * paramFloat) | i + i1 << 24 | j + i2 << 16 | i3 + k << 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.nineoldandroids.animation.ArgbEvaluator
 * JD-Core Version:    0.7.0.1
 */