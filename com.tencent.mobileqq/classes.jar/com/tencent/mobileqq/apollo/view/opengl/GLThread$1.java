package com.tencent.mobileqq.apollo.view.opengl;

class GLThread$1
  implements Runnable
{
  GLThread$1(GLThread paramGLThread) {}
  
  public void run()
  {
    synchronized (GLThread.a(this.this$0))
    {
      GLThread.a(this.this$0, false);
      GLThread.a(this.this$0).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLThread.1
 * JD-Core Version:    0.7.0.1
 */