package com.tencent.biz.videostory.video;

class SimpleGLThread$4
  implements Runnable
{
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
 * Qualified Name:     com.tencent.biz.videostory.video.SimpleGLThread.4
 * JD-Core Version:    0.7.0.1
 */