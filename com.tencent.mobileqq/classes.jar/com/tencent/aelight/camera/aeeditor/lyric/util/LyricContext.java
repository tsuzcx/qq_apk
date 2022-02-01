package com.tencent.aelight.camera.aeeditor.lyric.util;

import android.os.Handler;
import com.tencent.aelight.camera.aeeditor.lyric.common.TimerTaskManager;

public class LyricContext
{
  private static final Singleton<Handler, Void> a = new LyricContext.1();
  private static Singleton<TimerTaskManager, Void> b = new LyricContext.2();
  
  public static Handler a()
  {
    return (Handler)a.b(null);
  }
  
  public static TimerTaskManager a()
  {
    return (TimerTaskManager)b.b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.util.LyricContext
 * JD-Core Version:    0.7.0.1
 */