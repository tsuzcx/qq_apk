package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$ParticleValue
{
  boolean a;
  boolean b;
  
  public void a(BufferedReader paramBufferedReader)
  {
    if (!this.b)
    {
      this.a = PathParticleEmitter.a(paramBufferedReader, "active");
      return;
    }
    this.a = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.ParticleValue
 * JD-Core Version:    0.7.0.1
 */