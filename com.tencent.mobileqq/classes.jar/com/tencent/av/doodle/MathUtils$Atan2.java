package com.tencent.av.doodle;

class MathUtils$Atan2
{
  static final float[] a = new float[16384];
  
  static
  {
    int i = 0;
    while (i < MathUtils.a)
    {
      int j = 0;
      while (j < MathUtils.a)
      {
        float f1 = i / MathUtils.a;
        float f2 = j / MathUtils.a;
        a[(MathUtils.a * j + i)] = ((float)Math.atan2(f2, f1));
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.MathUtils.Atan2
 * JD-Core Version:    0.7.0.1
 */