package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$ScaledNumericValue
  extends PathParticleEmitter.RangedNumericValue
{
  private float jdField_a_of_type_Float;
  float[] jdField_a_of_type_ArrayOfFloat = { 0.0F };
  private float jdField_b_of_type_Float;
  private float[] jdField_b_of_type_ArrayOfFloat = { 1.0F };
  private boolean c;
  
  public float a(float paramFloat)
  {
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
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
      return this.jdField_b_of_type_ArrayOfFloat[(j - 1)];
    }
    float[] arrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
    j = i - 1;
    float f1 = arrayOfFloat2[j];
    float f2 = arrayOfFloat1[j];
    return f1 + (arrayOfFloat2[i] - f1) * ((paramFloat - f2) / (arrayOfFloat1[i] - f2));
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Float = PathParticleEmitter.a(paramBufferedReader, "highMin");
    this.jdField_b_of_type_Float = PathParticleEmitter.a(paramBufferedReader, "highMax");
    this.c = PathParticleEmitter.a(paramBufferedReader, "relative");
    this.jdField_b_of_type_ArrayOfFloat = new float[PathParticleEmitter.a(paramBufferedReader, "scalingCount")];
    int j = 0;
    int i = 0;
    float[] arrayOfFloat;
    StringBuilder localStringBuilder;
    for (;;)
    {
      arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
      if (i >= arrayOfFloat.length) {
        break;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("scaling");
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
  
  public boolean a()
  {
    return this.c;
  }
  
  public float b()
  {
    float f = this.jdField_a_of_type_Float;
    return f + (this.jdField_b_of_type_Float - f) * MathUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.ScaledNumericValue
 * JD-Core Version:    0.7.0.1
 */