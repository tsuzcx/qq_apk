package com.tencent.av.doodle;

public class PathParticleEmitter$SpawnEllipseSide
{
  public static int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.equals("both")) {
        return 0;
      }
      if (paramString.equals("top")) {
        return 1;
      }
      i = j;
      if (paramString.equals("bottom")) {
        i = 2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.SpawnEllipseSide
 * JD-Core Version:    0.7.0.1
 */