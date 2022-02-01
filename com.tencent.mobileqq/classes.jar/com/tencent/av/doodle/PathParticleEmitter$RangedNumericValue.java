package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$RangedNumericValue
  extends PathParticleEmitter.ParticleValue
{
  private float a;
  private float d;
  
  public float a()
  {
    float f = this.a;
    return f + (this.d - f) * MathUtils.a();
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.b) {
      return;
    }
    this.a = PathParticleEmitter.d(paramBufferedReader, "lowMin");
    this.d = PathParticleEmitter.d(paramBufferedReader, "lowMax");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.RangedNumericValue
 * JD-Core Version:    0.7.0.1
 */