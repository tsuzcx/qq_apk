package com.tencent.av.doodle;

import java.io.BufferedReader;

public class PathParticleEmitter$SpawnShapeValue
  extends PathParticleEmitter.ParticleValue
{
  int a;
  int b = 0;
  boolean c;
  
  public PathParticleEmitter$SpawnShapeValue()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = PathParticleEmitter.SpawnShape.a(PathParticleEmitter.a(paramBufferedReader, "shape"));
    } while (this.jdField_a_of_type_Int != 3);
    this.c = PathParticleEmitter.a(paramBufferedReader, "edges");
    this.b = PathParticleEmitter.SpawnEllipseSide.a(PathParticleEmitter.a(paramBufferedReader, "side"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.SpawnShapeValue
 * JD-Core Version:    0.7.0.1
 */