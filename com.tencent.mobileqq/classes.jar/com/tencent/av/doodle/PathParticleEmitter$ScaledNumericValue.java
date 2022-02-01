package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$ScaledNumericValue
  extends PathParticleEmitter.RangedNumericValue
{
  float[] a = { 0.0F };
  private float[] d = { 1.0F };
  private float e;
  private float f;
  private boolean g;
  
  public float a(float paramFloat)
  {
    float[] arrayOfFloat1 = this.a;
    int j = arrayOfFloat1.length;
    int i = 1;
    while (i < j)
    {
      if (arrayOfFloat1[i] > paramFloat) {
        break label46;
      }
      i += 1;
    }
    i = -1;
    label46:
    if (i == -1) {
      return this.d[(j - 1)];
    }
    float[] arrayOfFloat2 = this.d;
    j = i - 1;
    float f1 = arrayOfFloat2[j];
    float f2 = arrayOfFloat1[j];
    return f1 + (arrayOfFloat2[i] - f1) * ((paramFloat - f2) / (arrayOfFloat1[i] - f2));
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.b) {
      return;
    }
    this.e = PathParticleEmitter.d(paramBufferedReader, "highMin");
    this.f = PathParticleEmitter.d(paramBufferedReader, "highMax");
    this.g = PathParticleEmitter.b(paramBufferedReader, "relative");
    this.d = new float[PathParticleEmitter.c(paramBufferedReader, "scalingCount")];
    int j = 0;
    int i = 0;
    float[] arrayOfFloat;
    StringBuilder localStringBuilder;
    for (;;)
    {
      arrayOfFloat = this.d;
      if (i >= arrayOfFloat.length) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scaling");
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
  
  public float b()
  {
    float f1 = this.e;
    return f1 + (this.f - f1) * MathUtils.a();
  }
  
  public boolean c()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.ScaledNumericValue
 * JD-Core Version:    0.7.0.1
 */