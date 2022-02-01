package com.tencent.mobileqq.apollo.view.opengl;

import android.util.Log;

class GLThread$1
  implements Runnable
{
  GLThread$1(GLThread paramGLThread) {}
  
  public void run()
  {
    synchronized (GLThread.a(this.this$0))
    {
      Log.i("GLThread", "surfaceDestroyed tid=" + this.this$0.getId());
      GLThread.a(this.this$0, false);
      GLThread.a(this.this$0).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThread.1
 * JD-Core Version:    0.7.0.1
 */