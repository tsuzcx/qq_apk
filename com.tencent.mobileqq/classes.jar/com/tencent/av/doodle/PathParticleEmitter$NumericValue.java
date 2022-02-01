package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$NumericValue
  extends PathParticleEmitter.ParticleValue
{
  private float a;
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.b) {
      return;
    }
    this.a = PathParticleEmitter.d(paramBufferedReader, "value");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.NumericValue
 * JD-Core Version:    0.7.0.1
 */