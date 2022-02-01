package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.Looper;
import mqq.os.MqqHandler;

public class ThreadManager
  extends ThreadManagerV2
{
  private static volatile MqqHandler FILE_Mqq_HANDLER;
  private static volatile MqqHandler SUB_Mqq_HANDLER;
  private static volatile MqqHandler UI_Mqq_HANDLER;
  
  public static MqqHandler getFileThreadHandler()
  {
    if (FILE_Mqq_HANDLER == null) {
      try
      {
        if (FILE_Mqq_HANDLER == null) {
          FILE_Mqq_HANDLER = new ThreadManager.2(getFileThreadLooper());
        }
      }
      finally {}
    }
    return FILE_Mqq_HANDLER;
  }
  
  public static MqqHandler getSubThreadHandler()
  {
    if (SUB_Mqq_HANDLER == null) {
      try
      {
        if (SUB_Mqq_HANDLER == null) {
          SUB_Mqq_HANDLER = new ThreadManager.1(getSubThreadLooper());
        }
      }
      finally {}
    }
    return SUB_Mqq_HANDLER;
  }
  
  public static MqqHandler getUIHandler()
  {
    if (UI_Mqq_HANDLER == null) {
      try
      {
        if (UI_Mqq_HANDLER == null) {
          UI_Mqq_HANDLER = new MqqHandler(Looper.getMainLooper(), null, true);
        }
      }
      finally {}
    }
    return UI_Mqq_HANDLER;
  }
  
  public static void initDPC(SharedPreferences paramSharedPreferences, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager
 * JD-Core Version:    0.7.0.1
 */