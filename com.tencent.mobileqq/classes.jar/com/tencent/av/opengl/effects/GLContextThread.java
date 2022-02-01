package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.av.AVLog;

public abstract class GLContextThread
  extends OffscreenSurface
{
  protected Handler a;
  
  public GLContextThread()
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.a = new GLContextThread.MyHandler(localHandlerThread.getLooper(), this);
  }
  
  protected abstract void a(Message paramMessage);
  
  protected void b()
  {
    super.b();
    Process.setThreadPriority(0);
    AVLog.printColorLog("GLContextThread", "init: ");
  }
  
  protected void c()
  {
    super.f();
    this.a.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.GLContextThread
 * JD-Core Version:    0.7.0.1
 */