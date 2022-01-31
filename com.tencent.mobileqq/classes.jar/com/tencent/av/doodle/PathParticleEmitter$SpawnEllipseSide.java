package com.tencent.av.doodle;

public class PathParticleEmitter$SpawnEllipseSide
{
  public static int a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("both"))) {}
    do
    {
      return 0;
      if (paramString.equals("top")) {
        return 1;
      }
    } while (!paramString.equals("bottom"));
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.SpawnEllipseSide
 * JD-Core Version:    0.7.0.1
 */