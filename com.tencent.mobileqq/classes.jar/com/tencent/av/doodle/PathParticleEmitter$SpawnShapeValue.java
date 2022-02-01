package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$SpawnShapeValue
  extends PathParticleEmitter.ParticleValue
{
  int a = 0;
  boolean d;
  int e = 0;
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.b) {
      return;
    }
    this.a = PathParticleEmitter.SpawnShape.a(PathParticleEmitter.a(paramBufferedReader, "shape"));
    if (this.a == 3)
    {
      this.d = PathParticleEmitter.b(paramBufferedReader, "edges");
      this.e = PathParticleEmitter.SpawnEllipseSide.a(PathParticleEmitter.a(paramBufferedReader, "side"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.SpawnShapeValue
 * JD-Core Version:    0.7.0.1
 */