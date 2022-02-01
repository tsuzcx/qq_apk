package com.tencent.avgame.qav.audio.player;

import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class AVSoundHelper
{
  private static AVGameMusic jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameMusic;
  private static AVGameSound jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameSound;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static void a()
  {
    jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameMusic = new AVGameMusic();
    jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameSound = new AVGameSound();
    jdField_a_of_type_Boolean = true;
  }
  
  private static void a(Runnable paramRunnable)
  {
    ThreadManager.a(paramRunnable);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameSound == null)
    {
      i();
      return;
    }
    a(new AVSoundHelper.2(paramString, paramBoolean));
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static void b()
  {
    a(new AVSoundHelper.1());
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameMusic == null)
    {
      i();
      return;
    }
    a(new AVSoundHelper.7(paramString, paramBoolean));
  }
  
  public static void c()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameSound == null)
    {
      QLog.d("AVSoundHelper", 1, "[pauseEffects] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.4());
  }
  
  public static void d()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameSound == null)
    {
      i();
      return;
    }
    a(new AVSoundHelper.5());
  }
  
  public static void e()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameSound == null)
    {
      QLog.d("AVSoundHelper", 1, "[stopEffects] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.6());
  }
  
  public static void f()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameMusic == null)
    {
      QLog.d("AVSoundHelper", 1, "[stopBGM] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.8());
  }
  
  public static void g()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameMusic == null)
    {
      QLog.d("AVSoundHelper", 1, "[pauseBGM] AVSoundHelper not init.");
      return;
    }
    a(new AVSoundHelper.9());
  }
  
  public static void h()
  {
    if (jdField_a_of_type_ComTencentAvgameQavAudioPlayerAVGameMusic == null)
    {
      i();
      return;
    }
    a(new AVSoundHelper.10());
  }
  
  private static void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.player.AVSoundHelper
 * JD-Core Version:    0.7.0.1
 */