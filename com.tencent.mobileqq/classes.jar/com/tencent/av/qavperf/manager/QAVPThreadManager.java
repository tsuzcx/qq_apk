package com.tencent.av.qavperf.manager;

import android.os.HandlerThread;
import android.os.Looper;

public class QAVPThreadManager
{
  private static volatile Looper a;
  private static volatile Looper b;
  
  public static Looper a()
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("QAVP_MEMORY");
          localHandlerThread.start();
          b = localHandlerThread.getLooper();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static Looper b()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("QAVP_FPS");
          localHandlerThread.start();
          a = localHandlerThread.getLooper();
        }
      }
      finally {}
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.manager.QAVPThreadManager
 * JD-Core Version:    0.7.0.1
 */