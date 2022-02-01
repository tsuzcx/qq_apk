package com.peterlmeng.animate_image;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class GLThreadManager
  implements Handler.Callback
{
  private static Handler mHandler;
  private static HandlerThread mHandlerThread;
  private static Looper mLooper;
  private static GLThreadManager sInstance = new GLThreadManager();
  
  private GLThreadManager()
  {
    mHandlerThread = new HandlerThread("CameraThread");
    mHandlerThread.start();
    mLooper = mHandlerThread.getLooper();
    mHandler = new Handler(mLooper, this);
  }
  
  public static GLThreadManager getsInstance()
  {
    return sInstance;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void post(Runnable paramRunnable)
  {
    mHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.peterlmeng.animate_image.GLThreadManager
 * JD-Core Version:    0.7.0.1
 */