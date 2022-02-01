package com.tencent.av.opengl.ui;

public class Scroller
{
  private static float jdField_a_of_type_Float = (float)(Math.log(0.75D) / Math.log(0.9D));
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static float b = 800.0F;
  private static float c = 0.4F;
  private static float d = 1.0F - c;
  private static float e;
  private static float f = 1.0F / a(1.0F);
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[101];
    float f2 = 0.0F;
    int i = 0;
    if (i <= 100)
    {
      float f4 = i / 100.0F;
      float f1 = 1.0F;
      for (;;)
      {
        float f3 = (f1 - f2) / 2.0F + f2;
        float f7 = 1.0F - f3;
        float f5 = 3.0F * f3 * f7;
        float f8 = c;
        float f9 = d;
        float f6 = f3 * f3 * f3;
        f7 = (f7 * f8 + f9 * f3) * f5 + f6;
        if (Math.abs(f7 - f4) < 1.E-005D)
        {
          jdField_a_of_type_ArrayOfFloat[i] = (f5 + f6);
          i += 1;
          break;
        }
        if (f7 > f4) {
          f1 = f3;
        } else {
          f2 = f3;
        }
      }
    }
    jdField_a_of_type_ArrayOfFloat[100] = 1.0F;
    e = 8.0F;
    f = 1.0F;
  }
  
  static float a(float paramFloat)
  {
    paramFloat *= e;
    if (paramFloat < 1.0F) {
      paramFloat -= 1.0F - (float)Math.exp(-paramFloat);
    } else {
      paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.6321206F + 0.3678795F;
    }
    return paramFloat * f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.Scroller
 * JD-Core Version:    0.7.0.1
 */