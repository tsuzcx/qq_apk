package com.tencent.mobileqq.app;

import android.os.Looper;
import mqq.os.MqqHandler;
import zui;
import zuj;

public class ThreadManager
  extends ThreadManagerV2
{
  private static volatile MqqHandler FILE_Mqq_HANDLER;
  private static volatile MqqHandler SUB_Mqq_HANDLER;
  private static volatile MqqHandler UI_Mqq_HANDLER;
  
  public static MqqHandler getFileThreadHandler()
  {
    if (FILE_Mqq_HANDLER == null) {}
    try
    {
      if (FILE_Mqq_HANDLER == null) {
        FILE_Mqq_HANDLER = new zuj(getFileThreadLooper());
      }
      return FILE_Mqq_HANDLER;
    }
    finally {}
  }
  
  public static MqqHandler getSubThreadHandler()
  {
    if (SUB_Mqq_HANDLER == null) {}
    try
    {
      if (SUB_Mqq_HANDLER == null) {
        SUB_Mqq_HANDLER = new zui(getSubThreadLooper());
      }
      return SUB_Mqq_HANDLER;
    }
    finally {}
  }
  
  public static MqqHandler getUIHandler()
  {
    if (UI_Mqq_HANDLER == null) {}
    try
    {
      if (UI_Mqq_HANDLER == null) {
        UI_Mqq_HANDLER = new MqqHandler(Looper.getMainLooper(), null, true);
      }
      return UI_Mqq_HANDLER;
    }
    finally {}
  }
  
  public static void initDPC() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManager
 * JD-Core Version:    0.7.0.1
 */