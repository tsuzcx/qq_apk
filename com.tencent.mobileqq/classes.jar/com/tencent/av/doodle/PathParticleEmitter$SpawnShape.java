package com.tencent.av.doodle;

public class PathParticleEmitter$SpawnShape
{
  public static int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.equals("point")) {
        return 0;
      }
      if (paramString.equals("line")) {
        return 1;
      }
      if (paramString.equals("square")) {
        return 2;
      }
      i = j;
      if (paramString.equals("ellipse")) {
        i = 3;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEmitter.SpawnShape
 * JD-Core Version:    0.7.0.1
 */