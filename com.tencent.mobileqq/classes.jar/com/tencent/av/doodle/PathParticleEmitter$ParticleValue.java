package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$ParticleValue
{
  boolean b;
  boolean c;
  
  public void a(BufferedReader paramBufferedReader)
  {
    if (!this.c)
    {
      this.b = PathParticleEmitter.b(paramBufferedReader, "active");
      return;
    }
    this.b = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.ParticleValue
 * JD-Core Version:    0.7.0.1
 */