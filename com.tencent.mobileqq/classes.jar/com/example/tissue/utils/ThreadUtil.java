package com.example.tissue.utils;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class ThreadUtil
{
  private static final String TAG = "ThreadUtil";
  public static final String TISSUE_THREAD_IO = "ioThread";
  public static final String TISSUE_THREAD_JS = "v8Thread";
  static final Map<String, HandlerThread> mHandlerThreadMap = new HashMap();
  
  public static Looper getLooper(String paramString)
  {
    synchronized (mHandlerThreadMap)
    {
      HandlerThread localHandlerThread = (HandlerThread)mHandlerThreadMap.get(paramString);
      if (localHandlerThread == null)
      {
        localHandlerThread = new HandlerThread(paramString, getPriority(paramString));
        localHandlerThread.start();
        mHandlerThreadMap.put(paramString, localHandlerThread);
        paramString = localHandlerThread;
      }
      for (;;)
      {
        paramString = paramString.getLooper();
        return paramString;
        paramString = localHandlerThread;
        try
        {
          if (localHandlerThread.isAlive()) {
            continue;
          }
          localHandlerThread.start();
          paramString = localHandlerThread;
        }
        catch (IllegalThreadStateException paramString)
        {
          Log.e("ThreadUtil", "", paramString);
          paramString = localHandlerThread;
        }
      }
    }
  }
  
  private static int getPriority(String paramString)
  {
    if (paramString.hashCode() != 158179116) {}
    for (int i = -1;; i = 0)
    {
      if (i != 0) {}
      return 0;
      if (!paramString.equals("v8Thread")) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.utils.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */