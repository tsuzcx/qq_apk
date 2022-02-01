package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$RangedNumericValue
  extends PathParticleEmitter.ParticleValue
{
  private float a;
  private float b;
  
  public float a()
  {
    float f = this.jdField_a_of_type_Float;
    return f + (this.b - f) * MathUtils.a();
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Float = PathParticleEmitter.a(paramBufferedReader, "lowMin");
    this.b = PathParticleEmitter.a(paramBufferedReader, "lowMax");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.RangedNumericValue
 * JD-Core Version:    0.7.0.1
 */