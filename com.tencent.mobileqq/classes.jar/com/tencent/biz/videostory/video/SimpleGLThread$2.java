package com.tencent.biz.videostory.video;

class SimpleGLThread$2
  implements Runnable
{
  SimpleGLThread$2(SimpleGLThread paramSimpleGLThread, Object paramObject) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.2
 * JD-Core Version:    0.7.0.1
 */