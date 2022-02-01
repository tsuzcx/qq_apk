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
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.c = new float[PathParticleEmitter.a(paramBufferedReader, "colorsCount")];
    int j = 0;
    int i = 0;
    float[] arrayOfFloat;
    StringBuilder localStringBuilder;
    for (;;)
    {
      arrayOfFloat = this.c;
      if (i >= arrayOfFloat.length) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("colors");
      localStringBuilder.append(i);
      arrayOfFloat[i] = PathParticleEmitter.a(paramBufferedReader, localStringBuilder.toString());
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfFloat = new float[PathParticleEmitter.a(paramBufferedReader, "timelineCount")];
    i = j;
    for (;;)
    {
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      if (i >= arrayOfFloat.length) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeline");
      localStringBuilder.append(i);
      arrayOfFloat[i] = PathParticleEmitter.a(paramBufferedReader, localStringBuilder.toString());
      i += 1;
    }
  }
  
  public float[] a(float paramFloat)
  {
    float[] arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    int k = arrayOfFloat2.length;
    int i = 1;
    int j = 0;
    while (i < k)
    {
      if (arrayOfFloat2[i] > paramFloat) {
        break label53;
      }
      j = i;
      i += 1;
    }
    i = -1;
    label53:
    float f4 = arrayOfFloat2[j];
    j *= 3;
    float[] arrayOfFloat1 = this.c;
    float f1 = arrayOfFloat1[j];
    float f2 = arrayOfFloat1[(j + 1)];
    float f3 = arrayOfFloat1[(j + 2)];
    if (i == -1)
    {
      arrayOfFloat1 = jdField_b_of_type_ArrayOfFloat;
      arrayOfFloat1[0] = f1;
      arrayOfFloat1[1] = f2;
      arrayOfFloat1[2] = f3;
      return arrayOfFloat1;
    }
    paramFloat = (paramFloat - f4) / (arrayOfFloat2[i] - f4);
    i *= 3;
    arrayOfFloat2 = jdField_b_of_type_ArrayOfFloat;
    arrayOfFloat2[0] = (f1 + (arrayOfFloat1[i] - f1) * paramFloat);
    arrayOfFloat2[1] = (f2 + (arrayOfFloat1[(i + 1)] - f2) * paramFloat);
    arrayOfFloat2[2] = (f3 + (arrayOfFloat1[(i + 2)] - f3) * paramFloat);
    return arrayOfFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.GradientColorValue
 * JD-Core Version:    0.7.0.1
 */