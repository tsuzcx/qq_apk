package com.tencent.av.opengl.effects;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class GLContextThread$MyHandler
  extends Handler
{
  WeakReference<GLContextThread> a;
  
  GLContextThread$MyHandler(Looper paramLooper, GLContextThread paramGLContextThread)
  {
    super(paramLooper);
    this.a = new WeakReference(paramGLContextThread);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GLContextThread localGLContextThread = (GLContextThread)this.a.get();
    if (localGLContextThread != null) {
      localGLContextThread.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.GLContextThread.MyHandler
 * JD-Core Version:    0.7.0.1
 */