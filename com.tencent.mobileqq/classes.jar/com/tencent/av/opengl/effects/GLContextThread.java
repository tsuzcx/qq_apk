package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.avcore.util.AVCoreLog;

public abstract class GLContextThread
  extends OffscreenSurface
{
  protected Handler a;
  
  public GLContextThread()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OffscreenGLThread");
    ((StringBuilder)localObject).append((int)(Math.random() * 100.0D));
    localObject = new HandlerThread(((StringBuilder)localObject).toString());
    ((HandlerThread)localObject).start();
    this.a = new GLContextThread.MyHandler(((HandlerThread)localObject).getLooper(), this);
  }
  
  protected abstract void a(Message paramMessage);
  
  protected void b()
  {
    super.b();
    Process.setThreadPriority(0);
    AVCoreLog.i("GLContextThread", "init:");
  }
  
  protected void c()
  {
    super.f();
    this.a.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.GLContextThread
 * JD-Core Version:    0.7.0.1
 */