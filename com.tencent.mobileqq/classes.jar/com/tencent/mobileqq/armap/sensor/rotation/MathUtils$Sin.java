package com.tencent.mobileqq.armap.sensor.rotation;

class MathUtils$Sin
{
  static final float[] a = new float[8192];
  
  static
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 8192) {
        break;
      }
      a[i] = ((float)Math.sin((i + 0.5F) / 8192.0F * 6.283186F));
      i += 1;
    }
    while (j < 360)
    {
      float[] arrayOfFloat = a;
      float f = j;
      arrayOfFloat[((int)(22.755556F * f) & 0x1FFF)] = ((float)Math.sin(f * 0.01745329F));
      j += 90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.MathUtils.Sin
 * JD-Core Version:    0.7.0.1
 */