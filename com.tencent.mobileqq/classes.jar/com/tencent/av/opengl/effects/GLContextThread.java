package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.av.AVLog;
import jjt;

public abstract class GLContextThread
  extends OffscreenSurface
{
  public Handler a;
  
  public GLContextThread()
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.a = new jjt(localHandlerThread.getLooper(), this);
  }
  
  public void a()
  {
    super.a();
    Process.setThreadPriority(0);
    AVLog.c("GLContextThread", "init: ");
  }
  
  public abstract void a(Message paramMessage);
  
  public void c()
  {
    super.d();
    this.a.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.effects.GLContextThread
 * JD-Core Version:    0.7.0.1
 */