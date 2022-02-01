package com.tencent.av.opengl.ui;

import android.os.SystemClock;

public class AnimationTime
{
  private static volatile long a;
  
  public static void a()
  {
    a = SystemClock.uptimeMillis();
  }
  
  public static long b()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.AnimationTime
 * JD-Core Version:    0.7.0.1
 */