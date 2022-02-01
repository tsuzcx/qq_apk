package com.tencent.avgame.qav.audio.player;

import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class AVSoundHelper
{
  private static AVGameMusic a;
  private static AVGameSound b;
  private static volatile boolean c;
  
  public static void a()
  {
    a = new AVGameMusic();
    b = new AVGameSound();
    c = true;
  }
  
  private static void a(Runnable paramRunnable)
  {
    ThreadManager.a(paramRunnable);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (b == null)
    {
      l();
      return;
    }
    a(new AVSoundHelper.2(paramString, paramBoolean));
  }
  
  public static void b()
  {
    a(new AVSoundHelper.1());
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    if (a == null)
    {
      l();
      return;
    }
    a(new AVSoundHelper.7(paramString, paramBoolean));
  }
  
  public static boolean c()
  {
    return c;
  }
  
  public static void d()
  {
    if (b == null)
    {
      QLog.d("AVSoundHelper", 1, "[pauseEffects] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.4());
  }
  
  public static void e()
  {
    if (b == null)
    {
      l();
      return;
    }
    a(new AVSoundHelper.5());
  }
  
  public static void f()
  {
    if (b == null)
    {
      QLog.d("AVSoundHelper", 1, "[stopEffects] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.6());
  }
  
  public static void g()
  {
    if (a == null)
    {
      QLog.d("AVSoundHelper", 1, "[stopBGM] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.8());
  }
  
  public static void h()
  {
    if (a == null)
    {
      QLog.d("AVSoundHelper", 1, "[pauseBGM] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.9());
  }
  
  public static void i()
  {
    if (a == null)
    {
      l();
      return;
    }
    a(new AVSoundHelper.10());
  }
  
  private static void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.player.AVSoundHelper
 * JD-Core Version:    0.7.0.1
 */