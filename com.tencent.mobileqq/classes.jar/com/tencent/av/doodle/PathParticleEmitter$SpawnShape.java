package com.tencent.av.doodle;

public class PathParticleEmitter$SpawnShape
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("point"))) {}
    do
    {
      return 0;
      if (paramString.equals("line")) {
        return 1;
      }
      if (paramString.equals("square")) {
        return 2;
      }
    } while (!paramString.equals("ellipse"));
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.SpawnShape
 * JD-Core Version:    0.7.0.1
 */