package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$GradientColorValue
  extends PathParticleEmitter.ParticleValue
{
  private static float[] b;
  float[] a;
  private float[] c = { 1.0F, 1.0F, 1.0F };
  
  static
  {
    jdField_b_of_type_ArrayOfFloat = new float[4];
  }
  
  public PathParticleEmitter$GradientColorValue()
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F };
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    int j = 0;
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.c = new float[PathParticleEmitter.a(paramBufferedReader, "colorsCount")];
      int i = 0;
      while (i < this.c.length)
      {
        this.c[i] = PathParticleEmitter.a(paramBufferedReader, "colors" + i);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfFloat = new float[PathParticleEmitter.a(paramBufferedReader, "timelineCount")];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfFloat.length)
      {
        this.jdField_a_of_type_ArrayOfFloat[i] = PathParticleEmitter.a(paramBufferedReader, "timeline" + i);
        i += 1;
      }
    }
  }
  
  public float[] a(float paramFloat)
  {
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    int k = arrayOfFloat.length;
    int i = 1;
    int j = 0;
    if (i < k) {
      if (arrayOfFloat[i] <= paramFloat) {}
    }
    for (;;)
    {
      float f4 = arrayOfFloat[j];
      j *= 3;
      float f1 = this.c[j];
      float f2 = this.c[(j + 1)];
      float f3 = this.c[(j + 2)];
      if (i == -1)
      {
        jdField_b_of_type_ArrayOfFloat[0] = f1;
        jdField_b_of_type_ArrayOfFloat[1] = f2;
        jdField_b_of_type_ArrayOfFloat[2] = f3;
        return jdField_b_of_type_ArrayOfFloat;
        j = i;
        i += 1;
        break;
      }
      paramFloat = (paramFloat - f4) / (arrayOfFloat[i] - f4);
      i *= 3;
      jdField_b_of_type_ArrayOfFloat[0] = ((this.c[i] - f1) * paramFloat + f1);
      jdField_b_of_type_ArrayOfFloat[1] = ((this.c[(i + 1)] - f2) * paramFloat + f2);
      jdField_b_of_type_ArrayOfFloat[2] = ((this.c[(i + 2)] - f3) * paramFloat + f3);
      return jdField_b_of_type_ArrayOfFloat;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.GradientColorValue
 * JD-Core Version:    0.7.0.1
 */