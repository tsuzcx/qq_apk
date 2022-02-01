package com.tencent.mobileqq.armap;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ARMapTracer$GLHackTask
  implements Runnable
{
  private static final Object d = new Object();
  private static GLHackTask e;
  private static int f = 0;
  private Runnable a;
  private GLHackTask b;
  private WeakReference<ARGLSurfaceView> c;
  
  public ARMapTracer$GLHackTask(Runnable paramRunnable, ARGLSurfaceView paramARGLSurfaceView)
  {
    this.a = paramRunnable;
    this.b = null;
    this.c = new WeakReference(paramARGLSurfaceView);
  }
  
  public static GLHackTask a(Runnable paramRunnable, ARGLSurfaceView paramARGLSurfaceView)
  {
    synchronized (d)
    {
      if (e != null)
      {
        GLHackTask localGLHackTask = e;
        e = localGLHackTask.b;
        localGLHackTask.b = null;
        localGLHackTask.a = paramRunnable;
        localGLHackTask.c = new WeakReference(paramARGLSurfaceView);
        f -= 1;
        return localGLHackTask;
      }
      return new GLHackTask(paramRunnable, paramARGLSurfaceView);
    }
  }
  
  private void a()
  {
    this.a = null;
    this.c = null;
    synchronized (d)
    {
      if (f < 50)
      {
        this.b = e;
        e = this;
        f += 1;
      }
      return;
    }
  }
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    if ((this.a != null) && (this.c.get() != null) && (!((ARGLSurfaceView)this.c.get()).mIsDestroyed)) {
      this.a.run();
    }
    l = SystemClock.elapsedRealtime() - l;
    if ((QLog.isDevelopLevel()) && (l > 33L))
    {
      String str = GLHackTask.class.getSimpleName();
      Object localObject = this.a;
      if (localObject != null) {
        localObject = localObject.getClass().getName();
      } else {
        localObject = "default";
      }
      QLog.d(str, 2, new Object[] { "%s cost: %d", localObject, Long.valueOf(l) });
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer.GLHackTask
 * JD-Core Version:    0.7.0.1
 */