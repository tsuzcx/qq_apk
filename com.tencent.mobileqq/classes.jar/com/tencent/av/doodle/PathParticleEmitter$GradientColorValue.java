package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$GradientColorValue
  extends PathParticleEmitter.ParticleValue
{
  private static float[] d = new float[4];
  float[] a = { 0.0F };
  private float[] e = { 1.0F, 1.0F, 1.0F };
  
  public PathParticleEmitter$GradientColorValue()
  {
    this.c = true;
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.b) {
      return;
    }
    this.e = new float[PathParticleEmitter.c(paramBufferedReader, "colorsCount")];
    int j = 0;
    int i = 0;
    float[] arrayOfFloat;
    StringBuilder localStringBuilder;
    for (;;)
    {
      arrayOfFloat = this.e;
      if (i >= arrayOfFloat.length) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("colors");
      localStringBuilder.append(i);
      arrayOfFloat[i] = PathParticleEmitter.d(paramBufferedReader, localStringBuilder.toString());
      i += 1;
    }
    this.a = new float[PathParticleEmitter.c(paramBufferedReader, "timelineCount")];
    i = j;
    for (;;)
    {
      arrayOfFloat = this.a;
      if (i >= arrayOfFloat.length) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("timeline");
      localStringBuilder.append(i);
      arrayOfFloat[i] = PathParticleEmitter.d(paramBufferedReader, localStringBuilder.toString());
      i += 1;
    }
  }
  
  public float[] a(float paramFloat)
  {
    float[] arrayOfFloat2 = this.a;
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
    float[] arrayOfFloat1 = this.e;
    float f1 = arrayOfFloat1[j];
    float f2 = arrayOfFloat1[(j + 1)];
    float f3 = arrayOfFloat1[(j + 2)];
    if (i == -1)
    {
      arrayOfFloat1 = d;
      arrayOfFloat1[0] = f1;
      arrayOfFloat1[1] = f2;
      arrayOfFloat1[2] = f3;
      return arrayOfFloat1;
    }
    paramFloat = (paramFloat - f4) / (arrayOfFloat2[i] - f4);
    i *= 3;
    arrayOfFloat2 = d;
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