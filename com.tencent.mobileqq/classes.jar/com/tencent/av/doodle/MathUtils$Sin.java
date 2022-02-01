package com.tencent.av.doodle;

class MathUtils$Sin
{
  static final float[] a = new float[16384];
  
  static
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 16384) {
        break;
      }
      a[i] = ((float)Math.sin((i + 0.5F) / 16384.0F * 6.283186F));
      i += 1;
    }
    while (j < 360)
    {
      float[] arrayOfFloat = a;
      float f = j;
      arrayOfFloat[((int)(45.511112F * f) & 0x3FFF)] = ((float)Math.sin(f * 0.01745329F));
      j += 90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.MathUtils.Sin
 * JD-Core Version:    0.7.0.1
 */