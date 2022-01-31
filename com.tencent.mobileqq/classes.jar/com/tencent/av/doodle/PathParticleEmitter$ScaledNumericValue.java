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
    if (i < j) {
      if (arrayOfFloat1[i] <= paramFloat) {}
    }
    for (;;)
    {
      if (i == -1)
      {
        return this.jdField_b_of_type_ArrayOfFloat[(j - 1)];
        i += 1;
        break;
      }
      float[] arrayOfFloat2 = this.jdField_b_of_type_ArrayOfFloat;
      j = i - 1;
      float f1 = arrayOfFloat2[j];
      float f2 = arrayOfFloat1[j];
      float f3 = arrayOfFloat2[i];
      return (paramFloat - f2) / (arrayOfFloat1[i] - f2) * (f3 - f1) + f1;
      i = -1;
    }
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    int j = 0;
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Float = PathParticleEmitter.a(paramBufferedReader, "highMin");
      this.jdField_b_of_type_Float = PathParticleEmitter.a(paramBufferedReader, "highMax");
      this.c = PathParticleEmitter.a(paramBufferedReader, "relative");
      this.jdField_b_of_type_ArrayOfFloat = new float[PathParticleEmitter.a(paramBufferedReader, "scalingCount")];
      int i = 0;
      while (i < this.jdField_b_of_type_ArrayOfFloat.length)
      {
        this.jdField_b_of_type_ArrayOfFloat[i] = PathParticleEmitter.a(paramBufferedReader, "scaling" + i);
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
  
  public boolean a()
  {
    return this.c;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Float + (this.jdField_b_of_type_Float - this.jdField_a_of_type_Float) * MathUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.ScaledNumericValue
 * JD-Core Version:    0.7.0.1
 */